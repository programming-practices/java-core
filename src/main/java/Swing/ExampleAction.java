package Examples.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Cay Horstmann
 * @version 1.34 2015-06-12
 */
public class ExampleAction {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ActionFrame();
            frame.setTitle("ActionTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a panel that demonstrates value change actions.
 */
class ActionFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String pathYellow_ball = "/root/Datos/Programacion/java_lessons/src/main/resources/Swing_Examples/yellow-ball.gif";
    private static final String pathBlue_ball = "/root/Datos/Programacion/java_lessons/src/main/resources/Swing_Examples/blue-ball.gif";
    private static final String pathRed_ball = "/root/Datos/Programacion/java_lessons/src/main/resources/Swing_Examples/red-ball.gif";
    private JPanel buttonPanel;

    public ActionFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        // define actions
        Action yellowAction = new ColorAction("Yellow", new ImageIcon(pathYellow_ball), Color.YELLOW);
        Action blueAction = new ColorAction("Blue", new ImageIcon(pathBlue_ball), Color.BLUE);
        Action redAction = new ColorAction("Red", new ImageIcon(pathRed_ball), Color.RED);

        // add buttons for these actions
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        // add panel to frame
        add(buttonPanel);

        /*И, наконец, объекты действий нужно связать с клавишами, чтобы эти действия выполнялись, когда пользователь
        нажимает соответствующие клавиши. Для того чтобы связать действия с нажатием клавиш, сначала нужно создать объект
        класса Keystroke. Это удобный класс, инкапсулирующий описание клавиш следующим образом:
                                KeyStroke ctrlBKey = KeyStroke.getKeyStroke("Ctrl В");
        Привязку ввода можно получить из компонента с помощью метода getlnputMap() следующим образом:*/
        // associate the Y, B, and R keys with names
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        /*Таким образом, у каждого компонента имеются три привязки ввода и одна привязка действия. Чтобы связать их вместе,
        каждому действию нужно присвоить соответствующее имя. Ниже показано, каким образом комбинация клавиш связывается
        с нужным действием.
        Если требуется задать отсутствие действия, то обычно указывается символьная строка "none" (отсутствует). Это позволяет
        легко запретить реагирование на нажатие определенной комбинации клавиш, как показано ниже,
                                imap.put(Keystroke.getKeyStroke("Ctrl C"), "none");*/
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

        /*Класс InputMap не связывает напрямую объекты типа Keystroke с объектами класса ColorAction, реализующего интерфейс
        Action. Вместо этого он выполняет первую привязку к произвольным объектам, а вторую привязку, реализованную в классе
        ActionMap, объектов — к действиями. Благодаря этому упрощается выполнение одних и тех же действий при нажатии клавиш,
        зарегистрированных по разным условиям привязки ввода.
        ВНИМАНИЕ! В документации на комплект JDK предполагается, что названия клавиш и соответствующего действия совпадают.
        Такое решение вряд ли можно считать оптимальным. Название действия отображается на кнопке и в пункте меню, но оно
        может изменяться в процессе разработки. Это, в частности, неизбежно при интернационализации пользовательского интерфейса
        на разных языках. Поэтому действиям рекомендуется присваивать имена независимо от названий, отображаемых на экране.*/
        // associate the names with actions
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }

    /*Следует, однако, иметь в виду, что Action является интерфейсом, а не классом. Любой класс, реализующий этот интерфейс,
    должен реализовать семь только что рассмотренных методов. Правда, сделать это совсем не трудно, поскольку все они,
    кроме первого метода, содержатся в классе AbstractAct ion, который предназначен для хранения пар "имя -значение", а
    также для управления приемниками изменений свойств. На практике для этого достаточно создать соответствующий подкласс
    и ввести в него метод actionPerformed().*/
    public class ColorAction extends AbstractAction {
        /**
         * Constructs a value action.
         *
         * @param name the name to show on the button
         * @param icon the icon to display on the button
         * @param c    the background value
         */
        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel value to " + name.toLowerCase());
            putValue("value", c);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Color c = (Color) getValue("value");
            buttonPanel.setBackground(c);
        }
    }
}
/*
-----------------------------------------------------------------------------------------------------------------------
Итак, чтобы одно и то же действие выполнялось в ответ на щелчок на экранной кнопке, выбор пункта меню или нажатие клавиши,
следует предпринять описанные ниже шаги.
    1. Реализовать класс, расширяющий класс AbstractAction. Один класс можно будет использовать для программирования разных
       взаимосвязанных действий.
    2. Создать объект класса действия.
    3. Сконструировать экранную кнопку или пункт меню из объекта действия. Конструктор прочтет текст метки и пиктограмму
       из объекта действия.
    4. Для действий, которые выполняются в ответ на нажатие клавиш, нужно предпринять дополнительные шаги.
            • Сначала следует обнаружить в окне компонент верхнего уровня, например, панель, содержащую все остальные компоненты.
            • Затем проверить условие привязки ввода WHEN__ANCESTOR_OF_FOCUSED_COMPONENT компонента верхнего уровня.
            • Создать объект типа KeyStroke для нужного нажатия клавиш.
            • Создать объект, соответствующий нажатию клавиш, например, символьную строку, описывающую нужное действие.
            • Добавить пару (нажатие клавиш, ответное действие) к привязке ввода.
            • И наконец, получить привязку действия для компонента верхнего уровня, а затем добавить пару (ответное действие,
            объект действия) к привязке действия.
-----------------------------------------------------------------------------------------------------------------------
В библиотеке Swing предусмотрен очень полезный механизм, позволяющий инкапсулировать команды и связывать их с несколькими
источниками событий. Этим механизмом служит интерфейс Action. Действие представляет собой объект, инкапсулирующий следующее.
                • О писание команды (в виде текстовой строки или пиктограммы).
                • Параметры, н еобходимые для выполнения команды (в данном случае для выбора нужного цвета).
Интерфейс Action содержит следующие методы:
void actionPerformed(ActionEvent event)
void setEnabled(boolean b)
boolean isEnabledO
void putValue(String key, Object value)
Object getValue(String key)
void addPropertyChangeListener(PropertyChangeListener listener)
void removePropertyChangeListener(PropertyChangeListener listener)
--------------------------------Предопределенные имена действий--------------------------------------------------------
NAME                    Имя действия. Отображается на экранной кнопке и в названии пункта меню
SMALL_ICON              Место для хранения пиктограммы, которая отображается на экранной кнопке,
                        в пункте меню или на панели инструментов
SHORTJDESCRIPTION       Краткое описание пиктограммы, отображаемое во всплывающей подсказке
LONGJDESCRIPTION        Подробное описание пиктограммы. Может использоваться для подсказки.
                        Не применяется ни в одном из компонентов библиотеки Swing
MNEMONICJOEY            Мнемоническое сокращение. Отображается в пункте меню (см. главу 12)
ACCELERATORJOEY         Место для хранения комбинации клавиш. Не применяется ни в одном из
                        компонентов библиотеки Swing
ACTION_COMMAND_KEY      Применялось раньше в устаревшем теперь методе
                        registeredKeyBoardAction()
DEFAULT                 Может быть полезным для хранения разнообразных объектов. Не применяется ни
                        в одном из компонентов библиотеки Swing
---------------------------------Условия для привязки ввода------------------------------------------------------------
when_focused                         Когда данный компонент находится в фокусе вводас клавиатуры
WHEN_ANCESTOR_OF_FOCUSED_CGMPNENT    Когда данный компонент содержит другой компонент, находящийся в фокусе ввода с клавиатуры
WHEN__lN__FOCUSED_WlNDOW             Когда данный компонент содержится в том же окне, что и компонент, находящийся в фокусе ввода с клавиатуры

При нажатии клавиши условия привязки ввода проверяются в следующем порядке.
    1. Проверяется условие привязки ввода WHEN FOCUSED компонента, владеющего фокусом ввода. Если предусмотрена реакция
       на нажатие клавиши, выполняется соответствующее действие. И если действие разрешено, то обработка прекращается.
    2. Начиная с компонента, обладающего фокусом ввода, проверяется условие привязки ввода WHEN_ANCESTOR_OF_FOCUSED_COMPONENT
       его родительского компонента. Как только обнаруживается привязка ввода с клавиатуры, выполняется соответствующее действие.
       И если действие разрешено, то обработка прекра­щается.
    3. В окне, обладающем фокусом ввода, проверяются все видимые и активизированные компоненты с зарегистрированными нажатиями
       клавиш по условию привязки ввода WHEN_IN_FOCUSED_WINDOW. Каждый из этих компонентов(в порядке регистрации нажатий клавиш)
       получает возможность выполнить соответствующее действие. Как только будет выполнено первое разрешенное действие, обработка
       прекратится. Если же нажатия клавиш зарегистрированы по нескольким условиям привязки ввода WHEN IN FOCUSED WINDOW, то резуль­
       таты обработки на данном этапе могут быть неоднозначными.
-----------------------------------------------------------------------------------------------------------------------
Объекты событий инкапсулируют данные, которые источник событий передает приемникам. По мере необходимости объекты событий, 
переданные объекту при­емника событий, могут быть проанализированы с помощью методов getSource() и getActionCommand().
-----------------------------------------------------------------------------------------------------------------------
•boolean isEnabled()
•void setEnabled (boolean b)
        Получают или устанавливают свойство enabled объекта данного действия.

•void putValue(String key, Object value)
        Размещает пару "имя -значение” в объекте действия.
            Параметры:
                    key: Имя компонента, сохраняемое в объекте
                         действия. Может быть задано любой
                         строкой, но ряд имен имеет специальное
                         значение (см. табл. 11.11
                 value:  Объект, связанный с именем

•Object getValue (String key)
        Возвращает значение из сохраненной пары "имя -значение”.
-----------------------------------------------------------------------------------------------------------------------
*/
