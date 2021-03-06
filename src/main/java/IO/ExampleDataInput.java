package IO;

public class ExampleDataInput {

}


/*
-----------------------------------------------------------------------------------------------------------------------
• boolean readBoolean()
• byte readByte()
• char readChar()
• double readDouble()
• float readFloat()
• int readlnt()
• long readLong()
• short readShort()
    Считывают значение заданного типа.

• void readFully (byte [ ] b)
    Считывает байты в массив Ъ, устанавливая блокировку до тех пор, пока не будут считаны все байты.
        Параметры: Ъ            Массив, в который должны быть считаны байты

• void readFully (byte[] b, int off, int len)
    Считывает байты в массив Ь, устанавливая блокировку до тех пор, пока не будут считаны все байты.
        Параметры:  b           Массив, в который должны быть считаны байты
                    off         Начальное смещение данных
                    len         Максимальное количество считываемых байтов

• String readUTF()
    Считывает символьную строку в “модифицированном” формате UTF-8.

• int skipBytes (int n)
    Пропускает л байтов, устанавливая блокировку до тех пор, пока не будут пропущены все необходимые байты.
        Параметры: n           Количество пропускаемых байтов
-----------------------------------------------------------------------------------------------------------------------
*/