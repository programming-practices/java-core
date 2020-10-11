package Examples.OOP.Others.class_use.anonymous_class.anonimnie_vnutrenie_class;

// Anonimnui vnutrennii class, vupolnaiywchii inicializaciy
// (sokrawchennaya versia Parcel5.java).

import Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new2.Destination;

public class Parcel9 {

    // Dlya ispolzovania v anonimnom vnytrenom clase
    // arhument dolzen bit obyavlon kak final.

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tanzania");
    }

    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }
}
