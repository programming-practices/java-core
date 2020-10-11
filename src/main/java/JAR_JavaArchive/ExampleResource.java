package JAR_JavaArchive;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Cay Horstmann
 * @version 1.41 2015-06-12
 */
public class ExampleResource {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ResourceTestFrame();
            frame.setTitle("ResourceTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame that loads image and text resources.
 */
class ResourceTestFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ResourceTestFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        /*Дело в том, что загрузчик класса помнит, где располагается класс, и может обна­ружить там же файлы ресурсов. Например, 
         * чтобы создать пиктограмму, хранящуюся в файле about.gif, следует воспользоваться приведенным ниже фрагментом кода.
		 * Этот код, по существу, означает следующее: "искать файл about.gif там же, где на­ходился файл AboutPanel.class".
								URL url = ResourceTest.class.getResource("about.gif");
								Image img = new Imagelcon(url).getlmage();*/
        // V etom variante ne rabobotaetURL aboutURL = getClass().getResource()
//      URL aboutURL = getClass().getResource("/root/Datos/Programacion/java_lessons/src/main/resources/JAR_JavaArchive/about.gif");
//      Image img = new ImageIcon(aboutURL).getImage();
        Image img = new ImageIcon("src/main/resources/JAR_JavaArchive/about.gif").getImage();
        setIconImage(img);

        JTextArea textArea = new JTextArea();
        // V etom variante ne rabobotaet getClass().getResourceAsStream()
//        InputStream stream = getClass().getResourceAsStream("/root/Datos/Programacion/java_lessons/src/main/resources/JAR_JavaArchive/about.txt");
        InputStream stream = null;
        try {
            stream = new FileInputStream("src/main/resources/JAR_JavaArchive/about.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (Scanner in = new Scanner(stream, "UTF-8")) {
            while (in.hasNext())
                textArea.append(in.nextLine() + "\n");
        }
        add(textArea);
    }
}
