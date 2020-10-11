package Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new;

public class Parcel3 {

    class Conect {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destinaton {
        private String label;

        Destinaton(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

}
