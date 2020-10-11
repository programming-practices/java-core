package Examples.OOP.Others.mozno_li_peropredilit_vnutrennii_class;

class Egg {
    private Yolk y;

    public Egg() {
        System.out.println("Constructor Egg new Egg()");
        y = new Yolk();
    }

    protected class Yolk {

        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }
}

public class BiggEgg extends Egg {

    public static void main(String[] args) {
        BiggEgg bg = new BiggEgg();
//        BiggEgg.Yolk bgY = bg.new Yolk();

    }

    public class Yolk {

        public Yolk() {
            System.out.println("BiggEgg.Yolk()");
        }
    }

}
