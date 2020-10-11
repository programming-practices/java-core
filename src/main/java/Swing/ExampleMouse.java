package Examples.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * @author Cay Horstmann
 * @version 1.34 2015-06-12
 */
public class ExampleMouse {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MouseFrame();
            frame.setTitle("MouseTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame containing a panel for testing mouse operations
 */
class MouseFrame extends JFrame {
    public MouseFrame() {
        add(new MouseComponent());
        pack();
    }
}

/**
 * A component with mouse operations for adding and removing squares.
 */
class MouseComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current; // the square containing the mouse cursor

    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // draw all squares
        for (Rectangle2D r : squares)
            g2.draw(r);
    }

    /**
     * Finds the first square containing a point.
     *
     * @param p a point
     * @return the first square that contains p
     */
    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : squares) {
            if (r.contains(p)) return r;
        }
        return null;
    }

    /**
     * Adds a square to the collection.
     *
     * @param p the center of the square
     */
    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH,
                SIDELENGTH);
        squares.add(current);
        repaint();
    }

    /**
     * Removes a square from the collection.
     *
     * @param s the square to remove
     */
    public void remove(Rectangle2D s) {
        if (s == null) return;
        if (s == current) current = null;
        squares.remove(s);
        repaint();
    }

    /*Как только пользователь щелкнет кнопкой мыши, вызываются следующие три метода объекта приемника событий: mousePressed(),
     *  если кнопка мыши нажата; mouseReleased(), если кнопка отпущена; а также mouseClicked(), если произведен щелчок. Если
     *  же требуется отследить только сам щелчок, применять первые два ме­тода не обязательно. Вызывая методы getX() и getY()
     *  для объекта типа MouseEvent, передаваемого в качестве параметра, можно определить координаты положения кур­сора мыши в
     *  момент щелчка. А если требуется отличить обычный щелчок от двойно­го и тройного(!), то вызывается метод getClickCount()*/
    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            // add a new square if the cursor isn't inside a square
            current = find(event.getPoint());
            if (current == null) add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event) {
            // remove the current square if double clicked
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2) remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {
        public void mouseMoved(MouseEvent event) {
            // set the mouse cursor to cross hairs if it is inside
            // a rectangle

            /*Рассматриваемая здесь программа отслеживает события от перемещений мыши, чтобы изменить вид курсора
             * (на крестообразный), как только он выйдет за преде­лы квадрата. Эта процедура реализована в методе
             *  getPredefinedCursor () из класса Cursor.*/
            if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        /*Если перемещение мыши осуществляется при ее нажатой кнопке, вместо мето­ да mouseClicked() вызывается метод mouseDragged().
         * В данном примере квадраты можно перетаскивать по экрану. Квадрат перемещается таким образом, чтобы его центр располагался
         * в той точке, где находится указатель мыши. Содержимое холста перерисовывается, чтобы отобразить новое положение указателя
         * мыши. Ниже при­веден исходный код метода mousedicked().*/
        public void mouseDragged(MouseEvent event) {
            if (current != null) {
                int x = event.getX();
                int y = event.getY();

                // drag the current rectangle to center it at (x, y)
                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }
    }
}

/*
 ------------------------------------------------------------------------------------------------------------------
 Метод getModif iersEx() позволяет распознавать события, наступающие при од­новременном нажатии кнопок мыши и модифицирующих 
 клавиш. Обратите вни­мание на то, что маска BUTT0N3 D0WN MASK позволяет проверять нажатие правой кнопки мыши в Windows. Например, 
 для того чтобы определить, была ли нажата правая кнопка мыши, можно воспользоваться следующим кодом:
					if ((event.getModifiersEx() & InputEvent.BUTT0N3_D0WN_MASK) != 0)
						...// код обработки события, наступающего
						...// при нажатии правой кнопки мыши
---------------------------------------------------------------------------------------------------------------------
HA ЗАМЕТКУ! Используя метод createCustomCursor ( ) из класса Toolkit, можно определить новый вид курсора следующим образом:
					Toolkit tk = Toolkit.getDefaultToolkit();
					Image img = tk.getlmage("dynamite.gif");
					Cursor dynamiteCursor = tk.createCustomCursor(img, new P oi nt(10, 10), "dynamite stick");
В качестве первого параметра в методе createCustomCursor ( ) задается изображение курсора, в качестве второго 
параметра — координаты точки выбора курсора, а в качестве третьего параме­тра — символьная строка, описывающая курсор. 
Эта строка служит для поддержки специальных возможностей, позволяющих, например, озвучивать голосом вид курсора, что удобно 
для пользо­вателей с нарушениями зрения или вообще не смотрящих на экран.
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Метод mouseMoved() вызывается только в том случае, если указатель мыши нахо­дится в пределах компонента. Но 
метод mouseDragged() вызывается даже тогда, когда указатель мыши находится за пределами компонента.
----------------------------------------------------------------------------------------------------------------------
Имеются еще два метода, обрабатывающих события от мыши: mouseEntered() и mouseExited(). Они вызываются в тех случаях, когда 
указатель мыши входит в пре­делы компонента и выходит из его пределов. И наконец, поясним, каким образом отслеж иваются и 
обрабатываются событияот мыши. В ответ на щелчок кнопкой мыши вызывается метод mouseClicked(), вхо­дящий в состав интерфейса 
MouseListener. Во многих приложениях отслеживаются только щелчки кнопкой мыши, а перемещения мыши происходят слишком часто,
поэтому события, связанные с перемещением мыши и перетаскиванием объектов, определяются в отдельном интерфейсе MouseMotionListener.
----------------------------------------------------------------------------------------------------------------------
*/