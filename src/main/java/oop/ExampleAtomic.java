package oop;

public class ExampleAtomic {
}

/*
Какие типы данных в Java являются атомарными для операций чтения/записи с точки зрения многопоточности?

Атомарность означает выполнение операции целиком непрерывно (либо невыполнение ее вовсе).

В Java атомарными являются операции чтения/записи всех примитивных типов данных за исключением типов long и double,
поскольку эти типы данных занимают два машинных слова, и операции чтения/записи являются составными операциями из
двух атомарных операций над старшими и младшими битами числа соответственно. Однако операции над volatile long и
volatile double атомарны.

Операции над ссылками на объекты в Java являются всегда атомарными независимо от разрядности JVM и гарантируются JMM.
*/