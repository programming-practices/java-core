package awt_abstract_window_toolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class ExampleGraphics2D {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MyFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Example Graphics2D");
            frame.setVisible(true);
        });

    }
}

class MyFrame extends JFrame {
    public MyFrame() throws HeadlessException {
        add(new MyComponentEllipse2D());
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension demesion = toolkit.getScreenSize();
        super.setBounds(demesion.width / 2 - 250, demesion.height / 2 - 150, demesion.width / 3, demesion.height / 2);
    }
}

class MyComponentEllipse2D extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        // zdes sodadiemo ellipse
//            Ellipse2D ellipse2D = new Ellipse2D.Double(400, 10, 80, 50);
        // mozno zdelat eto s pomowchy points2D
        Ellipse2D ellipse2D = new Ellipse2D.Double();
        Point2D point2D_11 = new Point2D.Double(400, 10);
        Point2D point2D_21 = new Point2D.Double(80, 50);
        ellipse2D.setFrameFromDiagonal(point2D_11, point2D_21);
        graphics2D.draw(ellipse2D);
        // zdes ykazyem kolor zamolovki
//            graphics2D.setPaint(new Color(19,30,4));
        graphics2D.setPaint(Color.GREEN);
        // s pomoschyi fill zapolniaem elipse
        graphics2D.fill(ellipse2D);
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
А в версии Java SE 1.2 была внедрена библиотека Java 2D, в которой реализован целый ряд эффективных операций рисования
двухмерной графики.
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! До появления библиотеки Java 2D программирующие на Java пользовались для рисования двухмерныхформ методами из
класса Graphics, например, методом drawRectangle(). На первый взгляд старый способ вызова методов выглядит немного проще.
Но, пользуясь библиотекой Java 2D, программист получает большую свободу действий, поскольку он может впоследствии
уточнить и улучшить нарисованные формы, используя многочисленные средства, предусмотренные в этой библиотеке.
-----------------------------------------------------------------------------------------------------------------------
Чтобы нарисовать двухмерную форму средствами библиотеки Java 2D, нужно создать объект класса Graphics2D. Это подкласс,
производный от класса Graphics. Начиная с версии Java SE 2, такие методы, как paintComponent(), автоматически получают
объекты класса Graphics 2d. Нужно лиш ь произвести соответствующее приведение типов, как показано ниже.
                    public void paintComponent(Graphics g){
                        Graphics2D g2 = (Graphics2D) g;
                    }
При создании геометрических форм в библиотеке Java 2D применяется объектно-ориентированный подход. В частности, перечисленные
ниже классы, предназначенные для рисования линий, прямоугольников и эллипсов, реализуют интерфейс Shape.
Line2D
Rectangle2D
Ellipse2D
-----------------------------------------------------------------------------------------------------------------------
•Paint getPaint()
•void setPaint(Paint p )
    Получают или устанавливают атрибуты рисования для данного графического контекста. Класс Color реализует интерфейс Paint.
    Этот метод можно использовать для задания сплошного цвета при рисовании.

•void fill(Shape з )
    Заполняет текущую нарисованную форму.

•FontRenderContext getFontRenderContext()
    Получает контекст воспроизведения, в котором задаются характеристики шрифта для текущего графического контекста.

•void drawstring(String s t r , float x , float y)
    Выводит текстовую строку, выделенную текущим шрифтом и цветом.
        Параметры:
            str: Выводимая текстовая строка
              х: Координата х начала строки
              у: Координата у базовой линии строки
-----------------------------------------------------------------------------------------------------------------------
*/