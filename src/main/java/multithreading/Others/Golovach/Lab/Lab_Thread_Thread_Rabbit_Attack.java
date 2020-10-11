package YouTube_Channels.Golovach_Courses.Java_Core_October_2013.Core_Multithreading_3_October_2013.Lab;

public class Lab_Thread_Thread_Rabbit_Attack {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String spaces = spaces(i);
            Runnable printer = new PrintRunnable(spaces + i, 100);
            Thread thread = new Thread(printer);
            thread.start();
            Thread.sleep(100);
        }
    }


    public static String spaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }

}
