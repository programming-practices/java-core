package _final.final_arguments;

public class Child extends Parent {
    @Override
    void f(int age) {
        age = 1;
        super.f(age);
        age = 2;
    }
}
