package _static;

public class ExampleStaticClass {

    public void method() {

    }

    public static class PublicInnerStatic {

        public static void method() {
        }
    }

    public class PublicInnerNotStatic {

        public void method() {
        }
    }

}


class Main {
    public static void main(String[] args) {

        ExampleStaticClass.PublicInnerStatic publicInnerStatic = new ExampleStaticClass.PublicInnerStatic();
        ExampleStaticClass.PublicInnerStatic.method();

//----------------------------------------------------------------------------------------------------------------------

//        StaticClass.PublicInnerNotStatic publicInnerNotStatic0= new StaticClass().PublicInnerNotStatic();  // ERROR
        ExampleStaticClass exampleStaticClass = new ExampleStaticClass();
        ExampleStaticClass.PublicInnerNotStatic publicInnerNotStatic1 = exampleStaticClass.new PublicInnerNotStatic();
    }
}
