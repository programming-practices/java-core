package awt_abstract_window_toolkit;

import javax.swing.*;
import java.awt.*;

public class ExampleImageIcon {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new ImageFrame();
            frame.setTitle("ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with an image component
 */
class ImageFrame extends JFrame {
    public ImageFrame() {
        add(new ImageComponent());
        pack();
    }
}

/**
 * A component that displays a tiled image
 */
class ImageComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private Image image;

    public ImageComponent() {
        String path = "/root/Datos/Programacion/java_lessons/src/main/resources/Swing_Examples/blue-ball.gif";
        image = new ImageIcon(path).getImage();
    }

    public void paintComponent(Graphics g) {
        if (image == null) return;

        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        // draw the image in the upper-left corner

        g.drawImage(image, 0, 0, null);
        // tile the image across the component
        /*Программа из листинга 10.6 делает немного больше, многократно выводя указанное изображен ие в окне рядами. Результат
        выполнения этой программы приведен на рис. 10.15 . Вывод изображения рядами осуществляется с помощью метода
        paintComponent(). Сначала одна копия изображения воспроизводится в левом верхнем углу окна, а затем вызывается
        метод соруАгеа(), который копирует его по всему окну, как показано ниже.*/
        for (int i = 0; i * imageWidth <= getWidth(); i++)
            for (int j = 0; j * imageHeight <= getHeight(); j++)
                if (i + j > 0)
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
•Imagelcon(String имя__файла)
        Конструирует пиктограмму, изображение которой хранится в файле.

•Image getlmage()
        Получает изображение данной пиктограммы.
-----------------------------------------------------------------------------------------------------------------------
*/
