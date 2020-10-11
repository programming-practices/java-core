package Examples.OOP.Others.class_use.local_class.local_class_2;

import Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new2.Destination;

public class Parcel5 {
    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tanzania");
    }

    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }
}
