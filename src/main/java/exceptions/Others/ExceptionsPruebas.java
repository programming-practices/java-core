package exceptions.Others;

public class ExceptionsPruebas {

    public static int devide(int valueOne, int valueTwo) {
        int c = valueOne / valueTwo;
        return c;
    }

    public static int[] array() {
        int[] arr = {1};
        arr[45] = 1;
        return arr;
    }
}
