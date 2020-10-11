package Examples.OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This program demonstrates anonymous inner classes.
 *
 * @author Cay Horstmann
 * @version 1.11 2015-05-12
 */
public class ExampleAnonymousInnerClass {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock {
    /**
     * Starts the clock.
     *
     * @param interval the interval between messages (in milliseconds)
     * @param beep     true if the clock should beep
     */
    public void start(int interval, boolean beep) {
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Следует внимательно и аккуратно проводить различие между созданием нового объекта некоторого класса и конструированием
объекта анонимного внутреннего класса, расширяющего данный класс. Если за скобками со списком параметров, необходимых
для создания объекта, следует открытая фигурная скобка, то определяется анонимный вложенный класс, как показано ниже.
        Person queen = new Person("Mary");
        // объект типа Person
        Person count = new Person("Dracula") { . . .};
        // объект внутреннего класса, расширяющего класс Person
----------------------------------------------------------------------------------------------------------------------
Многие годы программирующие на Java регулярно пользовались анонимными внутренними классами для организации приемников
событий и прочих обратных вызовов. А ныне вместо них лучше употреблять лямбда-выражения. Например, метод start(),
упоминавшийся в начале этого раздела, можно написать в более лаконичной форме, воспользовавшись лямбда-выражением, как
выделено ниже полужирным.
            public void start(int interval, boolean beep){
                Timer t = new Timer (interval, event ->{
                    System, out.printIn ("At the tone, the time is " + new DateO);
                    if (beep) Toolkit.getDefaultToolkit().beep();
                >);
                t .start ();
            }
----------------------------------------------------------------------------------------------------------------------
НАЗАМЕТКУ!Существуетспециальный прием, называемый инициализацией вдвойных фигурных скобкахи выгодно использующий
преимущества синтаксиса внутренних классов. Допустим, требуется составить списочный массив и передать ему метод следующим образом:
            ArrayList<String> friends = new ArrayListo();
            favorites.a d d ("Harry");
            favorites.a d d ("Tony");
            invite(friends);
Если списочный массив больше не понадобится, то было бы неплохо сделать его анонимным. Но как тогда вводить в него
дополнительные элементы? А вот как:
            invite (new ArrayList<String>() {{ add ("Harry") ; add ("Tony") ; }})
Обратите внимание на двойные фигурные скобки в приведенной выше строке кода. В нешние фигурные скобки образуют анонимный
подкласс ArrayList, а внутренние фигурные скобки - блок конструирования объектов (см. главу 4).
----------------------------------------------------------------------------------------------------------------------
ВНИМАНИЕ! Зачастую анонимный подкласс удобно сделать почти, но не совсем таким же, как и его суперкласс. Но в этом случае
следует соблюдать особую осторожность в отношении метода equals(). Как рекомендовалось в главе 5, в методе equals()
необходимо организовать следующую проверку:
            if (getClassO != other .getClass ()) return false;
Но анонимный подкласс ее не пройдет.
----------------------------------------------------------------------------------------------------------------------
СОВЕТ. При выдаче регистрирующих или отладочных сообщений в них нередко требуется включить имя текущего класса, как в
приведенной ниже строке кода.
            System.err.println("Something awful happened in " + getClass());
Но такой прием не годится для статического метода. Ведь вызов метода getClass(), по существу, означает вызов this.getciass().
Но ссылка this на текущий объект для статического метода не годится. В таком случае можно воспользоваться следующим выражением:
            new Object(){}.getciass().getEnclosingClass()
            // получить класс статического метода
Здесь в операции new Object(){} создается объект анонимного подкласса, производного от класса Object, а метод
getEnclosingClass() получает объемлющий его класс, т.е. класс,cсодержащий статический метод.
----------------------------------------------------------------------------------------------------------------------
*/