package Examples.OOP.Others.class_use.inner_class.sozdanie_Ekzemplara_Vnutrenneho_Classa_new2;

public class Parcel4 {

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PConects();
    }

    private class PConects implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }
}
