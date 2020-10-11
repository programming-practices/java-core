package exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExampleMultiCatch {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        try {
            File file = new File("temp.txt");
            FileInputStream fin = new FileInputStream(file);
            Connection connection = DriverManager.getConnection("", "", "");
            /*К такому способу перехвата исключений следует прибегать лишь в тех случаях, когда перехватываемые исключения
            не являются подклассами друг для друга.
              НА ЗАМЕТКУ! При перехвате нескольких исключений переменная исключения неявно считается конечной (final).
            Например, переменной е нельзя присвоить другое значение в следующем блоке:
                                    catch (FileNotFoundException | UnknownHostException е) { ... }
              НА ЗАМЕТКУ! Перехват нескольких исключений не делает код ни проще, ни эффективнее. Формируемые в итоге
              байт-коды содержат единственный блок общего оператора catch.*/
        } catch (FileNotFoundException | SQLException e) {
            System.out.println(e.toString());
//            e = new SQLException();
        } catch (IOException exception) {
        }
//---------------------------------------------------------------------------------------------------------------------
        // Demonstrate JDK 7's multi-catch feature.
        int age = 10, b = 0;
        int vals[] = {1, 2, 3};

        try {
//            int result = age / b; // generate an ArithmeticException

            vals[10] = 19; // generate an ArrayIndexOutOfBoundsException

            // This catch clause catches both exceptions.
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }

        System.out.println("After multi-catch.");
//---------------------------------------------------------------------------------------------------------------------
    }
}
