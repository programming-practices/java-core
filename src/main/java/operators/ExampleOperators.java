package operators;

public class ExampleOperators {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            if (i % 2 == 0) continue;
            System.out.println();
        }


//        int i = 3;
//
//        if(i < 5)break;
//
//        while(i == 3)break;
//
//        for(int j = 0; j < 5; j++)if(i < 5)break;
//
//        if(i < 5)for(int j = 0; j < 5; j++)break;

//        char c = (char) System.in.read();
//        while(c == '2'){
//            System.out.println("Hola");
//            break;
//
//        }

//        int i = System.in.read();  //// ERROR of program
//        while(i == 2){
//            System.out.println("Hola");
//            break;
//        }
//
//        System.out.println(i);
//        char rr = '2';
//        int ee = (char) rr;
//        System.out.println(ee);

//        int i = 3;
//        while(i-- > 0){
//            System.out.println("Hola i = " + i);
//        }
//
//        System.out.println();
//        int i1 = 3;
//        while(--i1 > 0){
//            System.out.println("Hola i1 = " + i1);
//        }


//        int a = 2;
//        int b = 2;
//        if(a == b){
//            System.out.println("Kakoeto deistvie v if");
//        }else
//            System.out.println("Kakoeto deistvie v else 1");
//            // eta cahst ne naxoditsa v else, ona naxoditsa poza deistviem else
//            System.out.println("Kakoeto deistvie v else 2");


        //        int a = 2;
//        int b = 2;
//        if(a == b){
//
//        }else if(a == b){
//
//        }else if(a == b){
//
//        }
// ---------------------------------------------------------------------------------------------------------------------
        int x = 1;
        x++;
        x = 2 + +1; //  2 + (+1)
        x = 2 + -1; //  2 + (-1)
// ---------------------------------------------------------------------------------------------------------------------
        // Eto nazivaetsa celochislennum deleniem
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i + " / 2 = " + i / 2);
//            System.out.println(i + " / 2.0 = " + i / 2.0);
//        }

        // Eto normalnoe dilenie
//        for (double i = 0; i < 10; i++) {
//            System.out.println(i + " / 2 = " + i / 2);
//        }
// ---------------------------------------------------------------------------------------------------------------------
        // Dilit celoe chislo na nol nelza
//        System.out.println(1 / 0);

        // Dilit drobnoe chislo na nol razrewaetsa
//        System.out.println(1.0 / 0);        // Infinity
//        System.out.println(-1.0 / 0);        // -Infinity
//        System.out.println(0.0 / 0);        // NaN
// ---------------------------------------------------------------------------------------------------------------------
        String s = "123.4";
        double d = Double.valueOf(s);
        System.out.println(d * 2);

//        String s1 = "gsrhh tw@ 123.4";
//        double d1 = Double.valueOf(s1);
//        System.out.println(d1 * 2);

        String s2 = "NaN";
        double d2 = Double.valueOf(s2);
        System.out.println(d2 * 2);
// ---------------------------------------------------------------------------------------------------------------------
    }
}

/*
------------------------------------------------------------------------------------------------------------------------
Mozno skazat chto Operator + / * -  pereopredelon dlya int, long, double, float.
------------------------------------------------------------------------------------------------------------------------

*/
