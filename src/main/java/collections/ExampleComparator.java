package collections;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;

public interface ExampleComparator {
}

class CompDemo {
    public static void main(String args[]) {
//---------------------------------------------------------------------------------------------------------------------
//        // Create age tree set.
////        TreeSet<String> ts = new TreeSet<String>(new MyComp());
////        TreeSet<String> ts = new TreeSet<String>(Comparator.reverseOrder());
//        TreeSet<String> ts = new TreeSet<String>((aStr, bStr) -> bStr.compareTo(aStr));
//
//        // Add elements to the tree set.
//        ts.add("C");
//        ts.add("A");
//        ts.add("B");
//        ts.add("E");
//        ts.add("F");
//        ts.add("D");
//
//        // Display the elements.
//        for(String element : ts) System.out.print(element + " ");
//        System.out.println();
//--------------------------------------------------------------------------------------------------------------------
//        // Create age tree map.
//        TreeMap<String, Double> treeMap = new TreeMap<String, Double>(new TComp());
//        // Put elements to the map.
//        treeMap.put("John Doe", 3434.34);
//        treeMap.put("Tom Smith", 123.22);
//        treeMap.put("Jane Baker", 1378.00);
//        treeMap.put("Tod Hall", 99.22);
//        treeMap.put("Ralph Smith", -19.08);
//        // Get age set of the entries.
//        Set<Map.Entry<String, Double>> set = treeMap.entrySet();
//
//        // Display the elements.
//        for(Map.Entry<String, Double> me : set) {
//            System.out.print(me.getKey() + ": ");
//            System.out.println(me.getValue());
//        }
//        System.out.println();
//
//        // Deposit 1000 into John Doe's account.
//        double balance =  treeMap.get("John Doe");
//        treeMap.put("John Doe", balance + 1000);
//
//        System.out.println("John Doe's new balance: " + treeMap.get("John Doe"));
//--------------------------------------------------------------------------------------------------------------------
        Person[] people = {new Person("Tom", "Bean"), new Person("Tom", "Kean"), new Person("Tom", "Aean"),
                new Person("Comn", "Hean"), new Person("Pommt", "Hean")};

        System.out.println(Arrays.toString(people));
        /*Статический метод comparing() принимает функцию извлечения ключей, приво­ дящую обобщенный тип Т к сравниваемому
        типу (например, String). Эта функция применяется к сравниваемым объектам, а сравнение производится по возвращаемымею
        ключам. Допустим, имеется массив объектов типа Person. Ниже показано, как отсортировать их по имени.*/
        Arrays.sort(people, comparing(Person::getFirstName));

        /*Компараторы можно связывать в цепочку с помощью метода thenComparing() для разрыва связей, как показано в
        приведенном ниже примере кода. Если у двух людей оказываются одинаковые фамилии, то применяется второй компаратор.*/
        Arrays.sort(people, comparing(Person::getFirstName).thenComparing(Person::getLastName));
        System.out.println(Arrays.toString(people));

        /*Имеется немало разновидностей этих методов. В частности, можно указать компаратор для сравнения по ключам,
        извлекаемым методами comparing() и thenComparing(). Например, в следующем фрагменте кода лю ди сортируются
        по длине их имен:*/
        Arrays.sort(people, comparing(Person::getFirstName,
                (s, t) -> Integer.compare(s.length(), t.length())));
        System.out.println(Arrays.toString(people));

        /*Кроме того, у методов comparing () и thenComparing () имеются варианты, ис­ключающие упаковку значений типа int,
        long или double. Так, приведенную выше операцию можно упростить следующим образом:*/
        Arrays.sort(people, Comparator.comparingInt(p -> p.getFirstName().length()));
        System.out.println(Arrays.toString(people));

        //----------------------------
        /*Если функция извлечения ключа может возвратить пустое значение null, то удоб­но воспользоваться статическими
        методами nullsFirst() и nullsLast(), принима­ющими имеющийся компаратор и модифицирующими его таким образом, чтобы он
        не генерировал исклю чение при появлении пустых значений null, но интерпретиро­вал их как более мелкие, чем обычные
        значения. Допустим, метод getMiddleName() возвращает пустое значение null без отчества. В таком случае можно
        сделать следу­ющий вызов:*/
        Arrays.sort(people, Comparator.comparing(Person::getFirstName,
                Comparator.nullsFirst(Comparator.naturalOrder())));

//        Arrays.sort(people, Comparator.comparing(Person::getFirstName,  /*Nyzen static*/
//                Comparator.nullsFirst(Comparator.naturalOrder().reversed())));

        Arrays.sort(people, Comparator.comparing(Person::getFirstName,
                Comparator.nullsFirst(Comparator.reverseOrder())));
        //-----------------------------

//--------------------------------------------------------------------------------------------------------------------
    }
}

// A reverse comparator for strings.
class MyComp implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        // Reverse the comparison.
        return bStr.compareTo(aStr);
    }
    // No need to override equals or the default methods.
}

// Compare last whole words in two strings.
class TComp implements Comparator<String> {
    public int compare(String aStr, String bStr) {
        int i, j, k;

        // Find index of beginning of last name.
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');

        k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
        if (k == 0) // last names match, check entire name
            return aStr.compareToIgnoreCase(bStr);
        else
            return k;
    }
    // No need to override equals.
}

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return
                firstName + " " + lastName;
    }
}

/*
----------------------------------------------------------------------------------------------------------------------

int compare(Т объеkt 1, Т объеkt 2)
                        Здесь параметры объект] и о бъект2 обозначают сравниваемые объекты.
                        Обычно этот метод возвращает нулевое значение, если объекты равны; положи·
                        тельное значение, если о бъект 1 больше, чем объект2, а иначе - отрицательное зна·
                        чение. Этот метод может сгенерировать исключение типа C l a s s C a s t E x cept ion,
                        если типы сравниваемых объектов несовместимы. Реализуя метод comp a r e ( ) ,
                        можно изменить порядок расположения объектов. Например, чтобы отсортиро­
                        вать объекты в обратном порядке, можно создать компаратор, который обращает
                        результат их сравнения.

boolean equals(Object объеkt)
                        Здесь параметр о бъект обозначает проверяемый на равенство объект. Метод
                        equals() возвращает логическое значение t r u e , если заданный объект и вызы·
                        вающий объект относятся к типу C ornp a r a t o r и упорядочиваются одним и тем же
                        способом. В противном случае этот метод возвращает логическое значение fArgInt a l s e .
                        Переопределение метода equals() не требуется, и большинство простых компа·
                        раторов в этом не нуждается .

default Comparator<T> reversed()
                        Этот метод возвращает компаратор с обратным упорядочением. Так, если в ис­
                        ходном компараторе используется естественное упорядочение символов от А до Z ,
                        то компаратор с обратным упорядочением расположит букву В перед А , букву С
                        перед В и т.д. С методом r e ve r s e d ( ) тесно связан метод r e ve r s eOrde r ( )

static <Т extends ComparaЬle<? super Т>> Comparator<T> reverseOrder()
                        Этот метод возвращает компаратор, изменяющий н а обратное естественное
                        упорядочение сравниваемых элементов.

static <Т extends ComparaЬle< ? super Т>> Comparator<T> naturalOrder()
                        С другой стороны, можно получить ком­
                        паратор с естественным упорядочением сравниваемых элементов, вызвав стати­
                        ческий метод n a t u r a l Orde r ( ) . Ниже приведена его общая форма.

static <Т> Comparator<T> nullsFirst(Comparator< ? super Т> жонпара тор)
static <Т> Comparator<T> nullsLast(Comparator<? super Т> жон:пара тор)
                        Если же требуется компаратор, с пособный обрабатывать пустые значения null,
                        то для этой цели служит метод n u l l s Fi r s t ( ) или n u l l s L a s t ( ) . Ниже при­
                        ведены общие формы этих методов.
                        Метод nul l s F i r s t ( ) возвращает компаратор, рассматривающий пустые значе­
                        н ия nu l l как меньшие остальных значений. А метод nu l l s L a s t ( ) возвращает компа­
                        ратор, рассматривающий пустые :ша•1ения nu l l как бальшие остальных значений. Но
                        в любом случае заданный компара тор выполняет сравнение, если оба сравниваемых
                        значения не являются пустыми. Если же заданному компара тору передается пустое
                        значение nu l l , то все непустые значения рассматриваются им как равнозначные.

В версии JDК 8 в интерфейсе Comp a r a t o r появился еще один метод по умол­
чанию, выполняющий второе сравнение, если результат первого сравнения ука­
зывает на равенство сравниваемых объектов. Следовательно , с помощью этого
метода можно составить последовательность "сравнить сначала по Х, а затем
по У". Например, при сравнении городов можно сначала сравнивать их назва­
н ия, а затем названия штатов. Так, в естественном алфавитном порядке название
Спрингфилд, Иллинойс, будет предшествовать названию Спрингфилд, Миссури .
У метода t h e nComp a r i ng ( ) имеются три общие формы объявления. Н иже приве­
дена первая общая форма, позволяющая указать второй компаратор, передав эк­
земпляр объек10. типа Comp a r a t o r . В этой форме параметр в торой_ компара тор
обозначает компаратор, вызываемый в том случае, если первый компаратор воз­
вр ащает признак равенства сравниваемых объектов.
default CoП1parator<T> thenComparing (Comparator< ? super Т> .второii_ жонпара тор)

В двух других формах метода the nCompar ing ( ) можно указать стандартный
функциональный интерфейс Func t i on , определенный в пакете j ava . ut il .
fArgInt u n c t i o n . Обе эти формы приведены ниже.

default <U extends Comparator<? super U> Comparator<T>
        thenComparinq(Function<? super Т, ? extends U> polychit klych)
default <U> Comparator<T>
        thenComparing(Function<? super Т, ? extends U> polychit klych,
        Comparator<? super U> komparator klychei)

В обеих формах параметр получить_ ключ обозначает функцию, получаю­
щую следующий ключ для сравнения. Этот ключ используется в том случае, если
в результате первого сравнения возвращается признак равенства сравниваемых
объектов. В последней форме данного метода параметр компара тор_ключей обо­
значает компаратор, используемый для сравнения ключей. (Здесь и далее U обо­
значает тип ключа.)

Интерфейс Compa r a t o r дополнен также специальными вариантами методов
последующего сравнения примитивных типов данных. Их общие формы приведе­
ны ниже, где параметр получить_ ключ обозначает функцию, получающую следу·
ющий ключ для сравнения.

default Comparator<T> thenComparinqDouЫe(ToDouЬleFunction<? super Т> plychit klych)
defaul t Comparator<T> thenComparinqint (TointFunction<? super Т> plychit klych)
default Comparator<T> thenComparinqLonq (ToLonqFunction<? super Т> plychit klych)

И наконец, в версии JDK 8 интерфейс C omp a r a t o r дополнен методом
comp a r i n g ( ) . Этот метод возвращает компаратор, получающий ключ для срав·
не ния от фун кции , передаваемой данному методу в качестве параметра. Ниже
нриведены обе формы объявления метода c omp a r i ng ( ) .

static <Т, U extends Comparable<? super U>> Coшparator<T> comparinq(Function<? super Т , ? extends U> U> Comparator<T>
static <Т ,Comparator<? super U> comparing(Function<? super Т, ? extends U> polychit klych,)

В обеих формах параметр получить_ ключ обозначает функцию, получаю­
щую следующий ключ для сравнения. Во второй форме данного метода параметр
компара тор_ ключей обозначает компаратор, используемый для сравнения клю­чей

Интерфейс C omp a ra t o r дополнен также специальными вариантами метода
compar ing ( ) для сравнения примитивных типов данных. Их общие формы при·
ведены ниже, где параметр получить_ ключ обозначает функцию, получающую
следующий ключ для сравнения.
static <Т> Comparator<T> ComparingDouble(ToDoubleFunction<? super Т> plychit klych)
static <Т> Comparator<T> ComparingInt TointFunction<? super Т> plychit klych)
static <Т> Comparator<T> ComparingLong(T0LongFunction<? super Т> plychit klych)

•
static <T extends Comparable<? super Т » Comparator<T> reverseOrder() 8
Выдает компаратор, обращающий порядок, обеспечиваемый интерфейсом Comparable.
•
default Coraparator<T> reversed() 8
Выдает компаратор, обращающий порядок, обеспечиваемый данным компаратором.
----------------------------------------------------------------------------------------------------------------------

*/
