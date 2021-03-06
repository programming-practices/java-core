package exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExampleTryCatch {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        System.out.println("Start");
        try {
            InputStream in = new FileInputStream("hhhh");
            System.out.println("Try Entre!!!");
            // код, способный генерировать исключения
            System.out.println("Try Exit!!!");
        } catch (IOException е) {
            System.out.println("Catch Enter!!!");
            if (true) throw new RuntimeException();
            // вывести сообщение об ошибке
            System.out.println("Catch Exit!!!");
        } finally {
            System.out.println("Finally Enter!!!");
//            in.close();
            System.out.println("Finally Exit!!!");
        }
        System.out.println(6);
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Рассмотрим три возможных ситуации, в которых программа выполняет блок finally.
    1. Код не генерирует никаких исключений. В этом случае программа сначала
        полностью выполняет блок try, а затем блок finally. Иными словами, выпол­
        нение программы последовательно проходит через точки 1, 2, 5 и 6.
    2. Код генерирует исключение, которое перехватывается в блоке catch (в дан­
        ном примере это исключение типа IOException). В этом случае программа
        сначала выполняет блок try до той точки, в которой возникает исключение,
        а остальная часть блока try пропускается. Затем программа выполняет код из
        соответствующего блока catch и, наконец, код из блока finally.
       Если в блоке catch исключения не генерируются, то выполнение программы
        продолжается с первой строки, следующей после блока try. Таким образом,
        выполнение программы последовательно проходит через точки 1, 3, 4, 5 и 6.
        Если же исключение генерируется в блоке catch, то управление передается вы­
        зывающей части программы и выполнение программы проходит только через точки1,3и5.
    3. Код генерирует исключение, которое не обрабатывается в блоке catch. В этом
        случае программа выполняет блок try вплоть до той точки, в которой гене­
        рируется исключение, а оставшаяся часть блока try пропускается. Затем про­
        грамма выполняет код из блока finally и передает исключение обратно вызы­
        вающей части программы. Таким образом, выполнение программы проходит
        только через точки 1 и 5.
----------------------------------------------------------------------------------------------------------------------
Как рекомендуется ниже, конструкцию finally на самом деле следует применять всякий раз, когда требуется освободить
используемый ресурс.
СОВЕТ. Настоятельно рекомендуется разделять блоки операторов try/catch и try/finally.
В этом случае код программы становится более понятным. Рассмотрим следующий пример кода:
        InputStream in =
        ...;
        try{
            try{
                код, способный генерировать исключения
            }finally{
                in.close();
            }
        }catch (IOException e){
            вывести сообщение об ошибке
        }

Здесь внутренний блок try отвечает только за закрытие потока ввода, а внешний блок try сообщает об ошибках. Такой код не
только более понятен, но и более функционален, поскольку ошибки выявляются и в блоке finally.
----------------------------------------------------------------------------------------------------------------------
В приведенном ниже фрагменте кода показано, каким образом перехватывается и повторно генерируется исключение.
        try{
                получить доступ к базе данных
        }catch (SQLException е){
                throw new ServletException("database error: " + e .getMessage());
        }
В данном случае текст сообщения об исключении формируется в конструкторе класса ServletException. Но предыдущее исключение
лучше сделать причиной, т.е. источником последующего исключения, как показано ниже.
        try{
                получить доступ к базе данных
        }catch (SQLException е){
                Throwable se = new ServletException("database error");
                se.initCause(e);
                throw se;
        }
Теперь при перехвате последующего исключения предыдущее исключение можно извлечь следующим образом:
        Throwable е = se.getCause();
Настоятельно рекомендуется именно такой способ заключения исключений в оболочку. Ведь он позволяет генерировать исключения
более высокого уровня, не теряя подробных сведений об исходном исключении.

СОВЕТ. Рассмотренный выше способ заклю чения в оболочку оказывается удобным в том случае, если перехват исключения
осуществляется в методе, которому не разрешается генерировать проверяемые исключения. Проверяемое исключение можно
перехватить и заключить его в оболочку исключения времени выполнения.

Иногда требуется зарегисгрировать исключение и сгенерировать его повторно без всяких изменений:
        try{
                получить доступ к базе данных
        }catch (Exception е){
                logger.log(level, message, e );
                throw e;
        }
----------------------------------------------------------------------------------------------------------------------
*/
