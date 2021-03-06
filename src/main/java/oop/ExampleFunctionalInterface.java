package oop;

@FunctionalInterface
interface MyNumber {
    double getValue();
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}


public class ExampleFunctionalInterface {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------

        MyNumber myNumber;
        myNumber = () -> 123.45;
        System.out.println(myNumber.getValue());

//---------------------------------------------------------------------------------------------------------------------

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

//---------------------------------------------------------------------------------------------------------------------
    }
}
/*
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! У вас может возникнуть резонный вопрос: почему функциональный интерфейс дол­
жен иметь единственный абстрактный метод?Разве все методы в интерфейсе не являются аб­
страктными? На самом деле в интерфейсах всегда имелась возможность повторно объявить такие
методы из класса Object, как toString() или clone(), не делая их абстрактными. (В некото­
рых интерфейсах из прикладного программного интерфейса Java API методы из класса Object
объявляются повторно с целью присоединить к ним документирующие комментарии, составляемые
с помощью утилиты javadoc. Характерным тому примером служит интерфейс Comparator.) Но
важнее другое: в версии Java SE 8 допускается объявлять интерфейсные методы неабстрактными,
как было показано ранее, в разделе 6.1 .5 .
----------------------------------------------------------------------------------------------------------------------
*/