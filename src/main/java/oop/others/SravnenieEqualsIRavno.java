package Examples.OOP.Others;

/**
 * Created by drago on 08.07.2017.
 */
public class SravnenieEqualsIRavno {
    public static void main(String[] args) {
        BB bb = new BB(100);
        BB bb1 = new BB(100);
        BB bb2 = bb;
//        bb.i = 100;
//        bb1.i = 100;
        System.out.println(bb.equals(bb1));
        System.out.println(bb == bb1);
        System.out.println();

        System.out.println(bb == bb2);
        System.out.println(bb.equals(bb2));
        System.out.println();

        AA aa = new AA(10);
        AA aa1 = new AA(10);
//        aa.i = aa1.i = 100;
        System.out.println(aa.equals(aa1));
        System.out.println(aa.i == aa1.i);

    }

    static class BB {
        int i;

        BB(int i) {
            this.i = i;
        }
    }

    static class AA {
        int i;

        AA(int i) {
            this.i = i;
        }

        public AA() {

        }
    }
}
