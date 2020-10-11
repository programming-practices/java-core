package java_lang;

public class ExampleProcessBuilderStart {
    public static void main(String args[]) {

        try {
            // eta programa rabotait tolko na windows
            ProcessBuilder proc = new ProcessBuilder("notepad.exe", "testfile");
            proc.start();
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }
    }
}

