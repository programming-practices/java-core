package exceptions.Others;

public class PrubasException {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread);

        thread.setName("New name!");
        System.out.println(thread);

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
