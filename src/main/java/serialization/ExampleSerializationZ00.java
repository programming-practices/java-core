package Examples.Serialization;

import java.io.*;

class Cat00 implements Serializable {

    private String name;
    private String color;
    private int age;

    public Cat00(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", value='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ExampleSerializationZ00 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cat00 vaska = new Cat00("Vaska", "Gray", 4);

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
        Cat00 cloneVaska = (Cat00) ois.readObject();

        System.out.println(vaska);
        System.out.println(cloneVaska);

        System.out.println("*********************************************");
        cloneVaska.setColor("Black");
        //Убеждаемся что у кота Васьки теперь есть клон, над которым можно ставить опыты без ущерба Василию
        System.out.println(vaska);
        System.out.println(cloneVaska);

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
