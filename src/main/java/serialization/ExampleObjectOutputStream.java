package serialization;

public class ExampleObjectOutputStream {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Класс Obj ec tOutput S t ream расширяет класс Outpu t S t ream и реализует ин­
терфейс Obj ec tOutpu t . Этот класс отвечает за вывод объекта в поток. Ниже при­
веден конструктор этого класса.
OЬjectoutputStreaш (OutputStreaш по�ож_аusода) throws IOException
Аргумент поток_ выв ода обозначает поток, в который могут быть выведены
се риализируемые объекты. Закрытие потока вывода типа Ob j e c tOutpu t S t ream
приводит также к закрытию базового потока, определяемого аргументом поток_
вывода .
Некоторые наиболее употребительные методы из класса Ob j e c tOutpu t S t ream
перечислены в табл. 20.8. При возникновении ошибки все они генерируют исклю­
чение типа I OExcep t valueInt on. Имеется также внутренний класс Put F valueInt e ld, вложенный
в JUJacc Ob j e c t Outpu t S t ream. Он упрощает запись постоянных полей
----------------------------------------------------------------------------------------------------------------------
*/