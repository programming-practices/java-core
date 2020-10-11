package Examples.OOP.Others.class_use.anonymous_class.anonimnie_vnutrenie_class;

// Vozvrawchenie ekzemplara annimnoho vnytrenniho classa.

import Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new2.Contents;

public class Parcel7 {
    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }

    public Contents contents() {
        return new Contents() {
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };   // Tochka s zapyatoy zdes neobxodima
    }
}
