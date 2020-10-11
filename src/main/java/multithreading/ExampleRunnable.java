package multithreading;

public class ExampleRunnable {

    public static void main(String[] args) {

    }

}

/*
-----------------------------------------------------------------------------------------------------------------------
Поток исполнения прерывается, когда его метод run () возвращает управление, выполнив оператор return вслед за последним 
оператором в своем теле, или в том случае, если возникает исклю чение, которое не перехватывается в данном методе. В
первоначальной версии Java также присутствовал метод stop(), который мог быть вызван из другого потока исполнения, чтобы 
прервать исполнение данного потока. Но теперь этот метод не рекомендуется к применению.
-----------------------------------------------------------------------------------------------------------------------
ВНИМАНИЕ! Не вызывайте метод run() из класса Thread или объекта типа Runnable. При пря­мом вызове этого метода задача 
будет просто выполнена в том ж е потоке, а новый поток исполне­ния не будет запущен. Вместо этого вызывайте метод 
Thread.start(). Он создаст новый поток, где будет выполнен метод run().
-----------------------------------------------------------------------------------------------------------------------
•void run()
Этот метод следует переопределить и ввести в него инструкции для исполнения требуемой задачи
в потоке.
-----------------------------------------------------------------------------------------------------------------------
*/