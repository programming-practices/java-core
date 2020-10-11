package stringAPI._string;

public class ExampleStringValueOf {
    public static void main(String args[]) {

        double dou = 102939939.939;
        boolean bul = true;
        long lon = 1232874;
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        System.out.println("Return Value : " + String.valueOf(dou));
        System.out.println("Return Value : " + String.valueOf(bul));
        System.out.println("Return Value : " + String.valueOf(lon));
        System.out.println("Return Value : " + String.valueOf(arr));
    }
}
