package Examples.OOP;

interface Animal {

    int i = 5;

    void eat();

    public static enum E {

    }

    public static interface MyInnerInterface {
        int i = 5;

        void eat();
    }

    public static class MyInnerClass {

    }
}

interface Cat extends Animal {
    void move();
}

public class InterfacesLesson {
    public static void main(String[] args) {

    }
}

class Tiger implements Animal, Cat {
    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }
}