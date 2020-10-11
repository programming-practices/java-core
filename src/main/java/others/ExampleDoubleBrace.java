package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Source http://www.softwaregeek.net/2012/12/double-brace-initialization-in-java.html
public class ExampleDoubleBrace {
    public static void main(String[] args) {
//------------------------------------------------------------------------------------------------------------------
        /*На первый взгляд, инициализация двойной скобки может выглядеть как магия, но на самом деле она очень проста.
        В нем задействованы две Java-конструкции: анонимный класс и инициализатор экземпляра . Внешняя пара фигурных
        скобок определяет анонимный класс, который расширяет HashSet <Long>, а внутренняя пара фигурных скобок определяет
        инициализатор экземпляра, который является общим подходом к инициализации экземпляров анонимного класса.*/
//        Set<Integer> set = new HashSet<Integer>(){{
//            add(1);
//            add(2);
//            add(3);
//            add(4);
//            add(5);
//            add(6);
//            add(7);
//            add(8);
//        }};
//        System.out.println(set);
//        set.remove(3);
//        System.out.println(set);
//--------------------------------------------------------------------------------------------------------------------
        /*В этой реализации класса Person метод equals () использует экземпляр operator и, следовательно, принимает
        подклассы для проверки равенства. Экземпляры класса Person, инициализированные с инициализацией двойной скобки,
        будут вести себя так, как ожидалось в этом случае. Следующая программа иллюстрирует это:*/
        Person1 person1A = new Person1() {{
            setAge(26);
            setFirstName("John");
            setLastName("Doe");
        }};
        Person1 person1B = new Person1() {{
            setAge(26);
            setFirstName("John");
            setLastName("Doe");
        }};
        System.out.println(person1A.equals(person1B));
        /*Эта программа печатает истину, как ожидалось. Другая популярная реализация метода equals () проверяет объекты
        класса на равенство вместо использования оператора instanceof, фактически запрещающего экземпляры подклассов,
        которые должны быть переданы для сравнения. Давайте рассмотрим эту альтернативную реализацию в контексте класса Person :*/
        Person2 person2A = new Person2() {{
            setAge(26);
            setFirstName("John");
            setLastName("Doe");
        }};
        Person2 person2B = new Person2() {{
            setAge(26);
            setFirstName("John");
            setLastName("Doe");
        }};
        System.out.println(person2A.equals(person2B));
        /*На этот раз вывод будет ложным . Как вы могли догадаться, объекты person1 и person2 не будут работать должным
        образом с любым классом, который полагается на equals () и hashCode () (например, HashSet , HashMap и т. Д.).
        Суть в том, что вы должны быть особенно осторожны при использовании объектов, созданных с инициализацией двойной
        скобки, с классами, которые полагаются на equals () и hashCode () . Наилучший подход в этом случае - воздерживаться
        от использования инициализации двойной скобки. Преимущества малы по сравнению с потенциальными головными болями. */
//--------------------------------------------------------------------------------------------------------------------
        /*Эта реализация вводит утечку памяти, потому что метод build () применяет двойную привязку для создания объекта
        EmployeeRAF , поэтому он использует анонимный класс, который ссылается на прилагаемый экземпляр builder . Типичное
        использование статического внутреннего класса builder подразумевает выброс его экземпляра сразу после создания
        продукта. Но в этом случае ссылка на прилагаемый экземпляр builder будет храниться анонимным подклассом EmployeeRAF,
        пока продукт будет сильно доступен. Это является следствием применения инициализации двойной привязки. Следующая
        программа иллюстрирует типичное использование компоновщика:*/
//        EmployeeDB employee = new EmployeeDB.Builder()
//                .address("49 Featherstone Street, London")
//                .firstName("John")
//                .lastName("Doe")
//                .build();

//        System.out.println(employee.getFirstName());
//        System.out.println(employee.getLastName());
//        System.out.println(employee.getAddress());
        /*Эта программа будет работать так, как ожидалось, но без дополнительной причины возьмет дополнительную память
        под капотом.*/
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*1. Каждый раз, когда вы используете инициализацию двойной скобки, вы создаете новый класс . Это означает, что у вас будет
один дополнительный файл .class для каждого идиоматического приложения. Вот пример, чтобы сделать это более конкретным:*/
class DoubleBraceInitializationExample {
    public static void main(String[] args) {
        final Set<Integer> set1 = new HashSet<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        final Set<Integer> set2 = new HashSet<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        final List<Integer> list1 = new ArrayList<Integer>() {{
            add(4);
            add(5);
            add(6);
        }};

        final List<Integer> list2 = new ArrayList<Integer>() {{
            add(4);
            add(5);
            add(6);
        }};

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(list1);
        System.out.println(list2);
    }
}
/*Эта программа содержит четыре приложения инициализации двойной скобки. После компиляции этого примера вы получите 5
классов, представленных следующими .class-файлами:
        DoubleBraceInitializationExample.class
        DoubleBraceInitializationExample $ 1.class
        DoubleBraceInitializationExample $ 2.class
        DoubleBraceInitializationExample $ 3.class
        DoubleBraceInitializationExample $ 4.class
Это не наносит большого вреда при тестировании кода, но чрезмерная инициализация двойной скобки в большом проекте,
предназначенная для выполнения на стороне сервера, может раздуть ваше приложение тысячами небольших классов и, как
следствие, увеличить время развертывания. */

/*2. Инициализация двойной привязки не может быть применена к конечным классам . Довольно очевидная точка, о которой
компилятор сразу сообщит вам. Поскольку этот метод использует наследование для создания экземпляров анонимного класса,
суперкласс должен позволять это делать, и, следовательно, он не может быть окончательным.*/

/*3. Следует принять дополнительные меры предосторожности, если объект, инициализированный с инициализацией двойной скобки,
будет сравниваться с другими объектами с использованием equals () . Если реализация метода equals () в суперклассе не
принимает экземпляры подклассов, тогда двойная инициализация скобок может вводить тонкие ошибки и несоответствия. Давайте
посмотрим на пример. Вот упрощенный класс Person :*/
class Person1 {
    private String firstName;
    private String lastName;
    private int age;

    // getters and setters are omitted
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person1) {
            Person1 other = (Person1) o;
            return firstName.equals(other.getFirstName()) &&
                    lastName.equals(other.getLastName()) &&
                    age == other.getAge();
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        return result;
    }
}

class Person2 {
    private String firstName;
    private String lastName;
    private int age;

    // getters and setters are omitted
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*В этой реализации метода класса Person equals () принимает экземпляры Person для сравнения, но экземпляры подклассов
    не допускаются. Инициализация двойной скобки не будет работать должным образом в этом случае. Для проверки можно
    использовать одну и ту же иллюстративную программу:*/
    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass().equals(Person2.class)) {
            Person2 other = (Person2) o;
            return firstName.equals(other.getFirstName()) &&
                    lastName.equals(other.getLastName()) &&
                    age == other.getAge();
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        return result;
    }
}

/*4. Инициализация двойной скобки может привести к неприятным утечкам памяти . Эта идиома использует анонимные классы, которые
никогда не статичны в соответствии с JLS. Следовательно, анонимный класс всегда ссылается на свой охватывающий объект.
Давайте посмотрим на пример. Предположим, вам нужно реализовать класс EmployeeRAF, и вы хотите создать экземпляры этого класса
с использованием шаблона проектирования builder для эмуляции именованных параметров. Одна из возможных реализаций может
выглядеть так:*/
class EmployeeDB {
    private String firstName;
    private String lastName;
    private String address;

    private EmployeeDB() {
    }

    public String getFirstName() {
        return firstName;
    }

    // public getters are omitted
    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String address;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

//        public Employee_ForUseHashCode build() {
//            return new Employee_ForUseHashCode() {{
//                setFirstName(firstName);
//                setLastName(lastName);
//                setAddress(address);
//            }};
//        }
    }
}