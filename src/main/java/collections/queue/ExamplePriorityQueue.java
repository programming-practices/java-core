package collections.queue;

//import org.jetbrains.annotations.NotNull;

//import com.sun.istack.internal.NotNull;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * This program demonstrates the use of a priority queue.
 *
 * @author Cay Horstmann
 * @version 1.02 2015-06-20
 */
public class ExamplePriorityQueue {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
//        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
//        pq.add(LocalDate.of(1906, 12, 9)); // G. Hopper
//        pq.add(LocalDate.of(1815, 12, 10)); // A. Lovelace
//        pq.add(LocalDate.of(1903, 12, 3)); // J. von Neumann
//        pq.add(LocalDate.of(1910, 6, 22)); // K. Zuse
//
//        System.out.println("Iterating over elements...");
//        for (LocalDate date : pq) System.out.println(date);
//        System.out.println("Removing elements...");
//        while (!pq.isEmpty()) System.out.println(pq.remove());
//---------------------------------------------------------------------------------------------------------------------
//        // Creating empty priority queue
//        PriorityQueue<String> pQueue = new PriorityQueue<String>();
//
//        // Adding items to the pQueue
//        pQueue.add("C");
//        pQueue.add("C++");
//        pQueue.add("Java");
//        pQueue.add("Python");
//        pQueue.add("C#");
////        pQueue.offer("C#");
//
//        // Printing the most priority element
//        System.out.println("Head value using peek function: " + pQueue.peek());
//
//        // Printing all elements
//        System.out.println("The queue elements: " + pQueue);
//
//        // Removing the top priority element (or head) and
//        // printing the modified pQueue
//        System.out.println("pQueue.poll() = " + pQueue.poll());
//        System.out.println("After removing an element with poll function: " + pQueue);
//
//        // Removing Java
//        pQueue.remove("Java");
//        System.out.println("After removing Java with remove function: " + pQueue);
//
//        // Check if an element is present
//        System.out.println("Priority queue contains C ot not?: " + pQueue.contains("C"));
//
//        // get objects from the queue in an array and
//        // print the array
//        String[] arr = new String[pQueue.size()];
//        pQueue.toArray(arr);
//        System.out.println("Value in array: " + Arrays.toString(arr));
//---------------------------------------------------------------------------------------------------------------------
        /*Esli nado zberihat kakoito svoi klass  v PriorityQueue to nado chtob etot klass implementil
          Comparable<ClassA> i chtobu bul realizirovan metod comparaTo(),
          esli eto ne bydet zdelano to vulitit Error*/

        // Zdes natyralnoe rozstavlenie elementov
        PriorityQueue<ClassA> pQueue = new PriorityQueue<>();

        // Zdes nado obrawchat vnimanie kak realizirovan method compareTo(), esli
        // comparator zdelanui cherez method compareTo()
//        PriorityQueue<ClassA> pQueue = new PriorityQueue<>(10, (o1, o2) -> o1.compareTo(o2));

        // Mozno tak
//        PriorityQueue<ClassA> pQueue = new PriorityQueue<>(10, ClassA::compareTo);

//        PriorityQueue<ClassA> pQueue = new PriorityQueue<>(10, Comparator.reverseOrder());
//        PriorityQueue<ClassA> pQueue = new PriorityQueue<ClassA>(10, Comparator.naturalOrder());

        Comparator<? super ClassA> comparator = pQueue.comparator();
        System.out.println("Comparator value: " + comparator);

        pQueue.add(new ClassA("A", 30));
        pQueue.add(new ClassA("B", 10));
        pQueue.add(new ClassA("C", 50));
        pQueue.add(new ClassA("D", 20));
        pQueue.add(new ClassA("E", 40));

        System.out.println("Head value using peek function: " + pQueue.peek());

        System.out.println("The queue elements: " + pQueue);

        System.out.println("pQueue.poll() = " + pQueue.poll());
        System.out.println("After removing an element with poll function: " + pQueue);

        // Chtobu zdelat pQueue.remove(new ClassA("C",30)) nado chtobu bul realizirovan metod equals()
        // v classe ClassA, i esli method equals() nety ili on nepravelno zdelan to ykaznui
        // element ne bycet ydalion.
        System.out.println("Is remove ClassA(\"C\", 30): " + pQueue.remove(new ClassA("C", 30)));
        ;
        System.out.println("After removing Java with remove function: " + pQueue);

        System.out.println("Priority queue contains C ot not?: " + pQueue.contains("C"));

        ClassA[] arr = new ClassA[pQueue.size()];
        pQueue.toArray(arr);
        System.out.println("Value in array: " + Arrays.toString(arr));
//---------------------------------------------------------------------------------------------------------------------
    }
}

class ClassA implements Comparable<ClassA> {
    private String name;
    private int age;

    public ClassA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClassA classA = (ClassA) o;
        return this.age == classA.age &&
                Objects.equals(this.name, classA.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.name, this.age);
    }

    @Override
    public int compareTo(ClassA classA) {
        return this.age < classA.age ? classA.age - this.age : this.age - classA.age;
    }

    @Override
    public String toString() {
        return "( name = " + name +
                " age = " + age + " )";
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
method compereTo() nado realizirovat ochen ostorozno i vdymchevo potomu chto ot niho mnoho zavisit
-----------------------------------------------------------------------------------------------------------------------
 Esli nado zberihat kakoito svoi klass  v PriorityQueue to nado chtob etot klass implementil
 Comparable<ClassA> i chtobu bul realizirovan metod comparaTo(),
 esli eto ne bydet zdelano to vulitit Error
-----------------------------------------------------------------------------------------------------------------------
 Chtobu korrektno rabotal method remove() nado chtobu bul realizirovan metod equals()
 v classe classe cotorui xranitsa v PriorityQueue, i esli method equals() nety
 ili on nepravelno zdelan to ykaznui method remove() ne ydalit ykazanui element.
-----------------------------------------------------------------------------------------------------------------------
 PriorityQueue — является единственной прямой реализацией интерфейса Queue (была добавлена, как и
 интерфейс Queue, в Java 1.5), не считая класса LinkedList, который так же реализует этот интерфейс,
 но был реализован намного раньше. Особенностью данной очереди является возможность управления
 поведение может быть переопределено при помощи объекта Comparator, который задаётся при создании
 очереди. Данная коллекция не поддерживает null в качестве элементов.
------------------------------------------------------------------------------------------------------------------------------------------
Если при построении очереди типа P r i o r i t yQueue компаратор не указан, то
п р именяется компаратор, выбираемый по умолчанию для того типа данных, ко­
тор ый сохраняется в очереди. Компаратор по умолчанию размещает элементы
очереди по нарастающей. Таким образом , в начале ( голове) очереди окажется
элемент с наименьшим значением. Но, предоставляя свой компаратор, можно за­
дать другую схему сортировки элементов в очереди. Например, когда в очереди
сохраняются элементы, содержащие метку времени, для этой очереди можно за­
дать приоритеты 1vаким образом , чтобы самые давние элементы располагались
в начале очереди.
Вызвав метод c ompa r a t o r ( ) из класса P r i o r i t yQue ue , можно получить ссылку
на компаратор, используемый в очереди, как показано ниже.
Coшparator<? super Е> comparator ( )
Этот метод возвращает компаратор. Если в данной очереди применяется есте­
ственный порядок сортировки, то возвращается пустое значение nu 1 1 . Следует, од­
нако, иметь в виду, что порядок перебора элементов очереди типа P r i o r i t yQueue
не опр еделен , несмотря на то, что их можно перебрать, используя итератор.
Чтобы правильно воспользоваться классом P r i o r i t yQu e u e , следует вызы вать та­
кие методы, как o fArgInt fArgInt e r ( ) и p o l l ( ) , определенные в интерфейсе Que u e .
------------------------------------------------------------------------------------------------------------------------------------------
•PriorityQueue()
•PriorityQueue(int ini tialCapaci ty)
    Конструируют очередь по приоритету для хранения объектов типа Comparable.

•PriorityQueue(int initialCapacity, Comparators <? super E> c)
    Конструирует очередь по приоритету и использует заданный компаратор для сортировки ее элементов.
------------------------------------------------------------------------------------------------------------------------------------------


*/
