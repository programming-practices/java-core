package JAR_JavaArchive;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.prefs.Preferences;

/**
 * A program to test preference settings. The program remembers the frame
 * position, size, and title.
 *
 * @author Cay Horstmann
 * @version 1.03 2015-06-12
 */
public class ExamplePreferences {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PreferencesFrame frame = new PreferencesFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame that restores position and size from user preferences and updates the
 * preferences upon exit.
 */
class PreferencesFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    /*Поиск требуемого узла в дереве начинается с пользовательского или системного корня:*/
    private Preferences root = Preferences.userRoot();
    //	private Preferences root = Preferences.systemRoot();
    /*И тогда для доступа к узлу достаточно указать соответствующий путь:*/
    private Preferences node = root.node("/com/horstmann/corejava");
	/* Для быстрого и удобного доступа к узлу дерева путь к нему приравнивается к име­ни пакета его класса. Для этого 
	 * достаточно взять объект данного класса и сделать вы­зов одним из двух приведенных ниже способов. Как правило, 
	 * ссылка obj означает ссылку this:
				Preferences node = Preferences.userNodeForPackage(obj.getClass());
											или
				Preferences node = Preferences.systemNodeForPackage(obj.getClass());*/

    public PreferencesFrame() {
        // get position, size, title from preferences
        int left = node.getInt("left", 0);
        int top = node.getInt("top", 0);
        int width = node.getInt("width", DEFAULT_WIDTH);
        int height = node.getInt("height", DEFAULT_HEIGHT);
        setBounds(left, top, width, height);

        // if no title given, ask user
        String title = node.get("title", "");
        if (title.equals(""))
            title = JOptionPane.showInputDialog("Please supply a frame title:");
        if (title == null)
            title = "";
        setTitle(title);

        // set up file chooser that shows XML files
        final JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileFilter(new FileNameExtensionFilter("XML files", "xml"));

        // set up menus
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem exportItem = new JMenuItem("Export preferences");
        menu.add(exportItem);
        exportItem.addActionListener(event -> {
            if (chooser.showSaveDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION) {
                try {
                    savePreferences();
                    OutputStream out = new FileOutputStream(chooser.getSelectedFile());
                    node.exportSubtree(out);
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem importItem = new JMenuItem("Import preferences");
        menu.add(importItem);
        importItem.addActionListener(event -> {
            if (chooser.showOpenDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION) {
                try {
                    InputStream in = new FileInputStream(chooser.getSelectedFile());
                    Preferences.importPreferences(in);
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> {
            savePreferences();
            System.exit(0);
        });
    }

    public void savePreferences() {
        node.putInt("left", getX());
        node.putInt("top", getY());
        node.putInt("width", getWidth());
        node.putInt("height", getHeight());
        node.put("title", getTitle());
    }
}


/*
------------------------------------------------------------------------------------------------------------------------
•Preferences userRoot()
Возвращает корневой узел из дерева глобальных параметров настройки для пользователя вызы­
вающей программы.
•
Preferences systemRoot()
Возвращает системный корневой узел из дерева глобальных параметров настройки.
•
Preferences node(String path)
Возвращает узел, доступный из текущего узла по заданному пути. Если в качестве параметра path
указан абсолютный путь, который обычно начинается со знака косой черты ( /) , то узел доступен
из корня дерева глобальных параметров настройки. Если узел отсутствует по заданному пути, он
создается.
•
Preferences userNodeForPackage(Class cl)
•
Preferences systexriNodeForPackage(Class cl)
Возвращают узел из дерева текущего пользователя или системного дерева, абсолютный путь к ко­
торому соответствует имени пакета, содержащего заданный класс cl.
• String[] keys ()
Возвращает все ключи, принадлежащие данному узлу.
•
String get (String key, String defval)
•
int getlnt (String key, int defval)
•
long getLong (String key, long defval)
•
float getFloat(String key, float defval)
•
double getDouble (String key, double defval)
•
boolean getBoolean (String key, boolean defval)
•
byte[] getByteArray (String key, byte[] defval)
Возвращают значение, связанное с заданным ключом. Если значение отсутствует в хранилище
глобальных параметров настройки, имеет неверный тип или ж е само хранилище недоступно, воз­
вращается значение, предусмотренное по умолчанию.
•
void put (String key, String value)
•
void putlnt (String key, int value)
•
void putLong (String key, long value)
• void putFloat (String key, float value)
• void putDouble (String key, double value)
•
void putBoolean (String key, boolean value)
•
void putByteArray (String key, byte[] value)
Сохраняют пару "ключ-значение" в заданном узле дерева.
•
void exportSubtree (Outputstream out)
Выводит в указанный поток глобальные параметры настройки, хранящиеся в заданном узле и про­
изводных от него узлах.
•
void exportNode (Outputstream out)
Направляет в указанный поток вывода глобальные параметры настройки, хранящиеся в заданном
узле, игнорируя производные от него узлы.
•
void importPreferences (Inputstream in)
Импортирует параметры глобальных настроек из указанного потока ввода.
------------------------------------------------------------------------------------------------------------------------
*/
