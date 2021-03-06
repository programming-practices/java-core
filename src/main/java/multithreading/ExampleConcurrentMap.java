package multithreading;

public class ExampleConcurrentMap {

    public static void main(String[] args) {

    }

}

/*
---------------------------------------------------------------------------------------------------------------------
Хеш-отображение параллельного действия способно эффективно поддерживать
большое количество читающих потоков и фиксированное количество записывающих
потоков. По умолчанию допускается до 16 параллельно действующих записывающих
потоков. Таких потоков исполнения может быть намного больше, но если запись од­
новременно выполняется в более чем 16 потоках, то остальные временно блокиру­
ются. В конструкторе такой коллекции можно, конечно, указать большее количество
потоков исполнения, но вряд ли это вообще понадобится.
---------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Все записи с одним и тем ж е хеш-кодом хранятся в хеш-отображении в одной и той
ж е "группе" . В некоторых приложениях применяются неудачные хеш-функции, и в результате все
записи оказываются в небольшом количестве групп, что значительно снижает производительность.
И даже применение таких, в общем, подходящих хеш-функций может оказаться проблематичным.
Например, взломщик может замедлить выполнение программы, состряпав огромное количество
символьных а р о к с одинаковым хеш-значением. Но начиная с версии Java SE 8, группы в парал­
лельном хеш -отображении организуются в виде деревьев, а не списков, когда тип ключа реализует
интерфейс Comparable, гарантирующий производительность порядка Ollog(n)).
---------------------------------------------------------------------------------------------------------------------
*/
