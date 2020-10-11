package Examples.Swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.32 2015-06-12
 */
public class ExampleUIManager_PlafTest {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        EventQueue.invokeLater(() -> {
            JFrame frame = new PlafFrame();
            frame.setTitle("PlafTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
//--------------------------------------------------------------------------------------------------------------------
    }
}

/**
 * A frame with a button panel for changing look-and-feel
 */
class PlafFrame extends JFrame {
    private JPanel buttonPanel;

    public PlafFrame() {
        buttonPanel = new JPanel();

        /*Чтобы пронумеровать установленные реализации визуальных стилей, достаточно сделать следующий вызов:
                        UIManager.LookAndFeellnfo[] infos = UIManager.getlnstalledLookAndFeels();
        После этого можно получить имя каждого стиля и реализующего его класса, используя приведенный ниже код.
                        String name = infos[i].getName();
                        String className = infos[i].getClassName();*/
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos)
            makeButton(info.getName(), info.getClassName());

        add(buttonPanel);
        pack();
    }

    /**
     * Makes a button to change the pluggable look-and-feel.
     *
     * @param name      the button name
     * @param className the name of the look-and-feel class
     */
    private void makeButton(String name, String className) {
        // add button to panel

        JButton button = new JButton(name);
        buttonPanel.add(button);

        // set button action

        button.addActionListener(event -> {
            // button action: switch to the new look-and-feel
            try {
                /*Второй способ позволяет изменить визуальный стиль динамически. С этой целью вызывается метод
                UIManager.setLookAndFeel(), для которого указывается имя класса требуемого стиля.*/
                UIManager.setLookAndFeel(className);
                /*Затем вызывается статический метод SwingUtilities.updateComponentTreeUI(), с помощью которого обновляется
                весь набор компонентов. Этому методу достаточно передать один компонент, а остальные он найдет автоматически.*/
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
По умолчанию в Swing-программах применяется визуальный стиль Metal, который можно изменить двумя способами. В подкаталоге
jre/lib можно предусмотреть файл swing.properties изадать внем спомощью свойства swing.defaultlaf имя класса, определяющего нуж ный стиль:
            wing.defaultlaf=com.sun.java.swing.plaf.motif.MotifLookAndFeel
Следует заметить, что визуальный стиль Metal находится в пакете javax.swing, а другие стили находятся в пакете com.sun.java.
Они не обязательно должны присутствовать в каждой установке Java. В настоящее время по соображениям, связанным с соблюдением
авторского права, пакеты визуальных стилей для операционных систем Windows и MacOS поставляются только с исполняющими средами,
ориентированными на эти системы.
----------------------------------------------------------------------------------------------------------------------
СОВЕТ. Строки, начинающиеся со знака #, в файлах, описывающих свойства визуальных стилей, игнорируются. Это дает возможность
предусмотреть в файле swing.properties несколько стилей, закомментировав знаком # ненужные стили следующим образом:
        #swing.defaultlaf=j avax.swing.plaf.metal.MetalLookAndFeel
        swing.defaultlaf=com.sun.java.swing.plaf.moti fArgInt .Moti fLookAndFeel
        #swing.defaultlaf=com.sun.java.swing.plaf.windows.WindowsLookAndFeel
Чтобы изменить визуальный стиль пользовательского интерфейса Swing-программы, ее нужно запустить заново. Программа прочитает
содержимое файла swing, proper ties лишь один раз при запуске.
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! В предыдущих изданиях данной книги для определения рассмотренного выше приемника событий применялся анонимный
внутренний класс. В то время приходилось очень аккуратно передавать ссылку PlafFrame.this, а не ссылку this на внутренний
класс, методу SwingUtilities.updateComponentTreeUI(), как показано ниже.
        public class PlafFrame extends JFrame{
            private void makeButton(String name, final String className){
                button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent event){
                        SwingUtilities .updateComponentTreeUI (PlafFrame.this);
                    }
                });
            }
        }
Теперь подобные трудности отошли в прошлое благодаря лямбда-выражениям. В теле лямбда-выражения ссылка this делается на
объект объемлющего класса.
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
•static UIManager.LookAndFeelInfo[] getlnstalledLookAndFeels ()
    Получает массив объектов, описывающих реализации установленных визуальных стилей.

•static setLookAndFeel (String className)
    Устанавливает текущий стиль, используя заданное имя класса (например, "javax.swing.plaf.metal.MetalLookAndFeel").
----------------------------------------------------------------------------------------------------------------------

*/
