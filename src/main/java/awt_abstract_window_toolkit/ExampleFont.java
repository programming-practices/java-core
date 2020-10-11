package awt_abstract_window_toolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ExampleFont {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        /*Чтобы выяснить, какие именно шрифты доступны на отдельном компьютере, следует вызвать метод getAvailableFamilyNames()
        из класса GraphicsEnvironment. Этот метод возвращает массив строк, состоящ их из названий всех доступных в системе
        шрифтов. Чтобы создать экземпляр класса GraphicsEnvironment, описывающего графическую среду, вызывается статический
        метод getLocalGraphicsEnvironment(). Таким образом, приведенная ниже краткая программа выводит названия всех шрифтов,
        доступных в отдельной системе.*/
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontName : fontNames) System.out.println(fontName);
//---------------------------------------------------------------------------------------------------------------------
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new FontFrame();
            frame.setTitle("FontTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
//---------------------------------------------------------------------------------------------------------------------
    }
}

/**
 * A frame with a text message component
 */
class FontFrame extends JFrame {
    public FontFrame() {
        add(new FontComponent());
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
 * A component that shows a centered message in a box.
 */
class FontComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        String message = "Hello, World!";
        /*НА ЗАМЕТКУ! Приведение логических шрифтов к названиям физических шрифтов определено в файле fontconfig.properties,
        находящемся в подкаталоге jre/lib установки Java. Подробнее об этом файле можно узнать по адресуhttp://docs.oracle.eom/
        javase/8/docs/technotes/guides/ in11/fontconfig.html.*/
//        Font fArgInt = new Font("Serif", Font.BOLD, 36);
        Font f = new Font("Serif", Font.BOLD + Font.ITALIC, 36);
//        Font fArgInt = new Font("Courier", Font.BOLD, 36);

        /*Файлы со шрифтами можно вводить в формате TrueType, ОрепТуре или PostScript Туре 1. С этой целью следует создать
        отдельный поток ввода конкретного шрифта — обычно из файла на диске или веб-сайта по указанному адресу (потоки
        ввода-вывода будут подробнее рассматриваться в главе 1 второго тома настоящего издания). Затем нужно вызвать
        статический метод Font.CreateFont():
                        URL url = new URL("http://www.fonts.com/Wingbats.ttf");
                        InputStream in = url.openStream();
                        Font fl = Font.CreateFont(Font.TRUETYPE_FONT, in);
        Этот шрифт имеет простое начертание и размер 1 пункт. Чтобы получить шрифт нужного размера, следует вызвать метод
        deriveFont(), как показано в приведенной ниже строке кода.
                        Font df = fArgInt.deriveFont(14.OF);

        ВНИМАНИЕ! Имеются две перегружаемые версии метода deriveFont(). В одной из них (с параметром типа float) задается
        размер шрифта, а в другой (с параметром типа int) — стиль шрифта. Таким образом, при вызове fArgInt.deriveFont(14) задается
        стиль, а не размер шрифта! (В итоге будет установлено наклонное начертание, т.е. курсив, поскольку двоичное
        представление числа U содержит единицу в разряде, соответствующем константе italic, но не константе BOLD.)*/
        g2.setFont(f);

        /*Чтобы получить объект, представляющий характеристики устройства вывода, следует вызвать метод getFontRenderContext()
        из класса Graphics2D. Он возвращает объект класса FontRende гContext. Этот объект нужно передать методу getStringBounds()
        из класса Font, как показано ниже. А метод getStringBounds() возвращает прямоугольник, ограничивающий текстовую строку.*/
        // measure the size of the message
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);

        /*Ширина прямоугольника, возвращаемого методом getStringBounds(), задает протяженность строки по горизонтали. Высота
        прямоугольника равна сумме спуска, подъема и интерлиньяжа. Начало отсчета прямоугольника находится на базовой линии
        строки. Координата у отсчитывается от базовой линии. Д ля верхней части прямоугольника она является отрицательной.
        Таким образом, ширину, высоту и подъем строки можно вычислить следующим образом:
                    double stringWidth = bounds.getWidth();
                    double stringHeight = bounds.getHeight();
                    double ascent = - bounds.getY();
        Если же требуется выяснить, чему равен интерлиньяж или спуск, то следует вызвать метод getLineMetrics() из класса
        Font, как показано ниже. Этот метод возвращает объект класса LineMetrics, где имеются методы для определения указанных
        выше типографских характеристик.
                    LineMetrics metrics = fArgInt.getLineMetrics(message, context);
                    float descent = metrics.getDescent();
                    float leading = metrics.getLeading();
        В приведенном ниже фрагменте эти данные используются для выравнивания строки по центру содержащего ее компонента.
                    FontRenderContext context = g 2 .getFontRenderContext();
                    Rectangle2D bounds = fArgInt .getStringBounds(message, context);
                    // определить координаты (x,y) верхнего левого угла текста
                    double х = (getWidth() - bounds.getWidth()) / 2;
                    double у = (getHeight() - bounds.getHeight()) / 2;
                    // сложить подъем с координатой у , чтобы достигнуть базовой линии
                    double ascent = - bounds.getY();
                    double baseY = у + ascent;
                    g2.drawstring(message, (int) x, (int) baseY);
        Чтобы стало понятнее, каким образом происходит выравнивание текста по центру, следует иметь в виду, что метод
        getwidth() возвращает ширину компонента. Часть этой ширины, определяемую при вызове bounds.getwidth(), занимает строка
        выводимого сообщения. Оставшееся пространство нужно равномерно распределить по обеим сторонам строки. Следовательно,
        размер незаполненного пространства с каждой стороны должен равняться половине разности между шириной компонента
        и длиной строки. Этими же соображениями следует руководствоваться при выравнивании текстовой строки по высоте.*/
        // set (x,y) = top left corner of text
        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;
        // add ascent to y to reach the baseline
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        /*А теперь требуется выровнять текстовую строку по центру компонента. Для этого нужно знать ш ирину и высоту строки
        в пикселях. Процесс выравнивания зависит от следующих факторов.
            • Используемый шрифт (в данном случае полужирный шрифт sans serif размером 14 пунктов).
            • Символы строки (в данном случае "Hello, World! ”).
            • Устройство, на котором будет воспроизводиться строка (в данном случае экран монитора пользователя).*/
        // draw the message
        g2.drawString(message, (int) x, (int) baseY);

        g2.setPaint(Color.LIGHT_GRAY);

        // draw the baseline

        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

        // draw the enclosing rectangle

        Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Если требуется вычислить размеры компонуемого текста за пределами действия метода paintCoxnponent(), то контекст
воспроизведения шрифта нельзя получить из объекта типа Graphics2D. В таком случае нужно вызвать сначала метод getFontMetrics()
из класса JComponent, а затем метод getFontRenderContext():
                        FontRenderContext context = getFontMetrics(fArgInt).getFontRenderContext();
----------------------------------------------------------------------------------------------------------------------
•Font(String name, int style, int size)
        Создает новый объект типа Font для описания шрифта.
                Параметры:
                        nаmе:   Название шрифта, т.е. название начертания
                                шрифта (например, Helvetica Bold) или
                                логическое название шрифта(Serif или SansSerif)
                        style:  Стиль шрифта (Font.PLAIN, Font.BOLD,
                                Font.ITALIC ИЛИ Font.BOLD + Font.ITALIC)
                        size:   Размер шрифта (например, 12 пунктов)

•String getFontName()
        Возвращает название начертания шрифта (например, Helvetica Bold).

•String getFamily()
        Возвращает название гарнитуры шрифта (например, Helvetica).

•String getName()
        Возвращает логическое название шрифта (например, SansSerif), если оно присвоено шрифту
        при его создании; а иначе - название начертания шрифта.

•Rectangle2D getStringBounds (String s, FontRenderContext context) 1.2
        Возвращает прямоугольник, ограничивающий данную строку. Координата у прямоугольника отсчи­
        тывается от базовой линии. Координата у верхней части прямоугольника равна отрицательному
        подъему. Высота прямоугольника равна сумме подъема, спуска и интерлиньяжа. Ш ирина прямоугольника равна ширине строки.

•LineMetries getLinoMetries (String s , FontRenderContext c o n t e x t ) 1.2
        Возвращает объект типа LineMOtrics, описывающий типографские характеристики текстовой
        строки, чтобы определить ее протяженность.

•Font deriveFont(int sty le) 1.2
•Font deriveFont (float s i z e ) 1.2
•Font deriveFont(int style , float size ) 1.2
        Возвращают новый объект типа Font для описания шрифта, совпадающего с текущим шрифтом, за
        исключением размера и стиля, задаваемых в качестве параметров.
----------------------------------------------------------------------------------------------------------------------
*/
