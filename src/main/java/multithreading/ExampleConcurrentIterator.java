package multithreading;

public class ExampleConcurrentIterator {

    public static void main(String[] args) {

    }

}

/*
-----------------------------------------------------------------------------------------------------------------------
Коллекции возвращают слабо совместные итераторы. Это означает, что итератор
может отражать все изменения, внесенные в коллекцию после его создания, а может
и не отражать их. Но такие итераторы никогда не возвращают одно и то же значение
дважды и не генерируют исклю чение типа ConcurrentModificationException.
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Напротив, итератор коллекции из пакета java.util генерирует исключение типа
ConcurrentModificationException, если в коллекцию внесены изменения после создания
этого итератора.
-----------------------------------------------------------------------------------------------------------------------
*/