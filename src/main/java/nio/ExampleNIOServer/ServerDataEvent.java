package nio.ExampleNIOServer;

import java.nio.channels.SocketChannel;

public class ServerDataEvent {
    public SocketChannel socket;
    public byte[] data;
    ExampleNIOServer server;

    public ServerDataEvent(ExampleNIOServer server, SocketChannel socket, byte[] data) {
        this.server = server;
        this.socket = socket;
        this.data = data;
    }
}
