package Examples.Serialization;

import java.io.*;

class Cat01 implements Serializable {

    private String name;
    private String color;
    private int age;
    private Cat01.Car01 car01;

    public Cat01(String name, String color, int age, Cat01.Car01 car01) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.car01 = car01;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat01.Car01 getCar01() {
        return this.car01;
    }

    public void setCar01(Cat01.Car01 car01) {
        this.car01 = car01;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", value='" + color + '\'' +
                ", age=" + age +
                ", car=" + car01 +
                '}';
    }

    // Etot klass toze dolzen implementet interfeis serializable, inache brosaet exception NotSerializableException
    static class Car01 implements Serializable {
        public String color;

        Car01(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "{" +
                    "value car='" + color + '\'' +
                    '}';
        }
    }

}

public class ExampleSerializationZ01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cat01 vaska = new Cat01("Vaska", "Gray", 4, new Cat01.Car01("Green"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);

        //сохраняем состояние кота Васьки в поток и закрываем его(поток)
        ous.writeObject(vaska);
        byte[] cremirovanuiVaska = baos.toByteArray();
        ous.close();
        baos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(cremirovanuiVaska);
        ObjectInputStream ois = new ObjectInputStream(bais);

        //создаём кота для опытов и инициализируем его состояние Васькиным
        Cat01 cloneVaska = (Cat01) ois.readObject();

        System.out.println("Vaska =       " + vaska);
        System.out.println("Clone Vaska = " + cloneVaska);

        System.out.println("*********************************************");
        cloneVaska.setColor("Black");
        cloneVaska.setCar01(new Cat01.Car01("Black"));
        //Убеждаемся что у кота Васьки теперь есть клон, над которым можно ставить опыты без ущерба Василию
        System.out.println("Vaska =       " + vaska);
        System.out.println("Clone Vaska = " + cloneVaska);

        System.out.println("*********************************************");
        vaska.setColor("White");
        vaska.setCar01(new Cat01.Car01("White"));
        //Убеждаемся что у кота Васьки теперь есть клон, над которым можно ставить опыты без ущерба Василию
        System.out.println("Vaska =       " + vaska);
        System.out.println("Clone Vaska = " + cloneVaska);
    }
}

/*
    Для клонирования объекта в Java можно пользоваться тремя способами:
        1)Переопределение метода clone() и реализация интерфейса Cloneable();
        2)Использование конструктора копирования;
        3)Использовать для клонирования механизм сериализации

    Наиболее удобным и гибким способом клонирования является механизм сериализации. Он заключается в
    сохранении объекта в поток байтов с последующей эксгумацией его от туда. Для примера пригласим кота Ваську,
    его ждёт пара опытов.

    Ни один кот не пострадал в результате тестов, мы видим что Васька был сохранён в поток, из которого затем
    восстановили независимый клон. Если нет особой необходимости обработки полей во время клонирования объектов,
    то сериализация является наиболее предпочтительным вариантом для этих целей.
*/
