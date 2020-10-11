package java_util;

import java.util.Currency;
import java.util.Locale;

public class ExampleCurrency {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // Demonstrate Currency.
        Currency currency = Currency.getInstance(Locale.US);

        System.out.println("Symbol: " + currency.getSymbol());
        System.out.println("Default fractional digits: " + currency.getDefaultFractionDigits());
//--------------------------------------------------------------------------------------------------------------------
    }
}


/*
----------------------------------------------------------------------------------------------------------------------
Класс Currency и нкап сулирует сведения о денежной единице. В этом классе кон­структоры не определя юrся .
----------------------------------------------------------------------------------------------------------------------
*/