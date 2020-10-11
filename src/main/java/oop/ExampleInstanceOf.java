package oop;

import static java.lang.System.out;

public class ExampleInstanceOf {
    public static void main(String args[]) {
        DogParent dogParent = new DogParent();
        CatParent catParent = new CatParent();
        ChildDogOne childDogOne = new ChildDogOne();
        ChildDogTwo childDogTwo = new ChildDogTwo();

        out.println(dogParent instanceof DogParent ? "dogParent is instance of DogParent" : "dogParent isn't instance of DogParent");

        out.println(catParent instanceof CatParent ? "catParent is instance of CatParent" : "catParent isn't instance of CatParent");

        out.println(childDogOne instanceof ChildDogOne ? "childDogOne is instance of ChildDogOne" : "childDogOne isn't instance of ChildDogOne");

        out.println(childDogOne instanceof DogParent ? "childDogOne is instance of DogParent" : "childDogOne isn't instance of DogParent");

        out.println(dogParent instanceof ChildDogOne ? "dogParent is instance of ChildDogOne" : "dogParent isn't instance of ChildDogOne");

        out.println();

        // compare types of derived types
        DogParent dogParent1;
        dogParent1 = childDogTwo; // A reference to d
        out.println("dogParent1 now refers to childDogTwo");
        out.println(dogParent1 instanceof ChildDogTwo ? "dogParent1 is instance of ChildDogTwo" : "dogParent1 isn't instance of ChildDogTwo");
        out.println();

        dogParent1 = childDogOne; // A reference to c
        out.println("dogParent1 now refers to childDogOne");
        out.println(dogParent1 instanceof ChildDogOne ? "dogParent1 is instance of ChildDogOne" : "dogParent1 isn't instance of ChildDogOne");
        out.println(dogParent1 instanceof DogParent ? "dogParent1 is instance of DogParent" : "dogParent1 isn't instance of DogParent");

        // all objects can be cast to Object
        if (dogParent instanceof Object) out.println("dogParent may be cast to Object");

        if (catParent instanceof Object) out.println("b may be cast to Object");

        if (childDogOne instanceof Object) out.println("c may be cast to Object");

        if (childDogTwo instanceof Object) out.println("d may be cast to Object");

        /*НА ЗАМЕТКУ! Если в приведенном ниже выражении переменная х содержит пустое значение
        null, исключение не будет сгенерировано, но лишь возвратится логическое значение false.*/
        out.println();
        out.println(null instanceof DogParent);
    }
}

class DogParent {
    private String name;
    private int age;
}

class CatParent {
    private String name;
    private int age;
}

class ChildDogOne extends DogParent {
    private int weight;
}

class ChildDogTwo extends DogParent {
    private int weight;
}