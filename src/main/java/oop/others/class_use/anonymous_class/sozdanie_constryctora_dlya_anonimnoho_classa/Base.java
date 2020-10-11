package Examples.OOP.Others.class_use.anonymous_class.sozdanie_constryctora_dlya_anonimnoho_classa;

// Sozdanie konstryktora dly anonimnoho vnytrenoho classa.

public abstract class Base {
    public Base(int i) {
        System.out.println("Bazovii konstructor i = " + i);
    }

    public abstract void f();


    public static class AnonymousConstructor {
        public static Base getBase(int i) {
            return new Base(i) {
                {
                    System.out.println("V inicializatore ekzemplara");
                }

                @Override
                public void f() {
                    System.out.println("V anonimnom q()");
                }
            };
        }

        public static void main(String[] args) {
            Base b = getBase(47);
            b.f();
        }
    }
}
