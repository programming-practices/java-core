package Examples.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Cay Horstmann
 * @version 1.33 2015-05-12
 */
public class ExampleJComponent {
    public static void main(String[] args) {
////---------------------------------------------------------------------------------------------------------------------
//        EventQueue.invokeLater(() ->
//        {
//            JFrame frame = new NotHelloWorldFrame();
//            frame.setTitle("NotHelloWorld");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//        });
//---------------------------------------------------------------------------------------------------------------------
        /*В языке Java фреймы предназначены именно для того, чтобы служить контейнерами для компонентов (например, меню
        или других элементов пользовательского интерфейса). Как правило, рисунки выводятся в другом компоненте, который
        добавляется во фрейм.*/
        EventQueue.invokeLater(() ->
        {
            JFrame jFrame = new MyFrame();
            jFrame.setTitle("MyApp");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        });
//---------------------------------------------------------------------------------------------------------------------
//        /**
//         * @author Cay Horstmann
//         * @version 1.33 2007-05-12
//         */
//        EventQueue.invokeLater(() ->
//        {
//            JFrame frame = new DrawFrame();
//            frame.setTitle("DrawTest");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//        });
//---------------------------------------------------------------------------------------------------------------------
    }
}

/**
 * A frame that contains a panel with drawings
 */
class DrawFrame extends JFrame {
    public DrawFrame() {
        add(new DrawComponent());
        pack();
    }
}

/**
 * A component that displays rectangles and ellipses.
 */
class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // draw a rectangle

        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

        // draw the enclosed ellipse

        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        // draw a diagonal line

        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        // draw a circle with the same center

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}


/**
 * A frame that contains a message panel
 */
class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() {
        add(new NotHelloWorldComponent());
        /*Если при заполнении фрейма одним или несколькими компонентами требуется лишь воспользоваться их предпочтительными
        размерами, то вместо метода setSize() вызывается метод pack ():*/
        pack();
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension demesion = toolkit.getScreenSize();
        super.setBounds(demesion.width / 2 - 250, demesion.height / 2 - 150, demesion.width / 3, demesion.height / 2);
    }
}

/**
 * A component that displays a message.
 */
class NotHelloWorldComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
//        g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
        g.drawString("Not a Hello, World program", 5, 20);
    }

    /*И наконец, компонент должен сообщить своим пользователям, насколько большим он должен быть. Для этого переопределяется
    метод getPreferredSize(), возвращающий объект класса Dimension с предпочтительными размерами по ширине и по высоте:*/
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

class MyFrame extends JFrame {
    public MyFrame() throws HeadlessException {
        add(new MyComponentText());
//        add(new MyComponentImage());
//        add(new MyComponentEllipse2D());
//        add(new MyComponentLine2D());
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension demesion = toolkit.getScreenSize();
        super.setBounds(demesion.width / 2 - 250, demesion.height / 2 - 150, demesion.width / 3, demesion.height / 2);
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
Чтобы отобразить компонент, следует сначала определить класс, расширяющий класс JComponent, а затем переопределить метод
paintComponent() этого класса. Метод paintComponent() получает в качестве параметра объект типа Graphics, который содержит
набор установок для отображения рисунков и текста. В нем, например, задается шрифт и цвет текста. Все операции рисования
графики в Java выполняются с помощью объектов класса Graphics. В этом классе предусмотрены методы для рисования узоров,
графических изображений и текста.
-----------------------------------------------------------------------------------------------------------------------
СОВЕТ. Если требуется принудительно перерисовать экран, вместо метода paintComponent() следует вызвать метод repaint().
Этот метод, в свою очередь, обратится к методу paintComponent() каждого компонента и передаст ему настроенный должным
образом объект типа Graphics.
-----------------------------------------------------------------------------------------------------------------------
*/
/*Chtobu ne resovat priamo na freime dobavim JComponent i bydem resovat na nom*/
class MyComponentText extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        Font font = new Font("Courier New", Font.BOLD, 16);
        /*Graphics eto starui class v nom ne nozno vrawchat fihyru kotorue mu v nom sozdaiom a Graphics2D yze novee i
          dozvoliaet delat bolwe vewchei. Graphics2D nasledetsa ot Graphics*/
        Graphics2D graphics2D = (Graphics2D) g;
        /*zdes ystanavlivaem font*/
        graphics2D.setFont(font);
        /*a zdes hovorim chtobu naresola string*/
        graphics2D.drawString("Hello World", 5, 20);
    }
}

class MyComponentLine2D extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        //Malye liney, pri sozdanii linii mozno priamo ykazevat koordenatu a mozno peredavat tochki Point2D
        Point2D point2D_1 = new Point2D.Double(10, 40);
        Point2D point2D_2 = new Point2D.Double(300, 40);
//            Line2D line2D = new Line2D.Double(70, 70, 300, 70);
        Line2D line2D = new Line2D.Double(point2D_1, point2D_2);
        graphics2D.draw(line2D);
    }
}

class MyComponentEllipse2D extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        // zdes sodadiemo ellipse
//            Ellipse2D ellipse2D = new Ellipse2D.Double(400, 10, 80, 50);
        // mozno zdelat eto s pomowchy points2D
//        Ellipse2D ellipse2D = new Ellipse2D.Double();
        Ellipse2D ellipse2D = new Ellipse2D.Double(150, 200, 100, 50);
        Point2D point2D_11 = new Point2D.Double(300, 100);
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

/*Но иногда бывает нелегко определить, где должен находиться левый верхний угол двухмерной формы. Нередко прямоугольник
задается противоположными вершинами, но они совсем не обязательно соответствуют левому верхнему и нижнему правому углу.
В этом случае построить прямоугольник нельзя, как показано ниже.
                Rectangle2D rect = new Rectangle2D.Double(рх, py, qx - px, qy - py); // ОШИБКА!
Если параметр p не соответствует координатам верхнего левого угла, то одна или обе разности координат окажутся отрицательны
ми, а прямоугольник — пустым. В таком случае нужно сначала создать пустой прямоугольник, а затем вызвать метод
setFrameFromDiagonal() следующим образом:
                Rectangle2D rect = new Rectangle2D.Double();
                rect.setFrameFromDiagonal(px, py, qx, qy);*/
class MyComponent extends JComponent {
    @Override
    protected void printComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        Rectangle2D rectangle2D = new Rectangle2D.Double();

    }
}

class MyComponentImage extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        //resyem image
//       try {
//           URL url = new URL("https://elbauldelprogramador.com/img/2012/12/java1.jpg");
//           Image image = new ImageIcon(url).getImage();
        Image image = new ImageIcon("/root/Datos/Programacion/java_lessons/src/main/resources/cay.jpg").getImage();
        graphics2D.drawImage(image, 50, 50, null);
//       } catch (MalformedURLException e) {
//            e.printStackTrace();
//       }
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Параметр типа Graphics сродни контексту устройства в среде Windows или графическому контексту в среде Х11.
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Вместо расширения класса JCo mp on e n t некоторые программисты предпочитают расширять класс JPanel, предназначенный
в качестве контейнера для других компонентов, хотя рисовать можно и в нем самом. Следует только иметь в виду одно существенное
отличие. Панель непрозрачна , а это означает, что она отвечает за рисование всех пикселей в ее границах. Чтобы нарисовать
компоненты в этих границах, проще всего залить панель цветом фона, сделав вызов super.paintConponent() в методе paintComponen()
каждого подкласса панели следующим образом:
                        class NotHelloWorldPanel extends JPanel{
                            public void paintComponent(Graphics g){
                                super.paintComponent(g);
                                код для рисования
                            }
                        }
-----------------------------------------------------------------------------------------------------------------------
СОВЕТ. Если требуется принудительно перерисовать экран, вместо метода paintComponent() следует вызвать метод repaint().
Этот метод, в свою очередь, обратится к методу paintComponent() каждого компонента и передаст ему настроенный должным
образом объект типа Graphics.
-----------------------------------------------------------------------------------------------------------------------
•void paintComponent (Graphics g)
    Этот метод переопределяется для описания способа рисования заданного компонента.

•FontMetrics getFontMetrics(Font fArgInt ) 5.0
    Получает типографские характеристики заданного шрифта. Класс FontMetrics является предшественником класса LineMetrics.

•ActionMap getActionMapO 1 .3
    Возвращает привязку действия, связывающую назначенны е клавиши действий, которые могут быть произвольными объектами,
    с объектами класса, реализующего интерфейс Action.

•InputMap getInputMap(int flag) 1 .3
    Получает привязку ввода, связывающую нажатия клавиш с клавишами действий.
        Параметры:
                flag: Одно из условий для фокуса ввода
                      с клавиатуры, по которому инициируется
                      действие (см. табл. 11.2)
-----------------------------------------------------------------------------------------------------------------------
*/