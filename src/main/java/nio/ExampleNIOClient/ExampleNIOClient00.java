package nio.ExampleNIOClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ExampleNIOClient00 {
    private static final int PORT = 9090;
    private static final String ADDRESS = "localhost";
    private ByteBuffer buffer = ByteBuffer.allocate(16);

    public static void main(String[] args) throws IOException {
        new ExampleNIOClient00().run();
    }

    private void run() throws IOException {
        // SoketChannel.open() tolko sozdaiet channel no ne otcruvaet eho kak zdaiotsa po znacheniy slova open
        SocketChannel channel = SocketChannel.open();
        // method configureBlocking() esli olychaet false to channel delaetsa ne blociryywchim
        // (no prietom nado dymat pro mnohopotochnost) a esli daetsa true to chanel blokiryiywchui
        channel.configureBlocking(false);
        // Selector.open() sozdaet selector
        Selector selector = Selector.open();
        //channel.register() sviazevaet channel s selector i zadaiot parameter OP_CONNECT kotorui vvodit
        // channel v sostoianie chto k nemy bydyt potklychatsa
        channel.register(selector, SelectionKey.OP_CONNECT);
        // channel.connect() podklychaet eho k zadanum parametram
        channel.connect(new InetSocketAddress(ADDRESS, PORT));
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();
                if ("q".equals(line)) System.exit(0);

                try {
                    queue.put(line);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // zdes s pomowchy cannel i eho selector sosdaion deistvie SelectionKey
                SelectionKey key = channel.keyFor(selector);
                // eto deistvie chto mu sozdali tolko wto delaem eho na zapis
                key.interestOps(SelectionKey.OP_WRITE);
                selector.wakeup();
            }
        }).start();

        while (true) {
            // esli selektor ne imeet kanalov s kakimto deistvem selector zdes zasupaet do toho
            // vremeni poka nepoiavetsa kakoeto deistvie v kanalax i etot ze kanal kotorui polychil
            // deistvie dolzen probydit selector selector.wakeup()
            selector.select();
            // selector.selectorKeys() vozvrawchaet vse eventu kotorue imeet selector v ozidanii na vupolnenie
            for (SelectionKey selectionKey : selector.selectedKeys()) {
                // zdes mu proveriraem est li evento "connection" esli est takoe evento to
                // mu eho zapyskaes s pomowchiy channel.finishConnect() . (Mozet kazatsa chto channel.finishConnection
                // on zakanchvaet conection no eto ne tak on zakanchivaet zapuskat connection tobto posle vuzova
                // channel.finishConnection() connection bydet ostatochno zapuwcheno).
                if (selectionKey.isConnectable()) {
                    channel.finishConnect();
                    // posle toho kak channel podklychilsa s pomowchy selectionKey.interestOps() mu zadaiem
                    // novoe deistvie etomu channel na OP_WRITE toest na chenie
                    selectionKey.interestOps(SelectionKey.OP_WRITE);
                    // zdes proviriaem na to chto selectionKey.isReadable
                } else if (selectionKey.isReadable()) {
                    // zdes mu ochiwchaem buffer eto nado delat ves chas potomu chto buffer ves chas hriaznui
                    // no buffer.clear() on ne ochiwchaet byffer on tolko sbrasevaet markeru v buffere i takim
                    // obrazom byfer kak bytto stanovitsa chistum no informacia tolko perepisuvaitsa v buffer s nachala
                    buffer.clear();
                    channel.read(buffer);
                    System.out.println("Received = " + new String(buffer.array()));
                } else if (selectionKey.isWritable()) {
                    String line = queue.poll();
                    if (line != null) {
                        channel.write(ByteBuffer.wrap(line.getBytes()));
                    }
                    selectionKey.interestOps(SelectionKey.OP_READ);
                }
            }
        }
    }
}
