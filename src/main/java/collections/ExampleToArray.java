package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleToArray {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        /*Получить массив из коллекции немного сложнее. Безусловно, для этого можно воспользоваться методом toArray() следующим образом:
                            Object[] values = staff.toArray();
        Но в итоге будет получен массив объектов. Даже если известно, что коллекция содержит объекты определенного типа,
        их все равно нельзя привести к нужному типу:
                            String [] values = (StringH) staff .toArray () ; // ОШИБКА!
        Массив, возвращаемый методом toArray(), создан как массив типа Object[], а этот тип изменить нельзя. Вместо этого
        следует воспользоваться приведенным ниже вариантом метода toArray(), передав ему массив нулевой длины и требуемого
        типа. Возвращаемый в итоге массив окажется того ж е самого типа.
                            String[] values = staff.toArray(new String[0]);
        Если есть желание, можно сразу сконструировать массив нужного размера следующим образом:
                            staff.toArray(new String[staff.size()]);
        В этом случае новый массив не создается.

        НА ЗАМЕТКУ! У вас может возникнуть следующий вопрос: почему бы просто не передать объект типа Class(например, String.class)
        методу toArray() ? Но ведь этот метод несет на себе "двойную нагрузку", заполняя существующий массив (если он
        достаточно длинный) и создавая новый.*/
        List<String> staff = new ArrayList<>();
        staff.add("A");
        staff.add("B");
        staff.add("C");
        staff.add("D");
        staff.add("E");
//        Object[] values = staff.toArray();
//        String [] values = (String) staff.toArray() ; // ОШИБКА!
//        String[] values = staff.toArray(new String[0]);
        String[] values = staff.toArray(new String[staff.size()]);
        System.out.println(Arrays.toString(values));
//---------------------------------------------------------------------------------------------------------------------

//        Collection<String> collection00 = new LinkedList<>(Arrays.asList("q", "a", "e", "l", "o"));
//
//        Object[] array00 = collection00.toArray();
//        System.out.print(Arrays.toString(array00));
//        System.out.println("   Finalnaia dlina etoho masiva = " + array00.length);
//
//        // A zdes tak rabotaet )))
//        Object[] array01 = new Object[0];
//        System.out.print("Nachalnaia dlina etoho masiva = " + array01.length + "   ");
//        array01 = collection00.toArray();
//        System.out.print(Arrays.toString(array01));
//        System.out.println("   Finalnaia dlina etoho masiva = " + array01.length);
//
//        // A zdes tak, obrezaetsa masiv
//        Object[] array02 = new Object[10];
//        System.out.print("Nachalnaia dlina etoho masiva = " + array02.length + "   ");
//        array02 = collection00.toArray();
//        System.out.print(Arrays.toString(array02));
//        System.out.println("   Finalnaia dlina etoho masiva = " + array02.length);

//---------------------------------------------------------------------------------------------------------------------

//        Collection<String> collection01 = new LinkedList<>(Arrays.asList("q", "a", "e", "l", "o"));
//
//        // ostorozno zdes,esli zdelat new String[0] to arrey ne zapolnitsa collecciei
//        String[] args01 = new String[0];
//        collection01.toArray(args01);
//        System.out.println("new String[0] = " + Arrays.toString(args01));
//
//        // S etim toze nado bit ostoroznum, masiv dolzin bit proinicialisirovan
//        // razmerom colleccii tolko v etakom slchai bydet vso xorowo
//        String[] args03 = new String[4];
//        collection01.toArray(args03);
//        System.out.println("new String[4] = " + Arrays.toString(args03));
//
//        // Zdes toze nado bit ostoroznum esli v masive ne nyznu null valyes
//        String[] args04 = new String[10];
//        collection01.toArray(args04);
//        System.out.println("new String[10] = " + Arrays.toString(args04));
//
//
//        // A tak vso srabotaet xorowo
//        String[] args02 = new String[collection01.size()];
//        collection01.toArray(args02);
//        System.out.println("new String[collection01.size()] = " + Arrays.toString(args02));


//---------------------------------------------------------------------------------------------------------------------
//        // Create an array list.
//        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
//        // Add elements to the array list.
//        integerArrayList.add(1);
//        integerArrayList.add(2);
//        integerArrayList.add(3);
//        integerArrayList.add(4);
//        System.out.println("Contents of al: " + integerArrayList);
//        // Get the array.
//        Integer arrayIntegers[] = new Integer[integerArrayList.size()];
//        arrayIntegers = integerArrayList.toArray(arrayIntegers);
//        int sum = 0;
//        // Sum the array.
//        for(int i : arrayIntegers) sum += i;
//        System.out.println("Sum is: " + sum);
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
Object[] toArray()      Возвращает массив, содержащий все элементы вы­
                        зывающей коллекции. Элементы массива являются
                        копиями элементов коллекции

<Т> Т[] toArray(T[] массив)
                        Возвращает массив, содержащий элементы вызыва­
                        ющей коллекции. Элементы массива являются копи­
                        ями элементов коллекции. Если размер заданного
                        массива равен количеству элементов в коллекции,
                        они возвращаются в этом массиве.

                        !!!!!!!!! ETA INFORMACIA MNE KAZETSA CHTO OWUBOCHNA !!!!!!!!!!!!!!!
                        ! Еели же размер массива меньше количества элементов в коллекции, !
                        ! то создается и возвращается новый массив нужного                !
                        ! размера. А если размер массива больше количества                !
                        ! элементов в коллекции, то во всех элементах, сле                !­
                        ! дующих за последни м из коллекции, устанавлива                  !­
                        ! ется пустое значение null. И если любой элемент                 !
                        ! коллекции относится к типу, не являющемуся под­                  !
                        ! тилом .массива, то генерируется исключение тила                 !
                        ! ArrayStoreException                                             !
                        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
*/

