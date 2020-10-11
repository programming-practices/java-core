package _final.final_arguments;

public class Parent {
    private String name;

    public Parent() {
    }

    public Parent(final String name) {
//        fildFinal = "www";      //Error
        this.name = name;
    }

    void f(final int age) {
//        age = 1;    //Error
    }
}
