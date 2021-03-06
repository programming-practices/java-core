package Examples.Multithreading;

public class ExampleLock {

}

/*
------------------------------------------------------------------------------------------------------------------------------
Метод lock() не может быть прерван. Если поток исполнения прерван во время
ожидания захвата блокировки, прерванный поток остается заблокированным до тех
пор, пока доступна блокировка. Если же возникнет взаимная блокировка, метод
lock() вообще не завершится.
------------------------------------------------------------------------------------------------------------------------------
Но если вызвать метод tryLock () с указанием времени ожидания в качестве пара­
метра, то при попытке прервать поток исполнения, находящийся в состоянии ожида­
ния, будет сгенерировано исклю чение типа InterruptedException. Это, безусловно,
полезное средство, поскольку оно дает возмож ность снимать взаимные блокировки
в программе.
------------------------------------------------------------------------------------------------------------------------------
Кроме того, можно вызвать метод locklnterruptibly ( ) . У него то же самое на­
значение, что и у метода tryLock ( ) , но только с бесконечным временем ожидания.
------------------------------------------------------------------------------------------------------------------------------
Когда же ожидается выполнение некоторого условия, то и в этом случае мож­
но указать время ожидания, как показано ниже. Метод await () возвращает управ­
ление, если другой поток исполнения активизирует данный поток вызовом метода
signalAll () или signal О, по истечении времени ожидания или в связи с тем, что
поток был прерван.
myCondition.await(100, TimeUnit.MILLISECONDS))
Метод await () генерирует исключение типа InterruptedException, если ож ида­
ющий поток исполнения прерывается. А в том (скорее маловероятном) случае, когда
требуется продолжить ожидание, можно вызвать метод awaitUninterruptibly ( ) .
------------------------------------------------------------------------------------------------------------------------------
•void lock()
	Захватывает блокировку. Если же в данный момент она захвачена другим потоком, текущий поток блокируется.

•void unlock ()
	Снимает блокировку.
	
•Condition newCondition()
	Возвращает объект условия, связанный с данной блокировкой.
	
•boolean tryLock()
	Пытается захватить блокировку без блокирования. Возвращает логическое значение true при
	удачном исходе. Этот метод захватывает блокировку, если она доступна, даже при условии, что
	соблюдается правило равноправного блокирования и ожидания в других потоках исполнения.
	
•boolean tryLock (long time, TimeUnit unit)
	Пытается захватить блокировку, но блокируя не дольше заданного времени. Возвращает логиче­
	ское значение true при удачном исходе.
	
•void locklnterruptibly()
	Захватывает блокировку, но блокируя на неопределенное время. Если поток исполнения прерыва­
	ется, генерирует исключение типа InterruptedException.
------------------------------------------------------------------------------------------------------------------------------
*/
