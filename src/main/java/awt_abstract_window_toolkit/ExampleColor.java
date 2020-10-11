package awt_abstract_window_toolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ExampleColor {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame jFrame = new MyFrameColor();
            jFrame.setTitle("tem.Test Color");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
            /*Чтобы установить цвет фона, следует вызвать метод setBackground() из класса Component, предшественника класса Jpanel:
                                MyComponent р = new MyComponent();
                                р.setBackground(Color.PINK);
            Существует также метод setForeground(). Он задает цвет переднего плана, который используется при рисовании компонента.*/
//            jFrame.getContentPane().setBackground(Color.PINK);
//            jFrame.getContentPane().setForeground(Color.PINK);
            /*Для большинства известных цветов в классе SystemColor предусмотрены символические имена. Константы в этом классе
            определяю тe цвета, которые используются для окраски различных элементов пользовательского интерфейса. Например,
            в приведенной ниже строке кода для фона фрейма выбирается цвет, задаваемый по умолчанию для всех окон
            пользовательского интерфейса,
                        р.setBackground(SystemColor.window)
            Фон заполняет окно при каждой перерисовке. Пользоваться цветами, заданными в классе SystemColor, особенно удобно,
            если требуется, чтобы пользовательский интерфейс был выдержан в той же цветовой гамме, что и рабочий стол
            операционной системы. В табл. 10.1 приведены названия системных цветов и их краткое описание.*/
            jFrame.getContentPane().setBackground(SystemColor.window);
        });
    }
}

class MyFrameColor extends JFrame {
    public MyFrameColor() throws HeadlessException {
        add(new MyComponentColor());
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension demesion = toolkit.getScreenSize();
        super.setBounds(demesion.width / 2 - 250, demesion.height / 2 - 150, demesion.width / 3, demesion.height / 2);
    }
}

class MyComponentColor extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        //-----------------------Paint-String------------------------------------------
//        Graphics2D graphics2D = (Graphics2D)g;
//        /*Метод setPaint() из класса Graphics2D позволяет выбрать цвет, который будет
//        применяться при всех дальнейших операциях рисования в графическом контексте.*/
//        graphics2D.setPaint(Color.RED);
//        graphics2D.drawString("Warning", 5, 20);
        //------------------------Paint-Rectangle--------------------------------------
        /*Окрашивать цветом можно внутренние участки замкнутых геометрических форм вроде прямоугольников или эллипсов.
        Для этого вместо метода draw() достаточно вызвать метод fill() следующим образом:*/
        Graphics2D graphics2D = (Graphics2D) g;
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
//        Rectangle2D rect = new Rectangle2D.Double(0, 0, 10, 20);
        /*Имеется возможность указать произвольный цвет по его красной, зеленой и синей составляющим, создав объект класса
        Color. В конструкторе класса Color составляющие цветов задаются целыми значениями в пределах от 0 до 255 (т.е.
        одним байтом)следующим образом:
                                Color(int redness, int greenness, int blueness)
        Ниже приведен пример установки специального цвета.*/
        Color color = new Color(0, 128, 128);   // скучный сине-зеленый цвет
        /*СОВЕТ. Методы brighter() и darker() из класса Color позволяют устанавливать более светлые или темные оттенки
        текущего цвета соответственно. Используя метод brighter(), можно,например, без труда выделить заголовок или пункт
        меню. На самом деле одного вызова метода brighter() для увеличения яркости цвета явно недостаточно. Для того чтобы
        достичь заметного эффекта, желательно вызвать его трижды подряд: с.brighter().brighter().brighter().*/
        graphics2D.setPaint(color.brighter().brighter().brighter());
//        graphics2D.setPaint(Color.RED);
        /*HA ЗАМЕТКУ! В методе fill() окрашивание цветом осуществляется на один пиксель меньше вправо и вниз. Так, если
        сделать вызов new Rectangle2D.Double(0, 0, 10, 20), чтобы нарисовать новый прямоугольник, то в нарисованную форму
        войдут пиксели с координатами х=10 и у=20. Если ж е заполнить ту ж е самую прямоугольную форму выбранным цветом,
        то пиксели с этими координатами не будут окрашены.*/
        graphics2D.fill(rect);    // заполнить прямоугольник красным цветом
        graphics2D.draw(rect);
        /*Для окрашивания разными цветами следует выбрать определенный цвет, нарисовать или заполнить одну форму, затем
        выбрать новый цвет, нарисовать или заполнить дручую форму и т.д.*/
        //--------------------------Paint-Sting-Different-Form---------------------------------------------------
//        Font font = new Font("Courier New", Font.BOLD, 16);
//        Graphics2D graphics2D = (Graphics2D) g;
//        graphics2D.setFont(font);
//        graphics2D.drawString("Hello World", 5, 20);
        //-----------------------------------------------------------------------------
    }
}


//        EventQueue.invokeLater(() -> {
//            JFrame jFrame = new MyJFrameColor();
//            jFrame.setTitle("Example Color");
//            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jFrame.setVisible(true);
//        });
//    }
//}
//
//class MyJFrameColor extends JFrame {
//    public MyJFrameColor(){
//        add(new MyComponentColor());
////        pack();
//    }
//
//    @Override
//    public void setBounds(int x, int y, int width, int height) {
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension demesion = toolkit.getScreenSize();
//        super.setBounds(demesion.width / 2 - 250, demesion.height / 2 - 150, demesion.width / 3, demesion.height / 2);
//    }
//}
//
//class MyComponentColor extends JComponent{
//    @Override
//    protected void printComponent(Graphics g) {
////        Graphics2D graphics2D = (Graphics2D)g;
////        graphics2D.setPaint(Color.RED);
////        graphics2D.drawString("Warning", 100, 100);
//        Font font = new Font("Courier New", Font.BOLD, 16);
//        Graphics2D graphics2D = (Graphics2D) g;
//        graphics2D.setFont(font);
//        graphics2D.drawString("Hello World", 5, 20);
//    }
//}

/*
-----------------------------------------------------------------------------------------------------------------------
Цвет определяется с помощью класса Color. Класс java.awt.Color содержит следующие константы, соответствующие 13 стандартным
цветам: BLACK (ЧЕРНЫЙ), BLUE(СИНИЙ), CYAN (ГОЛУБОЙ), DARK GRAY (ТЕМНО-СЕРЫЙ), GRAY (СЕРЫЙ), GREEN(ЗЕЛЕНЫЙ), LIGHT GRAY
(СВЕТЛО-СЕРЫЙ), MAGENTA (ПУРПУРНЫЙ), ORANGE (ОРАНЖЕВЫЙ), PINK (РОЗОВЫЙ), RED (КРАСНЫЙ), WHITE (БЕЛЫЙ), YELLOW (ЖЕЛТЫЙ).
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! До версии Java SE 1.4 имена констант, определяющих цвет, задавались арочными буквами, например Color.red И это
довольно странно, поскольку константам принято присваивать имена, набранные прописными буквами. Начиная с версии Java SE 1.4,
стандартные названия цветов указываются как прописными, так и строчными буквами (для сохранения обратной совместимости).
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Кроме сплошного цвета, можно выбирать более сложные “палитры” с изменением оттенков или рисунков. Подробнее
об речь пойдет в главе, посвященной расширенным средствам из библиотеки AWT, второго тома настоящего издания. Если вместо
объекта типа Graphics2D используется объект типа Graphics, то для установки цвета следует вызывать метод setColor().
-----------------------------------------------------------------------------------------------------------------------
•Color(int r, int g, int Ь)
        Создает объект класса Color.
                    Параметры:
                            r:  Значение красного цвета (0-2551
                            g:  Значение зеленого цвета (0-255)
                            b:  Значение синего цвета (0-255)
-----------------------------------------------------------------------------------------------------------------------
*/