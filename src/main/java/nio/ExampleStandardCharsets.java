package nio;

public class ExampleStandardCharsets {
    public static void main(String[] args) {

    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Совет! При вызове некоторых методов допускается указывать кодировку символов с
помощью объекта типа Charset или символьной строки. Чтобы не утруждать себя
указанием правильного написания кодировки, достаточно выбрать подходящую константу из
класса StandardCharsets. Так, выражение new String (bytes, "UTF 8") неприемлемо
и вызовет ошибку.
----------------------------------------------------------------------------------------------------------------------
*/