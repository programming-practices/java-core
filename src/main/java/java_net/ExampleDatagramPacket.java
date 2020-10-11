package java_net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Demonstrate Datagrams.
public class ExampleDatagramPacket {
    public final static int serverPort = 11998;
    public final static int clientPort = 11999;
    public final static int buffer_size = 1024;
    public static DatagramSocket datagramSocket;
    public static byte buffer[] = new byte[buffer_size];

    public static void theServer() throws Exception {
        int pos = 0;
        while (true) {
            int c = System.in.read();
            switch (c) {
                case -1:
                    System.out.println("Server Quits.");
                    datagramSocket.close();
                    return;
                case '\r':
                    break;
                case '\n':
                    datagramSocket.send(new DatagramPacket(buffer, pos,
                            InetAddress.getLocalHost(), clientPort));
                    pos = 0;
                    break;
                default:
                    buffer[pos++] = (byte) c;
            }
        }
    }

    public static void theClient() throws Exception {
        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }

    public static void main(String args[]) throws Exception {
        if (args.length == 1) {
            datagramSocket = new DatagramSocket(serverPort);
            theServer();
        } else {
            datagramSocket = new DatagramSocket(clientPort);
            theClient();
        }
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
На платформе Java поддерживается также
протокол UDP (User Datagram Protocol — протокол пользовательских дейтаграмм), который
может служить для отправки пакетов (называемых иначе дейтаграммами] с гораздо меньшими
издержками, чем по протоколу TCP. Недостаток такого способа обмена данными по сети
заключается в том, что пакеты необязательно доставлять получателю в последовательном
порядке, и они вообще могут быть потеряны. Получатель сам должен позаботиться о том, чтобы
пакеты были организованы в определенном порядке, а кроме того, он должен сам
запрашивать повторно передачу отсутствующих пакетов. Протокол UDP хорошо подходит для тех
приложений, которые могут обходиться без отсутствующих пакетов, например, для организации
аудио- и видеопотоков или продолжительных измерений.
----------------------------------------------------------------------------------------------------------------------
Дейтаграмм ы - это порции данных, передаваемых между машинами. В некото­
ром отношении они подобны сильным броскам тренированного, но подслеповато­
го принимающего в сторону третьего бейсмена в бейсболе. Даже если дейтаграм·
ма и передается в нужном направлении, нет никаких гарантий , что она достигнет
цели или кто-нибудь окажется на месте, чтобы ее перехватить. Аналогично, когда
дейтаграмма принимается, нет никакой гарантии, что она не была повреждена
при передаче или что ее отправитель все еще ожидает ответа.
Дейтаграммы реализуются в java поверх сетевого протокола UDP с помощью
двух классов: Da tagramPac k e t ( контейнер данных) и DatagramSocket (механизм
для передачи и приема пакетов типа DatagramPacket ) . Каждый из этих IUiaccoв
рассматривается далее по отдельности.
----------------------------------------------------------------------------------------------------------------------
*/
