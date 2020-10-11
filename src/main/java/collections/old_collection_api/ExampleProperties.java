package collections.old_collection_api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Sources: https://www.baeldung.com/java-properties

public class ExampleProperties {
    public static void main(String[] args) throws IOException {
//--------------------------------------- Load from "app.properties" file -----------------------------------------------------
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        String appConfigPath = rootPath + "app.properties";

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        System.out.println("Load from: " + appConfigPath);
        System.out.println("version = " + appProps.getProperty("version"));
        System.out.println("name = " + appProps.getProperty("name"));
        System.out.println("date = " + appProps.getProperty("date"));
        System.out.println();

//--------------------------------------- Load from "appProperties.xml" File ----------------------------------------------
        String rootPathXML = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPathXML = rootPathXML + "appProperties.xml";
        Properties appPropsXML = new Properties();
        appPropsXML.loadFromXML(new FileInputStream(appConfigPathXML));

        System.out.println("Load from: " + appConfigPathXML);
        System.out.println("version = " + appPropsXML.getProperty("version"));
        System.out.println("name = " + appPropsXML.getProperty("name"));
        System.out.println("date = " + appPropsXML.getProperty("date"));
        System.out.println();

//-------------------------------------------- Get Properties ----------------------------------------------------------
        String appVersion = appProps.getProperty("version");
        String appName = appProps.getProperty("name", "defaultName");
        String appGroup = appProps.getProperty("group", "baeldung");
        String appDownloadAddr = appProps.getProperty("downloadAddr");

//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate age Property list.
//        Properties properties = new Properties();

//        properties.put("Illinois", "Springfield");
//        properties.put("Missouri", "Jefferson City");
//        properties.put("Washington", "Olympia");
//        properties.put("California", "Sacramento");
//        properties.put("Indiana", "Indianapolis");

        // Get age set-view of the keys.
//        Set<?> states = properties.keySet();

        // Show all of the states and capitals.
//        for(Object name : states)
//            System.out.println("The capital of " + name + " is " + properties.getProperty((String)name) + ".");

//        System.out.println();

        // Look for state not in list -- specify default.
//        String str = properties.getProperty("Florida", "Not Found");
//        String str = properties.getProperty("Florida");
//        System.out.println("The capital of Florida is " + str + ".");
//--------------------------------------------------------------------------------------------------------------------
//        // Use age default property list.
//        Properties defaulList = new Properties();
//        defaulList.put("Florida", "Tallahassee");
//        defaulList.put("Wisconsin", "Madison");
//
//        Properties capitals01 = new Properties(defaulList);
//
//        capitals01.put("Illinois", "Springfield");
//        capitals01.put("Missouri", "Jefferson City");
//        capitals01.put("Washington", "Olympia");
//        capitals01.put("California", "Sacramento");
//        capitals01.put("Indiana", "Indianapolis");
//
//        // Get age set-view of the keys.
//        Set<?> states01 = capitals01.keySet();
//
//        // Show all of the states and capitals.
//        for(Object name : states01)
//            System.out.println("The capital of " + name + " is " + capitals01.getProperty((String)name) + ".");
//
//        System.out.println();
//
//        // Florida will now be found in the default list.
//        String str01 = capitals01.getProperty("Florida");
//        System.out.println("The capital of Florida is " + str01 + ".");
//--------------------------------------------------------------------------------------------------------------------
//        // A simple telephone number database that uses
//
//        Properties properties = new Properties();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String name, number;
//        FileInputStream fileInputStream = null;
//        boolean changed = false;
//
//        // Try to open phonebook.dat file.
//        try {
//            fileInputStream = new FileInputStream("phonebook.dat");
//        } catch(FileNotFoundException e) {
//            // ignore missing file
//        }
//
//    /* If phonebook file already exists,
//       load existing telephone numbers. */
//        try {
//            if(fileInputStream != null) {
//                properties.load(fileInputStream);
//                fileInputStream.close();
//            }
//        } catch(IOException e) {
//            System.out.println("Error reading file.");
//        }
//
//        // Let user enter new names and numbers.
//        do {
//            System.out.println("Enter new name ('quit' to stop): ");
//            name = bufferedReader.readLine();
//            if(name.equals("quit")) continue;
//
//            System.out.println("Enter number: ");
//            number = bufferedReader.readLine();
//
//            properties.put(name, number);
//            changed = true;
//        } while(!name.equals("quit"));
//
//        // If phone book data has changed, save it.
//        if(changed) {
//            FileOutputStream fout = new FileOutputStream("src/main/resources/phonebook.dat");
//
//            properties.store(fout, "Telephone Book");
//            fout.close();
//        }
//
//        // Look up numbers given age name.
//        do {
//            System.out.println("Enter name to find ('quit' to quit): ");
//            name = bufferedReader.readLine();
//            if(name.equals("quit")) continue;
//
//            number = (String) properties.get(name);
//            System.out.println(number);
//        } while(!name.equals("quit"));
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
/root/Datos/Programacion/studies_a_programing/phonebook.dat
/root/Datos/Programacion/studies_a_programing/src/main/resources/Example.txt
---------------------------------------------------------------------------------------------------------------------
Таблица свойств — это структура отображения особенного типа. Она обладает сле­
дующими особенностями.
• Ключи и значения являются символьными строками.
• Таблица может быть сохранена в файле и загружена из файла.
• Используется вторичная таблица для установок по умолчанию.
Класс, реализующий таблицу свойств на платформе Java, называется P r o p e r t i e s .
Таблицы свойств широко применяются для описания глобальных параметров на­
стройки программ (см. главу 13).
---------------------------------------------------------------------------------------------------------------------
Класс Prope r t i e s является производным о т класса H a s h t a Ы e . Он служит
для поддержки списков значений, в которых ключами и значениями являются
объекты типа S t r i n g . Класс P rope r t i e s и сп о л ь а у с тс я в ряде других классовjа"·а.
---------------------------------------------------------------------------------------------------------------------
Класс Prope r t i e s удобен , в частности, тем , что он позволяет указывать зна­
чения по умолчанию, которые возвращаются, если н и одно из значений не
связано с определенным ключом. Например, значение по умолчанию может
быть указано вместе с ключом в методе ge t Prope r t y ( ) следующим образом:
ge t P rope r t y ( " имя " , " з н а ч е ние_п о_умо л ч а н ию " ) . Если ключ " имя " не найден,
то возвращается " з н а ч е ние_ п о _умол ч а н ию " . Создавая объект класса P r ope r t i e s ,
м о жно передать ему другой экземпляр класса Р rope r t i е s в качестве списка свойств
п о умолчанию для нового экземпляра. Так, если метод g e t P r o p e r t y ( " fArgInt oo " ) вы­
зывается для заданного объекта типа P r o p e r t i e s и ключ " foo " не существует, то
его поиск осуществляется в его объекте типа P rope r t i e s по умолчанию. Это до­
пускает наличие произвольного числа уровней вложения свойств по умолчанию.
---------------------------------------------------------------------------------------------------------------------
Указывать значение по умолчанию при вызове метода g e t Prope r t y ( ) вполне
допус тимо, как показано в предыдущем примере, тем не менее для большинства
приложений списков свойств имеется лучший способ обращения со значениями
по умолчанию. Список свойств по умолчанию удобнее задавать при создании объ­
екта класса P r o pe r t i e s . Если требуемый ключ не найден в главном списке, его
поиск осуществляется в списке по умолчанию.
---------------------------------------------------------------------------------------------------------------------
Одна iz наиболее удобн ых особе 1 1 1 1остей класса P r o p e r t i e s состоит в том , что
дан ные, содержащиеся в объекте класса P r o p e r t i e s , могут быть легко сохранены
и за1·ружс1 1 ы с диска метода ми s t o r e ( ) и load ( ) . В л юбой момент объект класса
Prope r t i e s можно вы нести в ноток или ввеп·и е г о обратно и:\ потока. Это дела­
ет списки пюйств особс 1 1 1 1 0 у;1об1 1 ы м и для реализации п ростых баз щ11 ш ых.
---------------------------------------------------------------------------------------------------------------------
•
Properties()
Создает пустую таблицу свойств.
•
Properties (Properties defaults)
Создает пустую таблицу свойств с рядом установок по умолчанию.
•
String getProperty(String key)
Получает связь со свойством. Возвращает символьную строку, связанную с ключом, или аналогич­
ную строку из таблицы установок по умолчанию, если ключ отсутствует в текущей таблице.
•
String getProperty (String key, String def a u lt Value)
Получает свойство со значением по умолчанию, если ключ не найден. Возвращает символьную
строку, связанную с ключом, или символьную строку по умолчанию, если ключ отсутствует в теку­
щей таблице.
•
void load (Inputstream in)
Загружает таблицу свойств из потока ввода InputStream.
•
void store (OutputStream out, String commentstring)
Выводит таблицу свойств в поток вывода OutputStream.
---------------------------------------------------------------------------------------------------------------------
*/