package oop.example_protected.p2;

import oop.example_protected.p1.Parent;

//in file B.java
public class Child extends Parent {
    public static void main(String[] args) {
        Parent a = new Child();
        Child b = new Child();
        b.process(a);
        System.out.println(a.getI());
    }

    public void process(Parent parent) {
//        parent.i = parent.i*2;
    }
}


/*
*
    Будет выведено «20»
    Будет выведено «10»
    Код не скомпилирутся
    Возникнет ошибка времени выполнения
    Все ответы неверны
*/
