package multithreading;

public class ExampleTransferQueue {
    public static void main(String[] args) {

    }

}

/*
----------------------------------------------------------------------------------------------------------------
•void transfer (E element)
•boolean tryTransfer (E element, long time, TimeUnit unit)
	Передают значение или пытаются передать его в течение заданного времени ожидания, устанав­
	ливая, если требуется, блокировку до тех пор, пока элемент не будет удален из очереди в другом
	потоке исполнения. Второй метод возвращает логическое значение true при удачном исходе.
----------------------------------------------------------------------------------------------------------------
*/
