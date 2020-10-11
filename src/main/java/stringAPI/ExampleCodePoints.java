package Examples.String_API;

import java.util.Arrays;

public class ExampleCodePoints {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

        /*Метод length() возвращает количество кодовых единиц для данной строки в ко­
        дировке UTF-16. Ниже приведен пример применения данного метода.*/
        String greeting = "Hello";
        int n = greeting.length(); // значение n равно 5
        System.out.println(n);

        /*Чтобы определить истинную длину символьной строки, представляющую собой
        число кодовых точек, нужно сделать следующий вызов:*/
        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(cpCount);

        /*При вызове метода s.charAt(n) возвращается кодовая единица на позиции n, где
        n находится в пределах от 0 до s.length()-1. Ниже приведены примеры вызова
        данного метода.*/
        char first = greeting.charAt(0); // первый символ - ’Н'
        char last = greeting.charAt(4); // последний символ -'o'
        System.out.println(first);
        System.out.println(last);

        /*А зачем вообще обсуждать кодовые единицы? Рассмотрим следующую символь­
        ную строку: "О is the set of octonions"*/
//        Character c = new Character('U+006F');
//        char cc = '\u006F';
        char cc = '\u0275';
        String sentence = cc + " is the set of octonions";
        System.out.println(sentence);
//        System.out.println(cc);

        /*Для представления символа О требуются две кодовые единицы в кодировке UTF-16. В результате приведенного
        ниже вызова будет получен не код пробела, а вторая кодовая единица символа О:*/
        char ch = sentence.charAt(1);
        System.out.println("---" + ch + "---");

        /*Чтобы избежать подобных осложнений, не следует применять тип char, посколь­ ку он представляет символы
        на слишком низком уровне.
          Если же требуется просмотреть строку посимвольно, т.е. получить по очереди
        каждую кодовую точку, то для этой цели можно воспользоваться фрагментом кода, аналогичным приведенному ниже.*/
        for (int i = 0; i < sentence.length(); i++) {
            int cp = sentence.codePointAt(i);
            if (Character.isSupplementaryCodePoint(cp)) i += 2;
            else i++;
//            System.out.println(cp);
        }

        /*А организовать просмотр строки в обратном направлении можно следующим об­ разом:*/
//        for (int i = sentence.length() - 1; i >= 0 ;) {
//            i--;
//            if (Character.isSurrogate(sentence.charAt(i))) i--;
//            int cp = sentence.codePointAt(i);
//        }

        /*Очевидно, что это не совсем удобно. Поэтому проще воспользоваться методом codePoints (), который
        формирует "поток" значений типа in t для отдельных ко­довых точек. (Более подробно потоки данных
        рассматриваются в главе 2 второго тома настоящего издания.) Полученный в итоге поток данных можно
        преобразовать в массив, как показано ниже, а затем перебрать его элементы, как поясняется далее в разделе ЗЛО.*/
        String str = "О is the set of octonions";
        int[] codePoints = str.codePoints().toArray();
        System.out.println(Arrays.toString(codePoints));

        /*С другой стороны,чтобы преобразовать массив кодовых точек в символьную стро­ку,можно воспользоваться конструктором
        класса String , как показано в ниже. (Бо­лее подробно конструкторы и операция new обсуждаются в главе 4.)*/
        String str1 = new String(codePoints, 0, codePoints.length);
        System.out.println(str1);
//--------------------------------------------------------------------------------------------------------------------
    }
}
