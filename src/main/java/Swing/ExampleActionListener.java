package Examples.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class ExampleActionListener {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
//--------------------------------------------------------------------------------------------------------------------
        EventQueue.invokeAndWait(() ->
        {
            JFrame jFrame = new MyJFrameAL1();
            jFrame.setTitle("Example ActionListener!!!");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        });
//--------------------------------------------------------------------------------------------------------------------
//        EventQueue.invokeAndWait(() ->
//        {
//            JFrame jFrame = new MyJFrameAL2();
//            jFrame.setTitle("Example ActionListener!!!");
//            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jFrame.setVisible(true);
//        });
//--------------------------------------------------------------------------------------------------------------------
    }
}

/**
 * A frame with a button panel
 */
class MyJFrameAL1 extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel buttonPanel;

    public MyJFrameAL1() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);

        // create buttons
        JButton yellowButton = new JButton("Yellow");
        yellowButton.setLocation(5, 20);
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        buttonPanel = new JPanel();

        // add buttons to panel
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        // add panel to frame
        add(buttonPanel);

        /*Затем для каждого цвета создается один объект. Все эти объекты устанавливаются в качестве приемников событий от
        соответствующих кнопок:*/
        // create button actions
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        /*Так, если пользователь щелкнет на экранной кнопке с меткой Yellow, вызывается метод actionPerformed() из объекта
        yellowAction. В поле экземпляра backgroundColor хранится значение Color.YELLOW, поэтому выполняющийся метод
        может установить требуемый (в данном случае желтый) цвет фона панели.*/
        // associate actions with buttons
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    /*  Осталось разрешить еще одно небольшое затруднение. Объект типа ColorAction не имеет доступа к переменной buttonPanel.
    Это затруднение можно разрешить разными путями. В частности, переменную buttonPanel можно указать в конструкторе
    класса ColorAction. Но удобнее сделать класс ColorAction внутренним по отношению к классу ButtonFrame. В этом случае
    его методы получат доступ к внешним переменным автоматически.
        Допустим, что после щелчка на кнопке требуется изменить цвет фона панели. Новый цвет указывается в классе приемника
    событий следующим образом:*/

    /**
     * An action listener that sets the panel's background value.
     */
    private class ColorAction implements ActionListener {
        private Color backgroundColor;

        public ColorAction(Color c) {
            backgroundColor = c;
        }

        public void actionPerformed(ActionEvent event) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}

class MyJFrameAL2 extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String path = "/root/Datos/Programacion/java_lessons/src/main/resources/Swing_Examples/blue-ball.gif";
    private JPanel jPanelBotton;

    public MyJFrameAL2() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);
        jPanelBotton = new JPanel();

        /*Чтобы создать экранную кнопку, нужно указать в конструкторе ее класса символьную строку метки, пиктограмму или
        оба атрибута вместе. Ниже приведены два примера создания экранных кнопок.*/
        JButton buttonHello = new JButton("Print Hello");
        JButton buttonGoodBye = new JButton("Print Bye", new ImageIcon(path));

        jPanelBotton.add(buttonHello);
        jPanelBotton.add(buttonGoodBye);

        add(jPanelBotton);

        /*Далее нужно ввести код, позволяющий реагировать на эти кнопки. Д ля этого требуется класс, реализующий интерфейс
        ActionListener, где, как упоминалось выше, объявлен единственный метод actionPerformed()*/
        buttonHello.addActionListener(new MyActionListenerH());
        buttonGoodBye.addActionListener(new MyActionListenerB());
    }

    private class MyActionListenerH implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello");
        }
    }

    private class MyActionListenerB implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Bye");
        }
    }
}


/*
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Интерфейс ActionListener, применяемый в данном примере, не ограничивается отслеживанием щелчков на экранных
кнопках. Он применяется и во многих других случаях, когда наступают перечисленные ниже события.
    •После двойного щелчка на элементе списка.
    •После выбора пункта меню.
    •После нажатия клавиши <Enter>, когда курсор находится в текстовом поле.
    •По истечении периода времени, заданного для компонента Timer.
Обработка этих событий более подробно рассматривается далее в этой и следующей главах. Но в любом случае интерфейс ActionListener
применяется совершенно одинаково: метод actionPerformed() — единственный в интерфейсе ActionListener — принимает в качестве
параметра объект типа ActionEvent. Этот объект несет в себе сведения о наступившем событии.
----------------------------------------------------------------------------------------------------------------------
*/