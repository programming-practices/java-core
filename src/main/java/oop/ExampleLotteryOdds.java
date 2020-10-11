package Examples.OOP;

import java.util.Scanner;

/**
 * This program demonstrates a <code>for</code> loop.
 *
 * @author Cay Horstmann
 * @version 1.20 2004-02-10
 */
public class ExampleLotteryOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        /*
         * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
         */

        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++)
            lotteryOdds = lotteryOdds * (n - i + 1) / i;

        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Типичный пример применения оператора цикла fArgInt o r непосредственно в коде
приведен в листинге 3.5. Данная программа вычисляет вероятность выигрыша в лоте­
рее. Так, если нужно угадать б номеров из 50, количество возмож ных вариантов будет
равно (50x49x48x47x46x45)/ (1х2хЗх4х5хб), поэтому шансы на выигрыш равны 1
из 15890700. Желаем удачи! Вообще говоря, если требуется угадать к номеров из п,
количество возможных вариантов определяется следующей формулой:
                        n*(n-1)*(k- 2)*...(k- k+1)
                                Ix2x3x4....*k
----------------------------------------------------------------------------------------------------------------------
*/
