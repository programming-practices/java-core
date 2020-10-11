package _final;

public class ExampleFinalReference {
    public static void main(String[] args) {
        final TestExampleFinalReference teF = new TestExampleFinalReference("WWWWWWWW", 90);
        TestExampleFinalReference teNF = new TestExampleFinalReference("QQQQQQQQ", 78);

//        teF = teNF;  // ERROR

        System.out.println(teF);
        System.out.println("----------------------------------------------------");
        teF.setName("XXXXXXXXXXX");
        teF.setAge(11);
        System.out.println(teF);
    }

}

class TestExampleFinalReference {
    private String name;
    private int age;

    public TestExampleFinalReference(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestExampleFinalReference{name='" + name + "\', age=" + age + "}";
    }
}