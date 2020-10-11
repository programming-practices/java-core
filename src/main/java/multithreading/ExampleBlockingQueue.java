package Examples.Multithreading;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Cay Horstmann
 * @version 1.02 2015-06-21
 */
public class ExampleBlockingQueue {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter base directory (e.g. /opt/jdk1.8.0/src): ");
            String directory = in.nextLine();
            System.out.print("Enter keyword (e.g. volatile): ");
            String keyword = in.nextLine();

            Runnable enumerator = () -> {
                try {
                    enumerate(new File(directory));
					/*Чтобы прекратить выполнение данной программы, когда
					никакой другой обработки файлов больше не требуется, применяется специальный
					прием: из перечисляющего потока в очередь вводится фиктивный объект, чтобы у ве­
					домить о завершении потока. (Это похоже на муляж чемодана с надписью "послед­
					ний чемодан" на ленточном транспортере в зале выдачи багажа.) Когда поисковый
					поток получает такой объект, он возвращает его обратно и завершается.*/
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                }
            };

            new Thread(enumerator).start();
            for (int i = 1; i <= SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else
                                search(file, keyword);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    /**
     * Recursively enumerates all files in a given directory and its subdirectories.
     *
     * @param directory the directory in which to start
     */
    public static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                enumerate(file);
            else
                queue.put(file);
        }
    }

    /**
     * Searches a file for a given keyword and prints all matching lines.
     *
     * @param file    the file to search
     * @param keyword the keyword to search for
     */
    public static void search(File file, String keyword) throws IOException {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword))
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
            }
        }
    }
}

/*
-----------------------------------------------------------------------------------------------------------------
Блокирующая очередь вынуждает поток исполнения блокироваться при попытке
ввести элемент в переполненную очередь или удалить элемент из пустой очереди.
Блокирующие очереди — удобное инструментальное средство для координации
работы многих потоков исполнения. Одни рабочие потоки могут периодически
размещать промежуточные результаты в блокирующей очереди, а другие рабочие
потоки — удалять промежуточные результаты и видоизменять их далее. Методы
для организации блокирующих очередей перечислены в табл. 14.1.
Методы блокирующих очередей разделяются на три категории, в зависимости
от выполняемых действий, когда очередь заполнена или пуста. Для применения бло­
кирующей очереди в качестве инструментального средства управления потоками по­
надобятся методы put () и take (). Методы add (), remove () и element () генериру­
ют исключение при попытке ввести элемент в заполненную очередь или получить
элемент из головы пустой очереди. Разумеется, в многопоточной программе очередь
может заполниться или опустеть в лю бой момент, поэтому вместо этих методов, воз­
можно, потребуются методы offer (), poll () и peek (). Эти методы просто возвра­
щают признак сбоя вместо исключения, если они не могут выполнить свои функции.
-----------------------------------------------------------------------------------------------------------------
add()  			 Вводит элемент в очередь   					Генерирует исключение типа	
																IllegalStateException,еслиочередь заполнена
																
element() 		Возвращает элемент, находящийся					Генерирует исключение типа
				в голове очереди								NoSuchElementException, если очередь пуста
				
offer()			Вводит элемент в очередь и возвращает			Возвращает логическое значение fArgInt a l s e ,
				логическое значение t r u e						если очередь заполнена
				
peek()			Возвращает элемент, находящийся					Возвращает пустое значение n u l l ,
				в голове очереди								если очередь пуста
				
poll()			Возвращает элемент, находящийся					Возвращает пустое значение n u l l ,
				в голове очереди, удаляя его из очереди			если очередь пуста

put()			Вводит элемент в очередь						Блокирует, если очередь пуста

remove ()		Возвращает элемент, находящийся					Генерирует исключение типа
				в голове очереди, удаляя его из очереди			NoSuchElementException, если очередь пуста

take ()			Возвращает элемент, находящийся					Блокирует, если очередь пуста
				в голове очереди, удаляя его из очереди

•void put (E element)
	Вводит элемент в очередь, устанавливая, если требуется, блокировку.
	
•Е take ()
	Удаляет элемент из головы очереди и возвращает его, устанавливая, если требуется, блокировку.
	
•boolean offer(Е element, long time, TimeUnit unit)
	Вводит заданный элемент в очередь и возвращает логическое значение true при удачном исходе,
	устанавливая, если требуется, блокировку на время ввода элемента в очередь или до истечения
	времени ожидания.
	
•Е poll (long time, TimeUnit unit)
	Удаляет элемент из головы очереди и возвращает его, устанавливая, если требуется, блокировку
	до тех пор, пока элемент доступен, или ж е до тех пор, пока не истечет время ожидания. При неу­
	дачном исходе возвращает пустое значение null.
-----------------------------------------------------------------------------------------------------------------
*/