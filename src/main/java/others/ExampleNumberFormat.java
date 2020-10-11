package others;

import java.text.NumberFormat;

public class ExampleNumberFormat {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        double x = 0.1;
        System.out.println(currencyFormatter.format(x)); // выводит $0.10
        System.out.println(percentFormatter.format(x)); // выводит 10%
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
•Number parse(String s)
    Возвращает числовое значение, полученное в результате синтаксического анализа параметра.Предполагается, что объект
    типа String содержит символьную строку, представляющую числовое значение.
----------------------------------------------------------------------------------------------------------------------
*/


