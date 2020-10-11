package Examples.OOP.Others.class_use.anonymous_class.anonimnie_vnutrenie_class;

// Razwerenie versii Parcel7.java

import Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new2.Contents;

public class Parcel7b {

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
    }

    public Contents contents() {
        return new MyContents();
    }

    class MyContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }
}
