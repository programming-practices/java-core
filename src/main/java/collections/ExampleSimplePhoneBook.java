package collections;

import java.io.*;
import java.util.Properties;

// A simple telephone number database that uses
public class ExampleSimplePhoneBook {
    private final Properties properties = new Properties();
    private final BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));
    private final String optionesMenu = "MENU: \n" +
            "1.Add Phone Number(print to 1)\n" +
            "2.Find Phone Number(print to 2)\n" +
            "3.Get All Phone Book(print to 3)\n" +
            "4.Exit(print 4)\n";
    private BufferedReader bufferedReadrFromFile = null;
    private FileInputStream fileInputStream = null;
    private FileOutputStream fileOutputStream = null;
    private String name, number;
    private boolean changed = false;

    public void menu() throws IOException {
        System.out.println(optionesMenu);
        String optionMenu = "";
        do {
            optionMenu = bufferedReaderFromConsole.readLine();
            if (optionMenu.equals("1")) {
                addNewPhoneNumber();
                System.out.println();
                System.out.println(optionesMenu);
            } else if (optionMenu.equals("2")) {
                getPhoneNumber();
                System.out.println();
                System.out.println(optionesMenu);
            } else if (optionMenu.equals("3")) {
                getAllPhoneBook();
                System.out.println();
                System.out.println(optionesMenu);
            } else if (optionMenu.equals("4")) {
                System.out.println();
                System.out.println("Good Bue...Thenqiu");
                break;
            }
        } while (true);

        // bad idea work this
        bufferedReadrFromFile.close();
        bufferedReaderFromConsole.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

    private void addNewPhoneNumber() throws IOException {
        // Try to open phonebook.dat file.
        try {
            fileInputStream = new FileInputStream("src/main/resources/phonebook.dat");
        } catch (FileNotFoundException e) {
            // ignore missing file
        }

    /* If phonebook file already exists,
       load existing telephone numbers. */
        try {
            if (fileInputStream != null) {
                properties.load(fileInputStream);
                fileInputStream.close();
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        // Let user enter new names and numbers.
        do {
            System.out.println("Enter new name ('quit' to stop): ");
            name = bufferedReaderFromConsole.readLine();
            if (name.equals("quit")) continue;

            System.out.println("Enter number: ");
            number = bufferedReaderFromConsole.readLine();

            properties.put(name, number);
            changed = true;
        } while (!name.equals("quit"));
    }

    private void getPhoneNumber() throws IOException {
        // If phone book data has changed, save it.
        if (changed) {
            fileOutputStream = new FileOutputStream("src/main/resources/phonebook.dat");

            properties.store(fileOutputStream, "Telephone Book");
            fileOutputStream.close();
        }

        // Look up numbers given age name.
        do {
            System.out.println("Enter name to find ('quit' to quit): ");
            name = bufferedReaderFromConsole.readLine();
            if (name.equals("quit")) continue;

            number = (String) properties.get(name);
            System.out.println(number);
        } while (!name.equals("quit"));
    }

    private void getAllPhoneBook() throws IOException {
        bufferedReadrFromFile = new BufferedReader(new FileReader("src/main/resources/phonebook.dat"));
        while (bufferedReadrFromFile.ready()) {
            String value = bufferedReadrFromFile.readLine();
            if (value.equals(null)) break;
            System.out.println(value);
        }
    }
}

class MainSimplePhoneBook {
    public static void main(String[] args) throws IOException {
        ExampleSimplePhoneBook simplePhoneBook = new ExampleSimplePhoneBook();
        simplePhoneBook.menu();
    }
}

/*



 */
