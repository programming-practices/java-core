package Examples.OOP;

public class ExamplePodrazriadnueOperacii {
    public static void main(String[] args) {

        int a = 2;
        int b = 2;
        int c = 1;

        int i = a | 4 + c >> b & 7;
        int i1 = (a | (((4 + c) >> b) & 7));

        System.out.println(i);
        System.out.println(i1);

//        int i, k;
//        i = 10;
//        k = i < 0 ? -i : i;
//
//        int i1, k1;
//        i1 = -10;
//        k1 = i1 < 0 ? -i1 : i1;
//
//        System.out.println(k);
//        System.out.println(k1);


//        int a, b, c;
//        a = b = c = 100;
//        // compiles without errors
//
//        int demo = 6;
//        int num = 2;
//        int ratio = demo == 0 ? 0 : demo / num;
//        System.out.println(ratio);
//
//        double demo2 = 6;
//        double num2 = 2;
//        double ratio2 = demo == 0 ? 0 : ((double) num / demo);
//        System.out.println(ratio2);


//        int e = 2;
//        int c = 1;
//        int d = 0;
//        if(c == 1 & e++ < 100) d = 100;
//        // out d = 100;
//        // out c = 2;
//        // out e = 3;
//
//        System.out.println("d = " + d);
//        System.out.println("c = " + c);
//        System.out.println("e = " + e);


//        boolean bTrue = true;
//        boolean bFalse = false;
//        if(/*!bFalse*/  !bTrue){
//            System.out.println("hola");
//        }


//        int a = 1;
//        int b = 2;
//        int c = 3;
//
//        a |= 4;
//        b >>= 1;
//        c <<= 1;
//        a ^= c;
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        System.out.println("c = " + c);


//        char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','fArgInt'};
//
//        byte b = (byte) 0xf1;
//        byte c = (byte) (b >> 4);
//        byte d = (byte) (b >>> 4);
//        byte e = (byte) ((b & 0xff) >> 4);
//        System.out.println(" b = 0x" + hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);
//        System.out.println(" b >> 4 = 0x" + hex[(c >> 4) & 0x0f] + hex[c & 0x0f]);
//        System.out.println(" b >>> 4 = 0x" + hex[(d >> 4) & 0x0f] + hex[d & 0x0f]);
//        System.out.println(" (b & 0x0f) >> 4 = 0x" + hex[(e >> 4) & 0x0f] + hex[e & 0x0f]);

//        byte b = (byte) 0xf1;
//        System.out.println("b = 0x" + hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);

//        int e1 = 6;
//        int g1 = e1 >> 1;
//        System.out.println(g1);
//
//        int e = 2;
//        int g = e << 1;
//        System.out.println(g << 1);
//
//        byte a = 64, b;
//        int i;
//
//        i = a << 2;
//        b = (byte)(a << 2);
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//        System.out.println("i = " + i);

//        int a = 1;
//        int b = 1;
//        int x = a >> b;
//        int y = ~2;
//        Integer i = 200;
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(i.byteValue());
    }

}
