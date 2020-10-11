package JAR_JavaArchive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Properties;

/**
 * A program to test properties. The program remembers the frame position, size,
 * and title.
 *
 * @author Cay Horstmann
 * @version 1.01 2015-06-16
 */
public class ExampleProperties {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PropertiesFrame frame = new PropertiesFrame();
            frame.setVisible(true);
        });
    }
}

/**
 * A frame that restores position and size from a properties file and updates
 * the properties upon exit.
 */
class PropertiesFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private File propertiesFile;
    private Properties settings;

    public PropertiesFrame() {
        /*Обычно свойства программы принято сохранять в подкаталоге начального катало­га пользователя. Имя
         * такого каталога зачастую начинается с точки — в системе UNIX это соглашение указывает на системный
         * каталог, скрытый от пользователя. Именно такое условное обозначение применяется в программе,
         * рассматриваемой здесь в ка­честве примера. Чтобы найти начальный каталог пользователя, достаточно
         * вызвать метод System.getProperties(), в котором, как оказывается, объект типа Properties также служит
         * для описания системной информации. У начального каталога имеется ключ "user,home".Для чтения одиночного
         * ключа предусмотрен следующий служебный метод:*/
        // get position, size, title from properties
        String userDir = System.getProperty("user.home");
        File propertiesDir = new File(userDir, ".corejava");
        if (!propertiesDir.exists()) propertiesDir.mkdir();
        propertiesFile = new File(propertiesDir, "program.properties");

        Properties defaultSettings = new Properties();
        defaultSettings.setProperty("left", "0");
        defaultSettings.setProperty("top", "0");
        defaultSettings.setProperty("width", "" + DEFAULT_WIDTH);
        defaultSettings.setProperty("height", "" + DEFAULT_HEIGHT);
        defaultSettings.setProperty("title", "");

        settings = new Properties(defaultSettings);

        /*Для загрузки этих свойств из файла служит приведенный ниже фрагмент кода.*/
        if (propertiesFile.exists())
            try (InputStream in = new FileInputStream(propertiesFile)) {
                settings.load(in);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        int left = Integer.parseInt(settings.getProperty("left"));
        int top = Integer.parseInt(settings.getProperty("top"));
        int width = Integer.parseInt(settings.getProperty("width"));
        int height = Integer.parseInt(settings.getProperty("height"));
        setBounds(left, top, width, height);

        // if no title given, ask user

        String title = settings.getProperty("title");
        if (title.equals(""))
            title = JOptionPane.showInputDialog("Please supply a frame title:");
        if (title == null)
            title = "";
        setTitle(title);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                settings.setProperty("left", "" + getX());
                settings.setProperty("top", "" + getY());
                settings.setProperty("width", "" + getWidth());
                settings.setProperty("height", "" + getHeight());
                settings.setProperty("title", getTitle());
                /*Для записи списка свойств в файл служит метод store(). В приведенном ниже примере кода таблица
                 * свойств просто выводится в файл program, properties. А в ка­честве второго параметра при вызове
                 * метода store () указываются комментарии, ко­торые включаются в файл.*/
                try (OutputStream out = new FileOutputStream(propertiesFile)) {
                    settings.store(out, "Program Properties");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
}

/*
 * ---------------------------------------------------------------------------------------------------------
 * Таблица свойств представляет собой структуру данных, в которой хранятся пары "клю ч-значение". Такие таблицы
 * нередко используются для хранения сведений о па­раметрах настройки приложений и отличаются тремя характеристиками.
 *  	• Ключи и значения представлены символьными строками.
 *  	• Всю структуру данных легко записать и прочитать из файла.
 *  	• Имеется вспомогательная таблица для значений, устанавливаемых по умолчанию.
 * ---------------------------------------------------------------------------------------------------------
 * ВНИМАНИЕ! Исторически сложилось так, что класс Properties реализует интерфейс Map<Object, Object>. Это дает
 * возможность пользоваться методами get() и put() из ин­терфейса Мар. Но метод get() возвращает тип Object, а метод
 * put() позволяет ввести любой объект. Поэтому на практике лучше пользоваться методами getProperty() и setProperty(),
 * оперирующими символьными строками, а не объектами.
 * ---------------------------------------------------------------------------------------------------------
 * НА ЗАМЕТКУ! Свойства хранятся в простой таблице, не имеющей иерархической структуры. Как правило, используется
 * фиктивная иерархия с именами ключей window.main.value, window.main.title и т.п. Но в классе Properties отсутствуют
 * методы для построения настоящей иерар­хической структуры. Если в файле хранится сложная информация о конфигурации
 * программы, в та­ком случае следует воспользоваться классом Preferences, описываемым в следующем разделе.
 * ---------------------------------------------------------------------------------------------------------
 * Как было показано выше, класс Properties позволяет легко загружать и сохра­нять информацию о конфигурации прикладной
 * программы. Но файлам свойств присущи следующие недостатки.
 * 		• В некоторых операционных системах вообще не поддерживаются начальные каталоги, что затрудняет выбор единого
 * 		  места для хранения конфигурацион­ных файлов.
 * 		• Стандартные условные обозначения имен конфигурационных файлов отсут­ствуют, что может привести к конфликтам
 * 		  имен, если пользователь установит несколько приложений.
 * ---------------------------------------------------------------------------------------------------------
 * •Properties()
 * 		Создает пустуют таблицу свойств.
 *
 * •Properties (Properties defaults)
 * 		Создает пустуют таблицу свойств с заданными по умолчанию значениями.
 * 			Параметры: defaults Значения по умолчанию, используемые для поиска
 *
 * •String getProperty(String key)
 * 		Возвращает символьную строку, связанную с заданным ключом, а если ключ в основной таблице свойств отсутствует,
 * 		то строку, связанную с ключом из таблицы со значениями, устанавливаемыми по умолчанию. Если ж е указанный ключ
 * 		отсутствует в таблице со значениями, устанавливаемыми по умолчанию, то возвращается пустое значение null.
 * 				Параметры: key Ключ, связанный с возвращаемой символьной строкой
 *
 * •String getProperty (String key. String defaultValue)
 * 		Возвращает символьную строку, связанную с указанным ключом. Если ж е ключ отсутствует в табли­ це свойств, то
 * 		возвращает свойство со значением , устанавливаемым по умолчанию.
 * 				Параметры: key Ключ, связанный с возвращаемой символьной строкой defaultValue Символьная строка, которая
 * 							возвращается, если ключ отсутствует в таблице свойств
 *
 * •Object setProperty (String key, String value)
 * 		Устанавливает свойство. Возвращает установленное ранее значение данного свойства по указан­ному ключу.
 * 			Параметры: key Ключ, связанный с устанавливаемой символьной строкой
 * 					 value Значение, связанное с указанным ключом
 *
 * •void load (Inputstream in) throws IOException
 * 		Загружает таблицу свойств из потока ввода.
 *			Параметры: in Поток ввода
 *
 * void store (Outputstream out, String header) 1.2
 * 		Направляет таблицу свойств в поток вывода.
 * 			Параметры: out Заданный поток вывода
 * 					header Заголовок, размещаемый в первой строке сохраняемого файла свойств
 * ---------------------------------------------------------------------------------------------------------
 */