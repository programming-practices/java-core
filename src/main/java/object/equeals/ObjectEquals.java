package object.equeals;


import java.time.LocalDate;
import java.util.Objects;

// Sources: https://www.youtube.com/watch?v=NYHJWnMb1TI&list=PLoij6udfBnchbO1M1L1q4VAumns55YIyk&index=2
//          start: 8:00 end: ...

public class ObjectEquals {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        /*Специ­фикация Java требует, чтобы метод equals() обладал следующими характеристиками:

        1. Рефлексивность. При вызове х.equals(х) по любой ненулевой ссылке х долж­но возвращаться
        логическое значение true.

        2. Симметричность. При вызове х.equals(у) по любым ссылкам х и у должно возвращаться логическое значение
        true тогда и только тогда, когда при вызове у.equals(х) возвращается логическое значение true.

        3. Транзитивность. Если при вызовах х.equals(у) и у.equals(z) по любым ссылкам х, у и z возвращается
        логическое значение true, то и при вызове х.equals(z) возвращается логическое значение true .

        4. Согласованность. Если объекты, на которые делаются ссылки х и у, не изменя­ются, то при повторном вызове
        х.equals(у) должно возвращаться то же са­мое значение.

        При вызове х.equals(null) по любой непустой ссылке х должно возвращать­ся логическое значение false.*/

        Book childBook = new ChildBook("title", "bla");
        Book book = new Book("title");
        Book childBook1 = new ChildBook("title", "author");

        //reflexive
        System.out.println("reflexive");
        System.out.println(childBook.equals(childBook));
        System.out.println("");

        //symmetric
        System.out.println("symmetric");
        System.out.println(childBook.equals(book));
        System.out.println(book.equals(childBook));
        System.out.println("");

        //transitive
        System.out.println("transitive");
        System.out.println(childBook.equals(book));
        System.out.println(book.equals(childBook1));
        System.out.println(childBook1.equals(childBook));
        System.out.println("");

        //consistent
        System.out.println("consistent");
        System.out.println(childBook.equals(book));
        System.out.println(childBook.equals(book));
        System.out.println("");

        //non-null
        System.out.println("non-null");
        System.out.println(childBook.equals(null));

//--------------------------------------------------------------------------------------------------------------------
//        Collection<Integer> collection_00 = new ArrayList<>(Arrays.asList(1,1,2,3,3,4,5,6,7,8,8,9,10,10,3));
//        Collection<Integer> collection_01 = new ArrayList<>(Arrays.asList(1,1,2,3,3,4,5,6,7,8,8,9,10,10,3));
//        System.out.println(collection_00.equals(collection_01));
//        System.out.println(collection_00 == collection_01);
//        System.out.println();
//
//        Collection<Integer> collection_03 = new ArrayList<>(Arrays.asList(1,1,2,3,3,4,5,6,7,8,8,9,10,10,3));
//        Collection<Integer> collection_04 = collection_03;
//        System.out.println(collection_03.equals(collection_04));
//        System.out.println(collection_03 == collection_04);
//--------------------------------------------------------------------------------------------------------------------
//        EmployeeW alice1 = new EmployeeW("Alice Adams", 75000, 1987, 12, 15);
//        EmployeeW alice2 = alice1;
//        EmployeeW alice3 = new EmployeeW("Alice Adams", 75000, 1987, 12, 15);
//        EmployeeW bob = new EmployeeW("Bob Brandson", 50000, 1989, 10, 1);
//
//        System.out.println("alice1 == alice2: " + (alice1 == alice2));
//
//        System.out.println("alice1 == alice3: " + (alice1 == alice3));
//
//        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
//
//        System.out.println("alice1.equals(bob): " + alice1.equals(bob));
//
//        System.out.println("bob.toString(): " + bob);
//
//        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
//        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
//        boss.setBonus(5000);
//        System.out.println("boss.toString(): " + boss);
//        System.out.println("carl.equals(boss): " + carl.equals(boss));
//        System.out.println("alice1.hashCode(): " + alice1.hashCode());
//        System.out.println("alice3.hashCode(): " + alice3.hashCode());
//        System.out.println("bob.hashCode(): " + bob.hashCode());
//        System.out.println("carl.hashCode(): " + carl.hashCode());
//--------------------------------------------------------------------------------------------------------------------
//        Object o = new EmployeeW("Name", 43.44, 1968, 3, 12);
//        EmployeeW e = new EmployeeW("Name", 43.44, 1968, 3, 12);
//        System.out.println(o.getClass());
//        System.out.println(e.getClass());
//        System.out.println(EmployeeW.class);

//        System.out.println(o.equals(e));
//        System.out.println(o.equals(EmployeeW.class));
//        System.out.println(e.equals(EmployeeW.class));
//        System.out.println(EmployeeW.class.equals(EmployeeW.class));
//        System.out.println(EmployeeW.class.equals(e));
//
//        EmployeeW e3 = (EmployeeW) EmployeeW.class;  // ERROR
//        Class<EmployeeW> eeee = EmployeeW.class;
//--------------------------------------------------------------------------------------------------------------------
    }
}

class EmployeeW {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public EmployeeW(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Object otherObject) {
        // a quick test to see if the objects are identical
        if (this == otherObject) return true;

        // must return false if the explicit parameter is null
        if (otherObject == null) return false;

        // if the classes don't match, they can't be equal
        if (getClass() != otherObject.getClass()) return false;

        // now we know otherObject is a non-null EmployeeRAF
        EmployeeW other = (EmployeeW) otherObject;

        // test whether the fields have identical values
        return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }

    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
                + "]";
    }
}

class Manager extends EmployeeW {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;
        // super.equals checked that this and other belong to the same class
        return bonus == other.bonus;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), bonus);
    }

    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}

class ClassA {
    int varA;
    int varB;

    ClassA(int varA, int varB) {
        this.varA = varA;
        this.varB = varB;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        ClassA exampleEquals = (ClassA) o;

        if (this.varA != exampleEquals.varA) return false;
        return this.varB == exampleEquals.varB;
    }

    @Override
    public int hashCode() {
        int result = this.varA;
        result = 31 * result + this.varB;
        return result;
    }
}

class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }
////----------------------Object default--------------------------------------------
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || this.getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return Objects.equals(this.title, book.title);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(this.title);
//    }
////--------------------------------------------------------------------------------

    //consistent
//    @Override
//    public boolean equals(Object obj) {
//        return Math.random() < 0.5;
//    }

    //transitive
    @Override
    public boolean equals(Object obj) {
        return obj != null && title.equals(((Book) obj).title);
    }

    //reflexive & symmetric
//    @Override
//    public boolean equals(Object obj) {
//        return title.equals(obj);
//    }

//    @Override
//    public boolean equals(Object obj) {
//        return obj != null && title.equals(((Book)obj).title);
//    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Book book = (Book) o;
//
//        return this.title.equals(book.title);
//    }
}

class ChildBook extends Book {
    private String author;

    public ChildBook(String title, String author) {
        super(title);
        this.author = author;
    }

////----------------------Object default-----------------------------------
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || this.getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        ChildBook childBook = (ChildBook) o;
//        return Objects.equals(this.author, childBook.author);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(super.hashCode(), this.author);
//    }
////--------------------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChildBook) {
            return obj != null && title.equals(((ChildBook) obj).title) && author.equals(((ChildBook) obj).author);
        } else {
            return super.equals(obj);
        }
    }
}


/*
----------------------------------------------------------------------------------------------------------------------
Ниже приведены рекомендации для создания приближающегося к идеалу метода equals().

    1. Присвойте явному параметру имя otherObject. Впоследствии его тип нужно будет привести к типу другой переменной
       под названием other.

    2. Проверьте, одинаковы ли ссылки this и otheObject, следующим образом:
                    if (this == otherObject) return true;
       Это выражение составлено лишь в целях оптимизации проверки. Ведь намного
       быстрее проверить одинаковость ссылок, чем сравнивать поля объектов.

    3. Выясните, является ли ссылка otherObject пустой (null), как показано ниже. Если она оказывается пустой,
       следует возвратить логическое значение false. Эту проверку нужно сделать обязательно.
                    if (otherObject == null) return false;

    4. Сравните классы this и otheObject. Если семантика проверки может изме­
       ниться в подклассе, воспользуйтесь методом getClass () следующим образом:
                    if (getClass() != otherObject.getClass()) return false;
       Если одна и та же семантика остается справедливой для всех подклассов, про­
       изведите проверку с помощью операции instanceof следующим образом:
                    if (! (otherObject instanceof ИмяКласса)) return false;

    5. Приведите тип объекта o th e r O b je c t к типу переменной требуемого класса:
                    ИмяКласса other = {ИмяКласса) otherObject;

    6. Сравните все поля, как показано ниже. Для полей примитивных типов слу­жит операция = , а для объектных
       полей — метод Objects.equals(). Если все поля двух объектов совпадают, возвращается логическое значение true,
       а ина­че — логическое значение false,
                    return поле1 == other.поле!
                    && поле2.equals(other.поле2)
                    &&...
       Если вы переопределяете в подклассе метод equals(), в него следует включить
       вызов super.equals (other).
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! В документации на интерфейс Comparable предполагается, что метод
compareToO должен быть совместим с методом equals(). Это означает, что результат сравне­
ния х .compareTo (у) должен быть равен нулю, если к такому же результату приводит сравнение
х.equals (у). Этому правилу следует большинство классов из прикладного программного интер­
фейса Java API, где реализуется интерфейс Comparable.
----------------------------------------------------------------------------------------------------------------------
Методы equals() и hashCode() должны быть совместимы: если в результате вы­зова х.equals(у) возвращается логическое
значение true, то и результаты вызовов х.hashCode() и у.hashCode() также должны совпадать. Так, если в методе
EmployeeRAF.equals() сравниваются идентификационные номера работников, то при вычислении хеш-кода методу hashCode()
также потребуются идентификационные номера, но не имя работника и не адрес памяти, занимаемой соответствующим объектом.
----------------------------------------------------------------------------------------------------------------------
НАЗАМЕТКУ! В языке Java имеется следующее стандартное требование: "Автор реализации метода
должен гарантировать, что для всех объектов х и у выполняется условие sgn (х. compareTo (у))
= -sgn (у. compareTo (х)). (Это означает, что если при вызове у. compareTo (х) генерируется
исключение, то же самое должно происходить и при вызове х.compareTo (у).)” Здесь sgn озна­
чает знак числа: sgn(n) равно - 1 , если п — отрицательное число; 0, если п = 0; или 1, если
п — положительное число. Иными словами, если поменять местами явный и неявный параметры
метода compareTo (), знак возвращаемого числового значения (но не обязательно его фактиче­
ская величина) также должен измениться на противоположный.
Что касается метода equals О, то при наследовании могут возникнуть определенные затрудне­
ния. В частности, класс Manager расширяет класс EmployeeRAF, а следовательно, он реализует ин­
терфейс Comparable<EmployeeRAF>, а не интерфейс Comparable<Manager>, как показано ниже.
                class Manager extends EmployeeRAF{
                    public int compareTo(EmployeeRAF other){
                        Manager otherManager = (Manager) other; // Так нельзя!
                        ...
                    }
                    ...
                }
Но в этом случае нарушается правило "антисимметрии". Если объект х относится к классу
EmployeeRAF, а объект у — к классу Manager, то вызов х .compareTo (у) не приведет к исклю­
чению, поскольку х и у будут сравнены как объекты класса EmployeeRAF. А при противоположном
вызове у.compareTo (х) будет сгенерировано исключение типа ClassCastException. Анало­
гичная ситуация возникает при реализации метода equals ( ) , которая обсуждалась в главе 5. Из
этого за труднительного положения имеются два выхода.
Если у подклассов разные представления о сравнении, нужно запретить сравнение объектов,
принадлежащих разным классам. Таким образом, каждый метод compareTo () должен начи­
наться со следующей проверки:
                if (getClass() != other.getClass()) throw new ClassCastException();
Если ж е существует общий алгоритм сравнения объектов подклассов, то в суперклассе следует
реализовать единый метод compareToO и объявить его как final.
Допустим, в организации руководящие работники считаются выше рядовых по рангу, независимо
от зарплаты. Как в таком случае быть с другими подклассами, например Executive и Secretary?
Если требуется учредить нечто вроде табеля о рангах, то в класс EmployeeRAF следует ввести метод
rank ( ) . Тогда в каждом подклассе метод rank() должен переопределяться, а результаты его ра­
боты учитываться при выполнении метода compareToO.
----------------------------------------------------------------------------------------------------------------------
Если переопределяется метод equals(), то следует переопределить и метод hashCode() для объектов, которые пользователи
могут вставлять в хеш-таблицу.
----------------------------------------------------------------------------------------------------------------------
СОВЕТ. Если имеются поля типа массива, для проверки на равенство соответствующих элементов
массива можно воспользоваться статическим методом Arrays.equals().
----------------------------------------------------------------------------------------------------------------------
ВНИМАНИЕ! Реализуя метод equals(), многие программисты допускают типичную ошибку. Смо­
жете ли вы сами выяснить, какая ошибка возникнет при выполнении следующего фрагмента кода?
public class EmployeeRAF{
    public boolean equals(EmployeeRAF other){
        return other != null
                && getClassO == other.getClass()
                && Objects.equals(name, other.name)
                && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }
    ...
}
В этом методе тип явного параметра определяется как EmployeeRAF. В итоге переопределяется
не метод equals() из класса Object, а совершенно посторонний метод. Чтобы застраховаться
от подобной ошибки, следует специально пометить аннотацией gOverride метод, который пе­
реопределяет соответствующий метод из суперкласса, к ак показано ниже.
            @Override public boolean equals(Object other)
Если при этом будет случайно определен новый метод, компилятор возвратит сообщение
об ошибке. Допустим, в классе EmployeeRAF имеется такая строка кода:
            @Override public boolean equals(EmployeeRAF other)
Этот метод не переопределяет ни один из методов суперкласса Object, поэтому будет обнаружена
ошибка.
----------------------------------------------------------------------------------------------------------------------
НИМАНИЕ! Зачастую анонимный подкласс удобно сделать почти, но не совсем таким же, как и его суперкласс. Но в этом случае
следует соблюдать особую осторожность в отношении метода equals(). Как рекомендовалось в главе 5, в методе equals()
необходимо организовать следующую проверку:
            if (getClass() != other.getClass()) return false;
Но анонимный подкласс ее не пройдет.
----------------------------------------------------------------------------------------------------------------------
•static boolean equals (type[] a, type[] b) 5.0
    Возвращает логическое значение true, если сравниваемые массивы имеют одинаковую длину
    и одинаковые элементы на соответствующих позициях. Сравниваемые массивы могут содержать
    элементы типа Object, int, long, short, char, byte, boolean, float или double.

•static boolean equals(Object a, Object b)
    Возвращает логическое значение true, если оба параметра, а и b, имеют пустое значение null;
    логическое значение false, если один из них имеет пустое значение null; а иначе — результат
    вызова a.equals (b).
----------------------------------------------------------------------------------------------------------------------
•boolean equals (Object otherObject)
    Сравнивает два объекта и возвращает логическое значение true, если объекты занимают одну
    и ту же область памяти, а иначе — логическое значение false. Этот метод следует переопреде­
    лить при создании собственных классов.
----------------------------------------------------------------------------------------------------------------------
*/