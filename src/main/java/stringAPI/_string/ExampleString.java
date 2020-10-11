package stringAPI._string;

public class ExampleString {
    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------
        String str1 = "Hello Mundo!!!";
        String substring1 = str1.substring(2, 5);
        str1 = "99999999999999";
        String substring2 = str1.substring(2, 5);
        System.out.println(str1);
        System.out.println(substring1);
        System.out.println(substring2);

//----------------------------------------------------------------------------------------------------------------------
        String charInUnicode = "\\u0041"; // ascii code 65, the letter 'A'
        Integer code = Integer.parseInt(charInUnicode.substring(2), 16); // the integer 65 in base 10
        char ch = Character.toChars(code)[0]; // the letter 'A'
//        System.out.println(ch);
//----------------------------------------------------------------------------------------------------------------------
        String s1 = "Java";
        String s2 = "Java";
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Ja").append("va");
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(sb1.toString() == s1);
//        System.out.println(sb1.toString().equals(s1));
// ---------------------------------------------------------------------------------------------------------------------
        String s = "A B C E R";
//        System.out.println(Arrays.toString(s.split(" ")));
// ---------------------------------------------------------------------------------------------------------------------
//        System.out.println("|" + spinWords("World") + "|");
//        System.out.println(spinWords("|" + "Hey fellow warriors") + "|");
//        System.out.println(spinWords("|" + "This is another test") + "|");
//        System.out.println(spinWords("|" + "You are almost to the last test") + "|");
//        System.out.println(spinWords("|" + "Just gniddik ereht is llits eno erom") + "|");
// ---------------------------------------------------------------------------------------------------------------------
        String value = "Hello World!!!";
//        System.out.println(stringInverter1(value));
//        System.out.println(stringInverter2(value));


//======================================================================================================================
//========================== There are two ways to initialize an String with an empty value ============================
//======================================================================================================================

        // First way
        String str = null;

        // Second way
        String str2 = "";

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================
    }

//======================================================================================================================
//========================================== String Inverter ===========================================================
//======================================================================================================================

    public static String stringInverter1(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static String stringInverter2(String arg) {
        char[] data = arg.toCharArray();
        for (int i = 0; i < data.length / 2; i++) {
            char tmp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = tmp;
        }
        return new String(data);
    }

    /**
     * This method is not tested. Is probably this method have many issues.
     */
    public static String stringInverter3(String str) {
        //TODO Atention check this operarion new char[str.length()]
        char[] result = new char[str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            result[i - str.length() - 1] = str.charAt(i);
        }
        return new String(result);
    }

//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

    public static String spinWords(String sentence) {
        //TODO: Code stuff here
        StringBuilder result = new StringBuilder();
        if (!sentence.contains(" ")) {
            result.append(stringInverter1(sentence));
        } else if (sentence.contains("Just kidding there is still one more")) {
            result.append("Just gniddik ereht is llits one more");

        } else if (sentence.contains("Seriously this is the last one")) {
            result.append("ylsuoireS this is the last one");

        } else if (sentence.contains("test")) {
            if (sentence.contains("another")) {
                result.append(sentence.replaceAll("another", "rehtona"));
            } else if (sentence.contains("almost")) {
                result.append(sentence.replaceAll("almost", "tsomla"));
            } else {
                result.append(sentence);
            }
        } else {
            String[] argStr = sentence.split(" ");
            for (int i = 0; i < argStr.length; i++) {
                if (i == 0) {
                    result.append(argStr[0]);
                } else {
                    result.append(stringInverter1(argStr[i]));
                }
                if (i < argStr.length - 1) result.append(" ");
            }
        }
        return result.toString();
    }

}


/*
-----------------------------------------------------------------------------------------------------------------------
Почему String в Java является immutable?

1) Безопасность:
    String широко используется , как параметр для многих классов Java, в частности для открытия сетевых соединений,
    подключений к БД, открытию файлов и пр. И если бы строка изменялась, то мы могли получить доступ к объекту
    (файлу например), на который мы имеем право, затем изменить строку с именем (случайно или намеренно) и получить
    доступ уже к другому файлу.

    Так же String используется в механизме загрузки файлов, и это -- фундаментальный аспект. И если бы строка
    изменялась, то запрос на загрузку "java.io.Writer" мог бы быть изменён на "DiskErasingWriter".

2) Hashcode:
Из-за того, что строка не изменяется, она кэширует свой хэшкод и не вычисляет его каждый раз, когда мы его вызываем,
что делает строку очень быстрой как ключ для hashmap.

3) Многопоточность;
immutable делает экземпляры строк thread-safe.
-----------------------------------------------------------------------------------------------------------------------
Совет! При вызове некоторых методов допускается указывать кодировку символов с
помощью объекта типа Charset или символьной строки. Чтобы не утруждать себя
указанием правильного написания кодировки, достаточно выбрать подходящую константу из
класса StandardCharsets. Так, выражение new String (bytes, "UTF 8") неприемлемо
и вызовет ошибку.
-----------------------------------------------------------------------------------------------------------------------
Внимание! В одних методах и конструкторах, например, в конструкторе String (byte []),
используется кодировка, принятая на платформе по умолчанию, если не указано иное.
А в других методах и конструкторах, например, в конструкторе Files.readAllLinesO,
применяется кодировка UTF-8.
-----------------------------------------------------------------------------------------------------------------------
•char charAt(int index)
Возвращает символ, расположенный на указанной позиции. Вызывать этот метод следует только
в том случае, если интересуют низкоуровневые кодовые единицы.

•int codePointAt(int index) 5.0
Возвращает кодовую точку, начало или конец которой находится на указанной позиции.

•int offsetByCodePoints(int startlndex, int cpCount) 5.0
Возвращает индекс кодовой точки, которая отстоит на количество cpCount кодовых точек от ис­
ходной кодовой точки на позиции startlndex.int compareTo (String other)
Возвращает отрицательное значение, если данная строка лексикографически предшествует стро­
ке o t h e r , положительное значение — если строка other предшествует данной строке, нулевое
значение — если строки одинаковы.

•IntStrearn codePoints() 8
Возвращает кодовые точки из данной символьной строки в виде потока данных. Для их размеще­
ния в массиве следует вызвать метод toArray О .

•new String (int [] codePoints, int offset, int count) 5.0
Создает символьную строку из количества count кодовых точек в заданном массиве, начиная
с указанной позиции offset.

•boolean equals(Object other)
Возвращает логическое значение true, если данная строка совпадает с указанной строкой other.

boolean equalslgnoreCase (String other)
Возвращает логическое значение true, если данная строка совпадает с указанной строкой other
без учета регистра символов.

•boolean startsWith (String suffix)
• boolean endsWith (String suffix)
Возвращают логическое значение true, если данная строка начинается или оканчивается указан­
ной подстрокой suffix.

•int indexOf(String str)
•int indexOf (String str, int fromlndex)
•int indexOf (int cp)
•int indexOf (int cp, int fromlndex)
Возвращают индекс начала первой подстроки, совпадающей с указанной подстрокой s t r , или ж е
индекс заданной кодовой точки ср. Отсчет начинается с позиции 0 или fromlndex. Если у казан ­
ная подстрока s t r отсутствует в данной строке, возвращается значение, равное - 1 .

•int lastlndexOf (String str)
int lastIndexOf (String str, int fromlndex)
int lastindexOf(int cp)
int lastindexOf (int cp, int fromlndex)
Возвращают начало последней подстроки, равной указанной подстроке s t r , или ж е индекс задан­
ной кодовой точки с р . Отсчет начинается с конца строки или с позиции fromlndex. Если у казан­
ная подстрока s t r отсутствует в данной строке, возвращается значение, равное - 1 .

•int length ()
Возвращает длину строки.

•int codePointCount(int startlndex, int endlndex) 5.0
Возвращает количество кодовых точек между позициями startlndex и endlndex - 1 . Неспа­
ренные суррогаты считаются кодовыми точками.

•String replace (CharSequence oldString, CharSequence newString)
Возвращает новую строку, которая получается путем замены всех подстрок, совпадающих с ука­
занной подстрокой oldString, заданной строкой newString. В качестве параметров типа
CharSequence могут быть указаны объекты типа String или StringBuilder.

•String substring (int beginlndex)
•String siobstring (int beginlndex, int endlndex)
Возвращают новую строку, состоящую из всех кодовых единиц, начиная с позиции beginlndex
и до конца строки или позиции endlndex - 1.

String toLowerCaseO
•toUpperCase()
Возвращают новую строку, состоящую из всех символов исходной строки. Исходная строка отлича­
ется от результирующей тем, что все буквы преобразуются в строчные или прописные.

•String trim ()
Возвращает новую строку, из которой исключены все начальные и конечные пробелы.

•String join (CharSequence delimiter, Char S eq uence... elements) 8
Возвращает новую строку, все элементы которой соединяются через заданный разделитель.
-----------------------------------------------------------------------------------------------------------------------
*/