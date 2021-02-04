package tem;

public class Example11 {
    public static void main(String[] args) {
        Object[] o1 = new Object[]{1, 2, 3};
        Object[] o2 = new Object[]{1, 2, 3};

        if(o1.equals(o2)) {
            System.out.println("to arrays is equals");
        }
    }
}
