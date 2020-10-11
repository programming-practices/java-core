package java_lang;

import java.util.Date;
import java.util.GregorianCalendar;

public interface ExampleCloneable {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        //-------------Polnoe-Kopirovanie---------------
        try {
            EmployeeZ original = new EmployeeZ("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);

            EmployeeZ copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=  " + original);
            System.out.println("copy    =  " + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println();

        //----------Ne-Polnoe-Kopirovanie--------------
        try {
            EmployeeXX originalXX = new EmployeeXX("John Q. Public", 50000);
            originalXX.setHireDay(2000, 1, 1);

            EmployeeXX copyXX = (EmployeeXX) originalXX.clone();
            copyXX.raiseSalary(10);
            copyXX.setHireDay(2002, 12, 31);
            System.out.println("originalXX=" + originalXX);
            System.out.println("copyXX    =" + copyXX);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
//---------------------------------------------------------------------------------------------------------------------
    }
}

/**
 * This program demonstrates cloning.
 *
 * @author Cay Horstmann
 * @version 1.10 2002-07-01
 */
class EmployeeZ implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public EmployeeZ(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    /*Метод clone() из класса Object может генерировать исключение типа CloneNotSupportedException. Это происходит в
    том случае, если метод clone() вы­ зывается для объекта, не реализующего интерфейс Cloneable.*/
    @Override
    public EmployeeZ clone() throws CloneNotSupportedException {
        // call Object.clone()
        EmployeeZ cloned = (EmployeeZ) super.clone();

        // clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * Set the hire day to a given date.
     *
     * @param year  the year of the hire day
     * @param month the month of the hire day
     * @param day   the day of the hire day
     */
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        // Example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "EmployeeRAF[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}

/*Метод clone() из класса Object может генерировать исключение типа CloneNotSupportedException. Это происходит в
    том случае, если метод clone() вы­ зывается для объекта, не реализующего интерфейс Cloneable.*/
class EmployeeXX implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public EmployeeXX(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        // Example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "EmployeeRAF[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
интерфейс Cloneable , который обозначает, что в классе предоставляется надежный метод clone()
----------------------------------------------------------------------------------------------------------------------
Для каждого класса нужно принять следующие решения.
    1. Достаточно ли метода clone(), предоставляемого по умолчанию?
    2. Можно ли доработать предоставляемый по умолчанию метод clone() таким образом, чтобы вызывать его для изменяемых
       объектов?
    3. Следует ли вообще отказаться от применения метода clone()?

По умолчанию принимается последнее решение. А для принятия первого и вто­рого решения класс должен удовлетворять
следующим требованиям.
    1. Реализация интерфейса Cloneable.
    2. Переопределение метода clone() с модификатором доступа public.
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Метод clone ( ) объявлен в классе Object как защищенный (protected], поэ­
тому его нельзя просто вызвать по ссылке anObject.clone ( ) . Но разве недоступны защ ищ ен­
ные методы для любого подкласса, и не является ли каждый класс подклассом класса Object?
К счастью, правила защищенного доступа не такие строгие (см. главу 5). Подкласс может вызвать
защищенный метод clone ( ) только для клонирования своих с о б с т в е н н ы х объектов. Чтобы клони­
ровать другие объекты, метод clone ( ) следует переопределить как открытый и разрешить клони­
рование объектов любым другим методом.
----------------------------------------------------------------------------------------------------------------------
НАЗАМЕТКУ!Интерфейс Cloneable — один из немногих помеченных интерфейсов вJava, ино­
гда еще называемых маркерными интерфейсами. Напомним, что назначение обычных интерфей­
сов вроде Comparable — обеспечить реализацию в некотором классе конкретного метода или
ряда методов, объявленных в данном интерфейсе. У маркерных интерфейсов отсутствуют методы,
а их единственное назначение — разрешить выполнение операции instanceof для проверки
типа следующим образом:
if (obj instanceof Cloneable) ...
Но пользоваться маркерными интерфейсами в прикладных программах все ж е н е рекомендуется.
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Вплоть до версии Java SE 1.4 метод clone ( ) всегда возвращал объект типа
Object. Поддерживаемые теперь ковариантные возвращаемые типы (см. главу 5) позволяют ука­
зывать в методе clone ( ) правильный тип возвращаемого значения.
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Имеется также интерфейс Closeable, производный от интерфейса
AutoCloseable. В нем также имеется единственный метод close(), но он объявляется для ге­
нерирования исключения типа XOException.
----------------------------------------------------------------------------------------------------------------------
*/