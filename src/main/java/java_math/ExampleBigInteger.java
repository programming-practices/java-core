package java_math;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * This program uses big numbers to compute the odds of winning the grand prize in a lottery.
 *
 * @author Cay Horstmann
 * @version 1.20 2004-02-10
 */
public class ExampleBigInteger {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        /*
         * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
         */

        BigInteger lotteryOdds = BigInteger.valueOf(1);

        for (int i = 1; i <= k; i++)
            // lotteryOdds = lottery *(n-i+1)/i;
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));

        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
//---------------------------------------------------------------------------------------------------------------------
    }
}


/*
----------------------------------------------------------------------------------------------------------------------
Biglnteger subtract(Biglnteger other)
Biglnteger multiply(Biglnteger other)
Biglnteger divide(Biglnteger other)
Biglnteger mod(Biglnteger other)
        Возвращают сумму, разность, произведение, частное и остаток от деления, полученные в результате
        выполнения соответствующих операций над текущим большим числом и значением параметра other.

int compareTo (Biglnteger other)
        Возвращает 0, если текущее большое число равно значению параметра other, отрицательное чис­
        ло, если это большое число меньше значения параметра other, а иначе — положительное число.


static Biglnteger valueOf(long х)
        Возвращает большое число, равное значению параметра х.

BigDecimal add (BigDecimal other)
BigDecimal subtract (BigDecimal other)
BigDecimal multiply (BigDecimal other)
BigDecimal divide (BigDecimal other, int roundlngMode) 5.0
        Возвращают сумму, разность, произведение и частное от деления, полученные в результате со­
        ответствующих операций над текущим большим числом и значением параметра other. Чтобы
        вычислить частное от деления, следует указать режим округления. Так, режим r oundingMode.
        round_hal fArgInt _ u p означает округление в сторону уменьшения для цифр 0-4 и в сторону увеличе­
        ния для цифр 5 -9 . Для обычных вычислений этого оказывается достаточно. Другие режимы окру­
        гления описаны в документации.

int compareTo(BigDecimal other)
        Возвращает 0, если текущее число типа BigDecimal равно значению параметра other, отрица­
        тельное число, если это число меньше значения параметра other, а иначе — положительное число.

static BigDecimal valueOf(long х)
static BigDecimal valueOf(long x, int scale)
        Возвращают большое десятичное число, значение которого равно значению параметра х или х / 105са1е.
----------------------------------------------------------------------------------------------------------------------
*/