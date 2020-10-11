package nio.ExampleNIOServer;


public class ExampleNIOServer {
//    private static final String ADDRESS = "localhost";
//    private static final int PORT = 9090;
//    private Selector selector;
//    private ByteBuffer readBuffer = ByteBuffer.allocate(8192);
//    private EchoWorker worker = new EchoWorker();
//    private final List<ChangeRequest> changeRequests = new LinkedList<>();
//    private final Map<SocketChannel, List<ByteBuffer>> pendingData ;
//
//
//    public ExampleNIOServer() throws IOException {
//        ServerSocketChannel serverChannel = ServerSocketChannel.open();
//        serverChannel.configureBlocking(false);
//        InetSocketAddress isa = new InetSocketAddress(ADDRESS, PORT);
//        serverChannel.socket().bind(isa);
//        selector = SelectorProvider.provider().openSelector();
//        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
//        new Thread(worker).start();
//    }
//
//    private void run() throws IOException {
//        while (true){
//            synchronized (changeRequests){
//                for (ChangeRequest change: changeRequests){
//                        switch (change.type){
//                            case CHANGEOPS:
//                                SelectionKey key = change.socket.keyFor(selector);
//                                key.interestOps(change.ops);
//                                break;
//                            default:
//                        }
//                }
//                changeRequests.clear();
//            }
//            selector.select();
//            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
//            while (selectedKeys.hasNext()){
//                SelectionKey key = selectedKeys.next();
//                selectedKeys.remove();
//                if (!key.isValid())continue;
//                if (key.isAcceptable()){
//                    accept(key);
//                }else if (key.isReadable()){
//                    read(key);
//                }else if (key.isWritable()){
//                    write(key);
//                }
//            }
//        }
//    }
//
//    private void accept(SelectionKey key) throws IOException {
//        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
//        SocketChannel socketChannel = serverSocketChannel.accept();
//        socketChannel.configureBlocking(false);
//        socketChannel.register(selector, OP_READ);
//    }
//    private void read(SelectionKey key) throws IOException {
//        SocketChannel socketChannel = (SocketChannel) key.channel();
//        readBuffer.clear();
//        int numRead = socketChannel.read(readBuffer);
//        worker.processData(this, socketChannel, readBuffer.array(), numRead)
//    }
//
//    private void write(SelectionKey key) throws IOException {
//        SocketChannel socketChannel = (SocketChannel) key.channel();
//        synchronized (pendingData){
//            List<ByteBuffer> queue = pendingData.get(socketChannel);
//            while (!queue.isEmpty()){
//                ByteBuffer buf = queue.get(0);
//                socketChannel.write(buf);
//                if (buf.remaining() > 0){
//                    break;
//                }
//                System.out.println("Send echo = ");
//                queue.remove(0);
//            }
//            if (queue.isEmpty()){
//                key.interestOps(OP_READ);
//            }
//        }
//    }
//
//    void send(SocketChannel socket, byte[] data){
//        synchronized (changeRequests){
//            changeRequests.add(new ChangeRequest(socket, CHANGEOPS, OP_WRITE));
//            synchronized (pendingData){
//                List<ByteBuffer> queue = pendingData.get(socket);
//                if (queue == null){
//                    queue = new ArrayList<>();
//                    pendingData.put(socket, queue);
//                }
//                queue.add(ByteBuffer.wrap(data));
//            }
//        }
//        selector.wakeup();
//    }
//
//    public static void main(String[] args) throws IOException {
//        new ExampleNIOServer().run();
//    }
}




