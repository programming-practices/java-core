package _final;

public class ExampleFinalObject {
    public static void main(String[] args) {
        ClassNotFinal classNotFinal = new ClassNotFinal();
        ClassFinal classFinal = new ClassFinal();

        // Final Objects nerazrewaetsa menat reference
        // ERROR
//        classNotFinal.classAX00 = classFinal;


        // Final Object razrewaetsa menat pola
        classNotFinal.classAX00.name = "ererr";
        System.out.println(classNotFinal.classAX00);
        System.out.println(classNotFinal);
    }

}

class ClassNotFinal {
    public final ClassFinal classAX00 = new ClassFinal();

    @Override
    public String toString() {
        return "ClassNotFinal{classAX00=" + classAX00 + "}";
    }
}

final class ClassFinal {
    public String name = "WWW";

    @Override
    public String toString() {
        return "ClassFinal{fild='" + name + "\'}";
    }
}
