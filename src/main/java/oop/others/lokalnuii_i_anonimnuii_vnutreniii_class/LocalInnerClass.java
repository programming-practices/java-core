package Examples.OOP.Others.lokalnuii_i_anonimnuii_vnutreniii_class;

//  Xranit posledovatelnost obektof

interface Counter {
    int next();
}

public class LocalInnerClass {

    private int count = 0;

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Localnuii"),
                c2 = lic.getCounter2("Anonimnuii");

        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }

    Counter getCounter(final String name) {

        // Lokalnii vnutrennii class
        class LocalCounter implements Counter {

            public LocalCounter() {
                // Y loclnoho vnytrenoho classa
                // moset bit sobstvennii konstryktor
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.print(name + " ");
                return count++;
            }
        }
        return new LocalCounter();
    }

    // Toze samoe s anonimnum vnutrennim classom
    Counter getCounter2(final String name) {
        return new Counter() {
            // Anonimnuii vnytrrenii class ne mozet soderzat
            // imenovanoho konstryktora, tolko inicializator ekzemplyara:

            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.print(name + " ");  // Ne izmennii arhyment
                return count++;
            }
        };
    }
}
