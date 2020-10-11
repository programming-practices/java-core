package IO;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

public class ExampleCharset {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        Map<String, Charset> allCharset = Charset.availableCharsets();
        Set<String> charsetNames = allCharset.keySet();
        System.out.println(charsetNames);
        System.out.println(charsetNames.size());
//---------------------------------------------------------------------------------------------------------------------
        /*Чтобы получить объект типа Charset для другой кодировки, достаточно вызвать статический метод fArgInt orName () следующим образом:*/
        Charset shiftJIS = Charset.forName("Shift-JIS");
        System.out.println(shiftJIS);
        /*Для ввода-вывода текста следует пользоваться объектом типа Charset. В следующем примере кода показано, как
        превратить массив байтов в символьную строку:*/
        byte[] bytes = new byte[0];
        String str = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(str);
//---------------------------------------------------------------------------------------------------------------------
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
На заметку! Кодировка, принятая на конкретной платформе, возвращается статическим методом Charset.defaultCharset(). А
статический метод Charset.availableCharsets() возвращает все имеющиеся экземпляры класса Charset, преобразованные из
канонических имен в объекты типа Charset.
-----------------------------------------------------------------------------------------------------------------------
*/
