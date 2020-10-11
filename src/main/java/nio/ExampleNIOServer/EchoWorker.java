package nio.ExampleNIOServer;

import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

public class EchoWorker implements Runnable {
    private final List<ServerDataEvent> queue = new LinkedList<>();

    void processData(ExampleNIOServer server, SocketChannel socket, byte[] data, int count) {
        byte[] dataCopy = new byte[count];
        System.arraycopy(data, 0, dataCopy, 0, count);
        synchronized (queue) {
            queue.add(new ServerDataEvent(server, socket, dataCopy));
            queue.notify();
        }
    }

    @Override
    public void run() {
//        ServerDataEvent dataEvent;
//        while (true){
//            synchronized (queue){
//                while (queue.isEmpty()){
//                    try {
//                        queue.wait();
//                    } catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println("Received = " + new String(queue.get(0).data));
//                dataEvent = queue.remove();
//            }
//            dataEvent.server.send(dataEvent.socket, dataEvent.data);
//        }
    }
}
