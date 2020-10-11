package Examples.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExampleWindowAdapter {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            WindowListener listener = new WindowAdapterJFrame.MyWindowAdapter();
            JFrame frame = new WindowAdapterJFrame();
            frame.setTitle("Window tem.Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        /*В этом фрагменте кода выполняются следующие действия.
            • Определяется анонимный класс, не имеющий имени и расширяющий класс WindowAdapter.
            • Переопределяется метод windowclosing() в этом анонимном классе. Как и прежде, этот метод отвечает за выход из программы.
            • От класса WindowAdapter наследуются остальные шесть методов, не выполняющих никаких действий.
            • Создается объект класса. Этот объект также анонимный и не имеет имени.
            • Методу addWindowListener() передается анонимный объект.
        Следует еще раз подчеркнуть, что к употреблению в коде анонимных внутренних классов нужно привыкнуть. А наградой
        за настойчивость станет предельная краткость полученного в итоге кода.*/
//        frame.addWindowListener(listener);
            // a mozno tak zdelat, namnoho udobnie i namnoho menwe koda
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //.....
                }
            });
        });
    }
}

class WindowAdapterJFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel buttonPanel;

    public WindowAdapterJFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationByPlatform(true);

        // create buttons
        JButton blueButton = new JButton("Blue");

        buttonPanel = new JPanel();

        // add buttons to panel
        buttonPanel.add(blueButton);

        // add panel to frame
        add(buttonPanel);

        // create button actions
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        // associate actions with buttons
        blueButton.addActionListener(blueAction);
    }

    /*Например, класс WindowAdapter содержит семь методов, не выполняющих никаких действий. Следовательно, класс адаптера
    автоматически удовлетворяет требованиям, предъявляемым к реализации соответствующего интерфейса. Класс адаптера можно
    расширить и уточнить нужные виды реакции на некоторые, но не на все виды событий в интерфейсе. (Обратите внимание на
    то, что интерфейс ActionListener содержит только один метод, поэтому для него класс адаптера не нужен.)
    Теперь объект класса  MyWindowAdapter можно зарегистрировать в качестве приемника событий, как показано ниже.
                        WindowListener listener = new MyWindowAdapter();
                        frame.addWindowListener(listener);
    Как только во фрейме будет сгенерировано событие, оно будет передано приемнику событий (объекту listener) при вызове
    одного из семи его методов (рис. 11.5). Шесть из этих методов ничего не делают, а метод windowclosing () выполняет вызов
    System, exit (0), завершая работу прикладной программы.*/
    public static class MyWindowAdapter extends WindowAdapter {
        public static boolean ifConsummerAsepted = false;

        /*ВНИМАНИЕ! Если, расширяя класс адаптера, вы неправильно наберете имя метода, компилятор не сообщит об ошибке.
        Так, если вы создадите метод windowlsClosing() в подклассе, производном от класса WindowAdapter, то получите новый
        класс, содержащий восемь методов, причем метод windowclosing() не будет выполнять никаких действий. Для защиты от
        подобных ошибок воспользуйтесь аннотацией @Override (см. главу 5).*/
        @Override
        public void windowClosing(WindowEvent e) {
            if (ifConsummerAsepted) {
                System.exit(0);
            }
        }
    }

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
