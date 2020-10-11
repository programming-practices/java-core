package java_net.a2;

public class ProbaNaPotokoBezopasnostServera {
    public static void main(String[] args) {

        // probyiy na potoko bezopasnist
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ExampleClientSocket_My clientSocket = new ExampleClientSocket_My("localhost", 8189);
                    for (int i = 0; i < 10; i++) {
//                        System.out.println("--------------------------------------------------------------");
                        clientSocket.startClient();
//                        System.out.println("--------------------------------------------------------------");
                    }
                }
            }).start();
        }


    }
}
