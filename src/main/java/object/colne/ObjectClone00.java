package object.colne;

public class ObjectClone00 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car00 car00 = new Car00("Green");
        Person00 person00Original = new Person00(car00, 25, "Mike");

        Person00 person00Clone = (Person00) person00Original.clone();

        System.out.println("Oreginal of Person = " + person00Original);
        System.out.println("Clone of Person =    " + person00Clone);

        person00Clone.name = new String("Ivan");
        person00Clone.car00.color = "red";

        System.out.println("\nOreginal of Person = " + person00Original);
        System.out.println("Clone of Person =    " + person00Clone);
    }

    static class Person00 implements Cloneable {
        String name;
        int age;
        Car00 car00;

        Person00(Car00 car00, int age, String name) {
            this.car00 = car00;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name + " {" +
                    "age=" + age +
                    ", car=" + car00 +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class Car00 {
        public String color;

        Car00(String color) {
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

/*
    Для клонирования объекта в Java можно пользоваться тремя способами:
        1)Переопределение метода clone() и реализация интерфейса Cloneable();
        2)Использование конструктора копирования;
        3)Использовать для клонирования механизм сериализации

        Etot способ подразумевает, что вы будете использовать механизм так называемого
        «поверхностного клонирования» и сами позаботитесь о клонировании полей-объектов. Метод clone() в
        родительском классе Object является protected, поэтому требуется переопределение его с объявлением
        как public. Он возвращает экземпляр объекта с копированными полями-примитивами и ссылками.
        И получается что у оригинала и его клона поля-ссылки указывают на одни и те же объекты. Etot premer
        nam pokauvaet, как одновременно меняется поле у оригинального объекта и клона.

        Из примера выше видно, что у клона и оригинала состояние одного из полей изменяется одновременно.

        Но eto вышеуказанныi способ полн потенциальных ошибок и по сути создаiot копию объекта.
*/