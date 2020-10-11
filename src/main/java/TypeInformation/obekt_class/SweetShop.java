package TypeInformation.obekt_class;

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
//    static { print("Books.Filosofia_Java.hlava_14.obekt_class.Gum1"); }
}

//class Gum2 {
//    static class ee{
//        public static void main(String[] args) {
//            System.out.println("ee");
//        }
//    }
//    static { print("Loading Gum"); }
////    static { print("Books.Filosofia_Java.hlava_14.obekt_class.Gum1"); }
//}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");

//        Class.forName("Gum");
        try {
            Class.forName("Examples.TypeInformation.obekt_class.Gum");
//            Class.forName("Books.Filosofia_Java.hlava_14.obekt_class.Gum1");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
