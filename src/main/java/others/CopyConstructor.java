package others;

import static others.PrintUtils.lineSeparator;

import java.util.Objects;

public class CopyConstructor {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        PersonA original = new PersonA(18, "Grishka", new PersonA.SIC("Green"), new Car("Tesla"));
        PersonA clone = new PersonA(original);

        lineSeparator(1);
        System.out.println("Original = " + original);
        System.out.println("original.hashCode() = " + original.hashCode());
        System.out.println("Clone =    " + clone);
        System.out.println("clone.hashCode() = " + clone.hashCode());

        lineSeparator("original.setAge()  original.setName()  original.setSic()  original.setCar()");
        original.setAge(22);
        original.setName("Olya");
        // Attention here, if pas in parameter new Object
        // Attention here, if pas in parameter not new Object
        original.setSic(new PersonA.SIC("Black"));
        original.setCar(new Car("Tesla Model 3"));
        System.out.println("\nOriginal = " + original);
        System.out.println("Clone =    " + clone);
        System.out.println("original.hashCode() = " + original.hashCode());
        System.out.println("clone.hashCode() = " + clone.hashCode());

        lineSeparator("clone.setAge()  clone.setName  clone.setSic()  clone.setCar()");
        clone.setAge(52);
        clone.setName("Ostap");
        // Attention here, if pas in parameter new Object
        // Attention here, if pas in parameter not new Object
        clone.setSic(new PersonA.SIC("White"));
        clone.setCar(new Car("Tesla Semi"));
        System.out.println("\nOriginal = " + original);
        System.out.println("Clone =    " + clone);
        System.out.println("original.hashCode() = " + original.hashCode());
        System.out.println("clone.hashCode() = " + clone.hashCode());

//--------------------------------------------------------------------------------------------------------------------

    }
}

class PersonA {

    private int age;
    private String name;
    private SIC sic;
    private Car car;

    public PersonA(int age, String name, SIC sic, Car car) {
        this.age = age;
        this.name = name;
        this.sic = sic;
        this.car = car;
    }

    // конструктор копии
    public PersonA(PersonA other) {
        this(other.getAge(), other.getName(), other.sic, other.car);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SIC getSic() {
        return this.sic;
    }

    public void setSic(SIC sic) {
        this.sic = sic;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonA personA = (PersonA) o;
        return age == personA.age &&
                name.equals(personA.name) &&
                sic.equals(personA.sic) &&
                car.equals(personA.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, sic, car);
    }

    @Override
    public String toString() {
        return "PersonA{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sic=" + sic +
                ", car=" + car +
                '}';
    }

    // static inner class
    static class SIC {
        public String value;

        public SIC(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    "value car='" + value + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SIC sic = (SIC) o;
            return value.equals(sic.value);
        }

        @Override
        public int hashCode() {
            int result = this.value != null ? 31 * this.value.hashCode() : 0;
            return result;
        }
    }
}

class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }
}



/*
    Для клонирования объекта в Java можно пользоваться тремя способами:
        1)Переопределение метода clone() и реализация интерфейса Cloneable();
        2)Использование конструктора копирования;
        3)Использовать для клонирования механизм сериализации

    Следующий способ заключается в использовании конструктора копирования.

    В классе описывается конструктор, который принимает объект этого же класса и инициализирует значениями его
    полей поля нового объекта. О реализации инициализации полей полностью должен позаботиться разработчик класса.

    Но это вышеуказанный способ полн потенциальных ошибок и по сути создаиот копию объекта.
*/
