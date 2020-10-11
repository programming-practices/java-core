package object.hashCode;

// Sources: https://www.youtube.com/watch?v=QyZ-abP70Os&list=PLoij6udfBnchbO1M1L1q4VAumns55YIyk&index=4
//          start: 20:00 end: ...

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectHashCode {

    static int counter_for_invoked_methodEequal = 0;

    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        List<String> listStrings = new ArrayList<>();
        listStrings.add("A");
        listStrings.add("B");
        listStrings.add("C");

        String[] array1 = new String[3];
        array1[0] = "A";
        array1[0] = "B";
        array1[0] = "C";

        String[] array2 = new String[3];
        array2[0] = "D";
        array2[0] = "E";
        array2[0] = "F";

        String[] array3 = new String[3];
        array3[0] = "S";
        array3[0] = "Q";
        array3[0] = "Z";

        List<String[]> listArrays = new ArrayList<>();
        listArrays.add(array1);
        listArrays.add(array2);
        listArrays.add(array3);

        Map<List<String>, List<String[]>> map = new HashMap<>();
        map.put(listStrings, listArrays);
        System.out.println(map);
        System.out.println(map.hashCode());


//--------------------------------------------------------------------------------------------------------------------
        /*
        Пояснение: Если при добавлении пары ключ-значение в Map оказывается, что там уже содержится такой ключ, ему в
        соответствие ставится новое значение. В классе Employee_ForUseHashCode метод equals() реализован таким образом, что равными
        считаются два объекта, содержащие одну и ту же ссылку на строку name (this.name == emp.name). Поэтому из двух
        объектов-ключей, содержащих ссылку на строку-константу "Chandler", в Map'е остаётся только один. Поле counter_for_invoked_methodEequal
        используется для подсчёта количества вызовов метода Employee_ForUseHashCode.equals(). При работе с HashMap метод equals()
        вызывается относительно редко, например, когда хэш-код вновь добавляемого ключа совпадает с хэш-кодом ранее
        добавленного ключа - чтобы достоверно убедиться, что это одинаковые объекты (равенство хэш-кодов ещё не
        гарантирует равенство объектов). В данном примере такое происходит ровно один раз, при повторном добавлении
        Chandler'а.
        */
        Map employees = new HashMap();
        employees.put(new Employee("Joe"), new Integer("1"));
        employees.put(new Employee("Chandler"), new Integer("2"));
        employees.put(new Employee("Chandler"), new Integer("3"));
        employees.put(new Employee("Ross"), new Integer("4"));

//        for (Object o : employees.keySet()) {
//            Employee tmp = (Employee) o;
//            System.out.println("key: " + tmp + " value: " + employees.get(tmp));
//        }
//        System.out.println(counter_for_invoked_methodEequal);

//----------------------------------------------------------------------------------------------------------------------
        // Vsi hashCode() raznue
//        Object o = new Object();
//        Object o2 = new Object();
//        Object o3 = new Object();
//        Object o4 = new Object();
//        System.out.println(o.hashCode());
//        System.out.println(o2.hashCode());
//        System.out.println(o3.hashCode());
//        System.out.println(o4.hashCode());

//--------------------------------------------------------------------------------------------------------------------
//        ClassB exampleObjectHashCode = new ClassB("Elena", 25);
//        Object object = new Object();
//
//        System.out.println(exampleObjectHashCode.hashCode());
//        System.out.println(object.hashCode());


//        Object object = new Object();
//
//        Object object1 = object;
//        int hCode1;
//        hCode1 = object1.hashCode();
//        System.out.println(hCode1);
//        System.out.println(object.equals(object1));
//        System.out.println(object == object1);
//--------------------------------------------------------------------------------------------------------------------
        /*Дело в том, что в классе StringBuilder метод hashCode() не определен, и поэтому из класса Object вызывается
          исходный метод hashCode(), где хеш-код определяется по адресу памяти, занимаемой объектом.*/
        String s = "Ok";
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder("Ok");
//        System.out.println(s.hashCode() + " " + sb.hashCode() + " " + sb2.hashCode());

        String t = new String("Ok");
        StringBuilder tb = new StringBuilder(t);
        StringBuilder tb2 = new StringBuilder("Ok");
//        System.out.println(t.hashCode() + " " + tb.hashCode() + " " + tb2.hashCode());
//--------------------------------------------------------------------------------------------------------------------


    }

}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object obj) {
        ObjectHashCode.counter_for_invoked_methodEequal++;

        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        Employee emp = (Employee) obj;
        if (this.name == emp.name) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return name.hashCode();
    }
}

class ClassB {
    private String name;
    private int age;

    public ClassB(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ClassT{" + "name='" + name + '\'' + ", age=" + age + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        ClassB that = (ClassB) obj;
        return this.name == that.name && this.age == that.age;
    }

    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 31 * result + this.age;
        return result;
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Хеш-код — это целое число, генерируемое на основе конкретного объекта. Хеш-код можно рассматривать как некоторый
шифр: если х и у — разные объекты, то с боль­шой степенью вероятности должны различаться результаты вызовов
х.hashCode() и у.hashCode().
----------------------------------------------------------------------------------------------------------------------
Метод hashCode() должен возвращать целочисленное значение, которое может быть отрицательным.
----------------------------------------------------------------------------------------------------------------------
Во-первых, можно воспользоваться методом Objects.hashCode(), безопасно обрабатывающим пустые значения. В частности,
он воз­вращает нуль, если его аргумент имеет пустое значение null, а иначе — результат вызова метода hashCode() для
заданного аргумента.
----------------------------------------------------------------------------------------------------------------------
СОВЕТ. Если имеются поля типа массива, для вычисления хеш-кода, состоящего из хеш-кодов эле­ментов массива, можно
воспользоваться методом Arrays.hashCode().
----------------------------------------------------------------------------------------------------------------------
И во-вторых, можно вызвать метод Objects.hashO, если требуется объединить несколько хеш-значений, что еще лучше. В
этом случае метод Objects.hashCode() будет вызван для каждого аргумента с целью объединить получаемые в итоге
хеш-значения. В таком случае метод EmployeeRAF.hashCode() реализуется очень просто:
            public int hashCode(){
                return Objects.hash(name, salary, hireDay);
            }
----------------------------------------------------------------------------------------------------------------------
Методы equals () и hashCode () должны быть совместимы: если в результате вы­зова х.equals(у) возвращается логическое
значение true, то и результаты вызовов х.hashCode() и у.hashCode() также должны совпадать. Так, если в методе
EmployeeRAF.equals() сравниваются идентификационные номера работников, то при вычислении хеш-кода методу hashCode()
также потребуются идентификационные номера, но не имя работника и не адрес памяти, занимаемой соответствующим объектом.
----------------------------------------------------------------------------------------------------------------------
Если переопределяется метод equals(), то следует переопределить и метод hashCode() для объектов, которые пользователи
могут вставлять в хеш-таблицу.
----------------------------------------------------------------------------------------------------------------------
•int hashCode() 1.0
    Возвращает хеш-код объекта. Хеш-код представляет собой положительное или отрицательное це­
    лое число. Для равнозначных объектов должны возвращаться одинаковые хеш-коды.

•static int hash(Object... объекты) 7.0
    Возвращает хеш-код, состоящий из хеш-кодов всех предоставляемых объектов.

•static int hashCode(Object a) 7.0
    Возвращает нуль, если параметр а имеет пустое значение null, а иначе — делает вызов a.hash­Code().

•static int hashCode ((int |long |short |byte |double |float |char |boolean) value) 8.0
    Возвращает хеш-код заданного значения.

•static int hashCode(type[] a) 5.0
    Вычисляет хеш-код массива а, который может содержать элементы типа Object, int, long,
    short, char, byte, boolean, float или double.
----------------------------------------------------------------------------------------------------------------------
•int hashCodeO
Возвращает хеш-код данного объекта. Хеш -код может быть любым целым значением (положитель­
ным или отрицательным). Определения методов equals() и hashCodeO должны быть согласо­
ваны: если в результате вызова х . equals (у) возвращается логическое значение true, то в ре­
зультате вызова х.h a s h C o d e O должно возвращаться то ж е самое значение, что и в результате
вызова у.hashCodeO.
----------------------------------------------------------------------------------------------------------------------
*/
