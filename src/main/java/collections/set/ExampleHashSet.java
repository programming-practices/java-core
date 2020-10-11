package collections.set;

import java.util.Objects;

/**
 * This program uses a set to print all unique words in System.in.
 *
 * @author Cay Horstmann
 * @version 1.12 2015-06-21
 */
public class ExampleHashSet {
    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------------------------
//        Set<String> words = new HashSet<>(); // HashSet implements Set
//        long totalTime = 0;
//
//        try (Scanner in = new Scanner(System.in)) {
//            while (in.hasNext()) {
//                String word = in.next();
//                if (word.equals("e12"))break;
//                long callTime = System.currentTimeMillis();
//                words.add(word);
//                callTime = System.currentTimeMillis() - callTime;
//                totalTime += callTime;
//            }
//        }
//
//        Iterator<String> iter = words.iterator();
//        for (int i = 1; i <= 20 && iter.hasNext(); i++)
//            System.out.println(iter.next());
//        System.out.println(". . .");
//        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");

//----------------------------------------------------------------------------------------------------------------------------------------
//        Set<Integer> hashSet = new HashSet<>();
//        //  в HashSet в качестве ключа выступает сам элемент,
//        hashSet.add(3);

//----------------------------------------------------------------------------------------------------------------------------------------
//        // Может ли Set содержать null?
//        Set<Integer> hashSet1 = new HashSet<>();
//        hashSet1.add(null);
//        hashSet1.add(null); // ne dobavitsa ewcho odin null potomy wto eto set
//        System.out.println(hashSet1.size());
//        System.out.println(hashSet1.contains(null));
//        System.out.println(hashSet1);

//----------------------------------------------------------------------------------------------------------------------------------------
//        // Create age hash set.
//        HashSet<String> hs = new HashSet<String>();
//        // Add elements to the hash set.
//        hs.add("Beta");
//        hs.add("Alpha");
//        hs.add("Eta");
//        hs.add("Gamma");
//        hs.add("Epsilon");
//        hs.add("Omega");
//        System.out.println(hs);

//----------------------------------------------------------------------------------------------------------------------------------------
//        // Ostorozno zdes esli nado zberihat class ClassKotoruiImeetHashCode v HashSete()
//        // to nado realizovat metod hashCode(), potomy chto esli ne realizovat metod hashCode() to
//        // ne polychica soxranennie v vide xewei a v vide sviaznoho spiska (polychitsa chtoto poxozoe na LinkedList)
//        Set<ClassKotoruiImeetHashCode> set00 = new HashSet<>();
//        set00.add(new ClassKotoruiImeetHashCode("a"));
//        set00.add(new ClassKotoruiImeetHashCode("z"));
//        set00.add(new ClassKotoruiImeetHashCode("q"));
//        set00.add(new ClassKotoruiImeetHashCode("g"));
//        System.out.print("ClassKotoruiImeetHashCode =   ");
//        set00.forEach(value -> System.out.print(value + ", "));
//        System.out.println();
//
//        Set<ClassKotoruiNeImeetHashCode> set01 = new HashSet<>();
//        set01.add(new ClassKotoruiNeImeetHashCode("a"));
//        set01.add(new ClassKotoruiNeImeetHashCode("z"));
//        set01.add(new ClassKotoruiNeImeetHashCode("q"));
//        set01.add(new ClassKotoruiNeImeetHashCode("g"));
//        System.out.print("ClassKotoruiNeImeetHashCode = ");
//        set01.forEach(value -> System.out.print(value + ", "));

//----------------------------------------------------------------------------------------------------------------------------------------
//        Set<String> set1 = new HashSet<>();
//
//        Collections.addAll(set1, "A B C D E F G H I J K L".split(" "));
//        set1.add("ClassNaslednikVNePackage");
//        System.out.println(set1);
//        System.out.println("H: " + set1.contains("H"));
//        System.out.println("N: " + set1.contains("N"));
//
//        Set<String> set2 = new HashSet<>();
//        Collections.addAll(set2, "H I J K L".split(" "));
//
//        System.out.println("set2 in set1: " + set1.containsAll(set2));
//        set1.remove("H");
//        System.out.println("set1: " + set1);
//        System.out.println("set2 in set1: " + set1.containsAll(set2));
//        set1.removeAll(set2);
//        System.out.println("set2 removed from set1: " + set1);
//
//        Collections.addAll(set1, "X Y Z".split(" "));
//        System.out.println("'X Y Z' added to set1: " + set1);

//----------------------------------------------------------------------------------------------------------------------------------------
//        Integer[] a = {1,2,3,4};
//        Integer[] b = {3,4,5,6};

//        Set<Integer> s = new HashSet<>(Arrays.asList(a));
//        System.out.println(s);
//        s.retainAll(Arrays.asList(b));
//        System.out.println(s);

//----------------------------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------------------------

    }
}

class ClassKotoruiImeetHashCode {
    private String name;

    public ClassKotoruiImeetHashCode(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClassKotoruiImeetHashCode that = (ClassKotoruiImeetHashCode) o;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

class ClassKotoruiNeImeetHashCode {
    private String name;

    public ClassKotoruiNeImeetHashCode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}


/*
-----------------------------------------------------------------------------------------------------------------------
Множество — это совокупность элементов, не содержащая дубликатов. Так, метод add () сначала пытается найти вводимый объект
и вводит его только в том случае, если он отсутствует в множестве.

-----------------------------------------------------------------------------------------------------------------------
Ostorozno zdes esli nado zberihat class ClassKotoruiImeetHashCode v HashSete()
to nado realizovat metod hashCode(), potomy chto esli ne realizovat metod hashCode() to
ne polychica soxranennie v vide xewei a v vide sviaznoho spiska (polychitsa chtoto poxozoe na LinkedList)

-----------------------------------------------------------------------------------------------------------------------
HashSet — реализация интерфейса Set, базирующаяся на HashMap. Внутри использует объект HashMap для хранения данных.
В качестве ключа используется добавляемый элемент, а в качестве значения — объект-пустышка (new Object()). Из-за
особенностей реализации порядок элементов не гарантируется при добавлении.

-----------------------------------------------------------------------------------------------------------------------
ВНИМАНИЕ! Будьте внимательны и аккуратны, изменяя элементы хеш-множества. Если хеш-код элемента изменится, этот элемент
уже не будет находиться на правильной позиции в структуре данных.

-----------------------------------------------------------------------------------------------------------------------
HashSet использует для хранения элементов такой же подход, что и HashMap, за одним отличием, что в HashSet в качестве
ключа выступает сам элемент, кроме того HashSet (как и HashMap) не поддерживает упорядоченное хранение элементов и
обеспечивает временную сложность выполнения операций аналогично HashMap.

-----------------------------------------------------------------------------------------------------------------------
А метод contains() переопределяется, чтобы осуществлять быстрый поиск элементов в множестве. Он проверяет элементы только
одной группы, а не все элементы коллекции.

-----------------------------------------------------------------------------------------------------------------------
HashSet ne imeiet metoda accessOrder() kotorui est v HashMap

-----------------------------------------------------------------------------------------------------------------------
в качестве аргументов конструктора задается емкость хеш-множества и коэффициент_заполнения, иначе называемый емкостъю
загру31Сu. Коэффициент заполнения должен быть в пределах от О, до 1 , О, которые определяют, насколько заполненным должно
быть хеш-множество , прежде чем будет изменен его размер. В частности , когда количество элементов становится больше
емкости хешмножества, умноженной на коэффициент заполнения , такое хеш-множество расширяется.

-----------------------------------------------------------------------------------------------------------------------
Как пояснялось ранее, элементы не сохраняются в хеш-множестве в отсортированном порядке, по этому порядок их вывода может
варьироваться.

-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Начиная с версии Java SE 8, вместо связных списков в заполненных группах приме­няются сбалансированные двоичные
деревья. Благодаря этому повышается производительность, если в результате неудачно выбранной хеш-функции возникает немало
конфликтов или же если в злонамеренном коде предпринимается попытка заполнить хеш-таблицу многими значениями
с одинаковыми хеш-кодами.

-----------------------------------------------------------------------------------------------------------------------
HashSet()
    Конструирует пустое хеш-множество.

HashSet (Collections extends E> elements)
    Конструирует хеш-множество и вводит в него все элементы из коллекции.

HashSet(int InltlalCapaclty)
    Конструирует пустое хеш-множество заданной емкости (количество групп).

HashSet(int initialCapaclty, float loadFactor)
    Конструирует пустое хеш-множество заданной емкости и с указанным коэффициентом загрузки(числовым значением в пределах
    от 0 , 0 до 1 , 0 , определяющим предельный процент заполнения хеш-таблицы, по достижении которого происходит
    повторное хеширование).

-----------------------------------------------------------------------------------------------------------------------

*/
