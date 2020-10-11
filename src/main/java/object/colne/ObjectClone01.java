package object.colne;

public class ObjectClone01 {
    public static void main(String[] args) throws CloneNotSupportedException {

        Person01 person01Original = new Person01(new Car01("Green"), 25, "Mike");

        Person01 person01Clone = (Person01) person01Original.clone();

        System.out.println("Oreginal of Person = " + person01Original);
        System.out.println("Clone of Person =    " + person01Clone);

        person01Clone.name = new String("Ivan");
        person01Clone.car01.color = "red";

        System.out.println("\nOreginal of Person = " + person01Original);
        System.out.println("Clone of Person =    " + person01Clone);
    }

    static class Person01 implements Cloneable {
        String name;
        int age;
        Car01 car01;

        Person01(Car01 car01, int age, String name) {
            this.car01 = car01;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name + " {" +
                    "age=" + age +
                    ", car=" + car01 +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class Car01 {
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