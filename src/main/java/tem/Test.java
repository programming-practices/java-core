package tem;

public class Test {

    static final MyR myR1OFinal = new MyR("O", 34);
    static MyR myR1ONotFinal = new MyR("O", 34);
    static MyR myR2N = new MyR("N", 45);

    public static void cambiarMyR(MyR valueOld, MyR valueNew) {
        valueOld = valueNew;
        // System.out.println("From method: " + valueOld);
    }

    public static void main(String[] args) {
        System.out.println("-----------------final----------------");
        cambiarMyR(myR1OFinal, myR2N);
        System.out.println(myR1OFinal);
        System.out.println(myR2N);

        System.out.println("------------- not final---------------");
        cambiarMyR(myR1ONotFinal, myR2N);
        System.out.println(myR1ONotFinal);
        System.out.println(myR2N);
    }
}

class MyR {
    private String name;
    private int age;

    public MyR(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyR{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
