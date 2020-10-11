package Examples.OOP.Others.class_use.inner_class.ssilkaNaVneniiClass;

public class Main {
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));

        }

        // Riwenie vpravu_9_11

        sequence.ItrSqec();


        // Oreginal Sequence

//        Selector selector = sequence.selector();
//        while (!selector.end()){
//            System.out.print(selector.current() + " ");
//            selector.nextGenerator();
//        }
    }
}
