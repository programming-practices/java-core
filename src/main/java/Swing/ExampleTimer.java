package Examples.Swing;

/**
 * @version 1.01 2015-05-12
 * @author Cay Horstmann
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
// to resolve conflict with java.util.Timer
/*Обратите внимание на то, что в данной программе класс javax.swing.Timer им­ портируется явно по имени, помимо импорта
пакетов javax.swing.* и java.util.*. Благодаря этому устраняется неоднозначность имен классов javax.swing.Timer
и java.util.Timer. Последний из них служит для планирования фоновых задач.*/

public class ExampleTimer {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();

        // construct a timer that calls the listener
        // once every 10 seconds
        Timer t = new Timer(10000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}


/*
----------------------------------------------------------------------------------------------------------------------
•Timer(int interval, ActionListener listener)
    Строит таймер, уведомляющий указанный приемник событий l i s t e n e r всякий раз, когда истека­
    ет промежуток времени, заданный в миллисекундах.

•void start()
    Запускает таймер. Как только таймер будет запущен, он вызывает метод actionPerformed()
    для приемников своих событий.

•void stop()
    Останавливает таймер. Как только таймер будет остановлен, он больше н е вызывает метод
    actionPerformed() для приемников своих событий.
----------------------------------------------------------------------------------------------------------------------
*/
