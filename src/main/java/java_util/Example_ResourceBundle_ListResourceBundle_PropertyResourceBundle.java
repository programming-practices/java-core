package java_util;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Example_ResourceBundle_ListResourceBundle_PropertyResourceBundle {
    public static void main(String[] args) {
        // Demonstrate age resource bundle.
        ResourceBundle rd = ResourceBundle.getBundle("SampleRB");

        System.out.println("English version: ");
        System.out.println("String for Title key : " + rd.getString("title"));

        System.out.println("String for StopText key: " + rd.getString("StopText"));

        System.out.println("String for StartText key: " + rd.getString("StartText"));

        rd = ResourceBundle.getBundle("SampleRB", Locale.GERMAN);

        System.out.println("\nGerman version: ");
        System.out.println("String for Title key : " + rd.getString("title"));

        System.out.println("String for StopText key: " + rd.getString("StopText"));

        System.out.println("String for StartText key: " + rd.getString("StartText"));
    }
}

// Default version (English).
class SampleRB extends ListResourceBundle {
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "My Program";

        resources[1][0] = "StopText";
        resources[1][1] = "Stop";

        resources[2][0] = "StartText";
        resources[2][1] = "Start";

        return resources;
    }
}

// German version.
class SampleRB_de extends ListResourceBundle {
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "Mein Programm";

        resources[1][0] = "StopText";
        resources[1][1] = "Anschlag";

        resources[2][0] = "StartText";
        resources[2][1] = "Anfang";

        return resources;
    }
}

class SampleRB_ru extends ListResourceBundle {
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "апппп";

        resources[1][0] = "StopText";
        resources[1][1] = "ццццц";

        resources[2][0] = "StartText";
        resources[2][1] = "ыыыыыыы";

        return resources;
    }
}
