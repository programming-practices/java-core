package Examples.OOP.Others.class_use.nested_class_staticheskiiVlozeniiClass;

import Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new2.Contents;
import Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new2.Destination;

// Vlozenii (staticheskii vnutrennii) class.

public class Parcel11 {

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tanzania!");
    }

    private static class ParcelContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {

        static int x = 10;
        private String label;

        private ParcelDestination(String wherTo) {
            label = wherTo;
        }

        public static void f() {
        }

        @Override
        public String readLabel() {
            return label;
        }

        static class AnotherLevel {
            static int x = 10;

            public static void f() {
            }
        }
    }
}
