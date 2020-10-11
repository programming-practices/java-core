package Examples.OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

/**
 * This program demonstrates the use of local inner classes.
 *
 * @author Cay Horstmann
 * @version 1.01 2015-05-12
 */
public class ExampleLocalInnerClass {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        TalkingClockA clock = new TalkingClockA();
        clock.start(1000, true);

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
//---------------------------------------------------------------------------------------------------------------------
        /*Ограничение на действительную конечность переменных не совсем удобно. Допу­
        стим, требуется обновить счетчик в объемлющей области действия, чтобы подсчи­
        тать, насколько часто во время сортировки вызывается метод compareTo ( ) :*/
        int counter = 0;
        Date[] dates = new Date[100];
        for (int i = 0; i < dates.length; i++)
            dates[i] = new Date() {
                public int compareTo(Date other) {
//                    counter++; // ОШИБКА!
                    return super.compareTo(other);
                }
            };
        Arrays.sort(dates);
        System.out.println(counter + " comparisons.");
        /*Объявить переменную counter как final нельзя. Ведь совершенно очевидно, что
        ее придется обновлять. Ее тип нельзя заменить и на Integer, поскольку объекты типа
        Integer неизменяемы. В качестве выхода из этого положения можно воспользоваться
        массивом длиной в 1 элемент, как выделено ниже полужирным.*/
        final int[] counter1 = new int[1];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = new Date() {
                public int compareTo(Date other) {
                    counter1[0]++;
                    return super.compareTo(other);
                }
            };
        }
        /*Когда впервые были внедрены внутренние классы, в прототипной версии компи­
        лятора подобное преобразование автоматически выполнялось для всех локальных
        переменных, модифицировавшихся во внутреннем классе. Но это правило в дальней­
        шем было отменено из соображений безопасности. Так, если код внутреннего класса
        одновременно выполняется в нескольких потоках, то параллельные обновления пере­
        менных могут привести к состоянию гонок (подробнее об этом — в главе 14).*/
//---------------------------------------------------------------------------------------------------------------------
    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClockA {
    /*Локальные внутренние классы выгодно отличаются от обычных внутренних классов еще и тем, что имеют доступ не только
    к полям своего внешнего класса, но и к локальным переменным! Но такие локальные переменные должны быть объявлены как
    действительно конечные. Это означает, что такие переменные нельзя изменить после их инициализации путем присваивания
    им первоначальных значений. Обратимся к характерному примеру, п ереместив параметры interval и beep из конструктора
    TalkingClock в метод start() , как выделено ниже полужирным.*/

    /**
     * Starts the clock.
     *
     * @param interval the interval between messages (in milliseconds)
     * @param beep     true if the clock should beep
     */
    public void start(int interval, boolean beep) {
        class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Локальные внутренние классы никогда не объявляются с помощью модификаторов доступа (например, public и protected). И х
область действия всегда ограничивается блоком, в котором они объявлены. У локальны х внутренних классов имеется следующее
большое преимущество: они полностью скрыты от внешнего кода и даже от остальной части класса TalkingClock. Ни одному из
методов, за исключением start(), ничего неизвестно о классе TimePrinter.
----------------------------------------------------------------------------------------------------------------------
*/