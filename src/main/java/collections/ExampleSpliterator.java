package collections;

import java.util.ArrayList;
import java.util.Spliterator;

public class ExampleSpliterator {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

//        Collection<Integer> collection_00 = new ArrayList<>(Arrays.asList(1,1,2,3,3,4,5,6,7,8,8,9,10,10,3));
//        Spliterator<Integer> spliterator = collection_00.spliterator();
//
//        System.out.println(spliterator.characteristics());
//
//        System.out.println("SORTED = " + spliterator.hasCharacteristics(Spliterator.SORTED));
//        System.out.println("NONNULL = " + spliterator.hasCharacteristics(Spliterator.NONNULL));
//        System.out.println("IMMUTABLE = " + spliterator.hasCharacteristics(Spliterator.IMMUTABLE));
//        System.out.println("ORDERED = " + spliterator.hasCharacteristics(Spliterator.ORDERED));
//        System.out.println("DISTINCT = " + spliterator.hasCharacteristics(Spliterator.DISTINCT));
//        System.out.println("SIZED = " + spliterator.hasCharacteristics(Spliterator.SIZED));
//        System.out.println("SUBSIZED = " + spliterator.hasCharacteristics(Spliterator.SUBSIZED));
//        System.out.println("CONCURRENT = " + spliterator.hasCharacteristics(Spliterator.CONCURRENT));

//---------------------------------------------------------------------------------------------------------------------

        // Create an array list for doubles.
        ArrayList<Double> arrayList = new ArrayList<>();

        // Add values to the array list.
        arrayList.add(1.0);
        arrayList.add(2.0);
        arrayList.add(3.0);
        arrayList.add(4.0);
        arrayList.add(5.0);

        // Use tryAdvance() to display contents of vals.
        System.out.print("Contents of vals:\n");
        Spliterator<Double> spltitr = arrayList.spliterator();
        while (spltitr.tryAdvance((n) -> System.out.println(n))) ;
        System.out.println();

        // Create new list that contains square roots.
        spltitr = arrayList.spliterator();
        ArrayList<Double> arrayListSquare = new ArrayList<>();
        while (spltitr.tryAdvance((n) -> arrayListSquare.add(Math.sqrt(n)))) ;

        // Use forEachRemaining to display contents of sqrs.
        System.out.print("Contents of sqrs:\n");
        spltitr = arrayListSquare.spliterator();
        spltitr.forEachRemaining((n) -> System.out.println(n));
        System.out.println();

//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------

Spliterator podderzuvaet paralelnyiy iteraciy otdelnux chastei posledovatelnosti elementov, a sledovatelno i
paralelnoe programirovenie

----------------------------------------------------------------------------------------------------------------------

Интерфейс Sp l i t e r a t o r применяется для решения основных задач итерации
очень просто. Для этого достаточно вызывать метод t r yAdvan c e ( ) до тех пор ,
пока он не возвратит логическое значение fa l s e . Если же требуется выполнить
одно и то же действие над каждым элементом последовательности , то для этой
цели имеется более простая альтернатива - вызвать метод fArgInt o r E a chRema i n i ng ( ) .
В обоих случ аях действие, происходящее на каждом шаге итерации, определяется
тем , что именно объект типа C o n s ume r собирается делать с каждым элементом,
где Consume r - это функциональный интерфейс, выполняющий действие над объ­ектом.

Kak ypomianalos выше, наибольшую выгоду применение интерфейса S p l i t e r a t o r прино­
сит в тех случаях, когда требуется параллельная обработка.
Обратите внимание на методы c h a r a c t e r i s t i c s ( ) и hasCharact e r i s t i c s ( ) ,
перечисленные в табл. 1 8. 1 2 . У каждого итератора-разделителя типа Sp l i t е r а t о r
имеются свойства, называемые характеристиками. Эти характеристики определя­
ются в статических полях типа int интерфейса Sp l i t e ra t o r , в том числе SORTED,
D I S T I NCT , S I ZE D и I ММUTABLE и прочих полях. Для получения характеристик ите­
ратора-разделителя достаточно вызвать метод c h a r a ct e r i s t i c s ( ) , а для выяв­
ления отдельной характеристики у итератора-разделителя - метод hasCharacte
r i s t i c s ( ) Зачастую получать характеристики итератора-разделителя не требу­
ется, но иногда они помогают в написании эффективного, устойчивого кода.

Несколько подчиненных интерфейсов, вложенных в и нтерфейс Sp l i t е r а to r ,
предназначены для применения вместе с примитивными типами данных
douЬ l e , int и long. Это интерфейсы Sp l i te r a to r . O fArgInt DouЫ e , Sp l i te r a t o r .
O fArgInt i n t и Sp l i t e r a to r . OfLong. Имеется также обобщенный вариант интерфейса
Sp l i te r a to r . O fArgInt P r imi t i ve , предоставляющий дополнительные удобства и под­
чиненный упомянутым выше интерфейсам.

----------------------------------------------------------------------------------------------------------------------

int characteristics()                   Vozvrawchaet xarakterustuku vuzuvaywcheho iteratora-razdelitela
                                        predstavlennue v vide celochislennoho znachenia

long estimeteSize()                     Ocenivaet kolichestvo elementov, kotoruie ostalos perebrat,
                                        i vozvrawchaet polychenui rezyltat.Esli etot rezyltat ne
                                        polychartsa polychit po kakoito prichine to vozvrawchaetsa
                                        znachenie konstantu Long.MAX_VALUE

default forEachRemaining(Consumer<? extends T> deistvie
                                        ..........

dafault Comparator<? super Т> getComparator()
                                        Возвращает компаратор, используемый вызы­
                                        вающим итератором-разделителем , или пустое
                                        значение null , если используется естественное
                                        упорядочение. А если последовательность не
                                        упорядочена, то генерируется исключение типа
                                        IllegalStateException

default long getExactSizeI­fKnown()
                                        Если установлен размер вызывающего итератора­
                                        разделителя, то возвращается количество элемен­
                                        тов, которое осталось перебрать, а иначе - значе­ние -1

default Ьoolean hasCharacteristics(int val)
                                        Возвращает логическое значение true, если у вы­
                                        зывающего итератора-разделителя имеются харак­
                                        теристики, передаваемые в качестве параметра val,
                                        а иначе - логическое значение false

Ьoolean tryAdvance(ConsU111e r <? super Т> действие)
                                        Выполняет заданное действие над следующим эле­
                                        ментом в итерации. Возвращает логическое значе­
                                        ние true, если следующий элемент присутствует,
                                        а иначе - логическое значение false

Spliterator<T> trySplit()
                                        Разделяет, если это возможно, вызывающий итера­
                                        тор-разделитель, возвращая ссылку на новый ите­
                                        ратор-разделитель для последующего разделения,
                                        а иначе - пустое значение null . При удачном исходе
                                        разделения исходный итератор-разделитель пере­
                                        бирает одну часть последовательности, а возвращае­
                                        мый итератор-разделитель - остальную ее часть

----------------------------------------------------------------------------------------------------------------------
*/
