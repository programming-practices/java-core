package oop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * This program demonstrates the use of proxies.
 *
 * @author Cay Horstmann
 * @version 1.00 2000-04-13
 */
public class ExampleDynamicProxy {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        /*Остается решить еще два вопроса: как определить обработчик и что можно сделать с полученным в итоге
        прокси-объектом? Разумеется, ответы на эти вопросы зависят от конкретной задачи, которую требуется решить с
        помощью механизма прокси-объектов. В частности, их можно применять для достижения следующих целей.
                • Переадресация вызовов методов на удаленный сервер.
                • Связывание событий, происходящих в пользовательском интерфейсе, с определен ными действиями, выполняемыми в программе.
                • Отслеживание вызовов методов при отладке.*/
//        Object[] elements = new Object[1000];

        // fill elements with proxies for the integers 1 ... 1000
//        for (int i = 0; i < elements.length; i++) {
//            Integer value = i + 1;
//            InvocationHandler handler = new TraceHandler(value);
            /*Для создания прокси-объекта служит метод newProxyInstance() из класса Proxy.
              Этот метод получает следующие три параметра.
                  • Загрузчик классов. Модель безопасности в Java позволяет использовать загрузчики разных классов, в
                    том числе системных классов, загружаемых из Интернета, и т.д. Загрузчики классов обсуждаются в главе
                    9 второго тома настоящего издания. А до тех пор в приведенных далее примерах кода будет указываться пу­
                    стое значение null, чтобы использовать загрузчик классов, предусмотренный по умолчанию.
                  • Массив объектов типа Class — по одному на каждый реализуемый интерфейс.
                  • Обработчик вызовов.*/
//            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
//            elements[i] = proxy;
//        }

        // construct a random integer
//        Integer key = new Random().nextInt(elements.length) + 1;

        // search for the key
//        int result = Arrays.binarySearch(elements, key);

        // print match if found
//        if (result >= 0) System.out.println(elements[result]);
//--------------------------------------------------------------------------------------------------------------------
//        InvocationHandler handler = new MyProxy(4);
//        Class[] classes = new Class[]{Comparable.class, Callable.class};
//        Object proxy = Proxy.newProxyInstance(null, classes, handler);
//        System.out.println(proxy.getClass());
//        System.out.println(proxy.toString());
////        System.out.println(((Comparable) proxy).compareTo(5));

//--------------------------------------------------------------------------------------------------------------------
        List<String> list = (List<String>) Proxy.newProxyInstance(
                null,
                new Class[]{List.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        switch (method.getName()) {
                            case "add":
                                return true;
                            case "get":
                                return "Hello from prozy!";
                            case "size":
                                return -42;
                            case "iterator":
                                return null;
                            default:
                                throw new UnsupportedOperationException();
                        }
                    }
                }
        );
        System.out.println(list.add("A"));
        System.out.println(list.get(-1));
        System.out.println(list.size());
        System.out.println(list.iterator());

//        System.out.println(list.getClass().getName());

//--------------------------------------------------------------------------------------------------------------------
    }

    static class MyProxy implements InvocationHandler {
        private Object target;

        public MyProxy(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            System.out.println(args.toString());
            return method.invoke(target, args);
        }
    }
}

/**
 * An invocation handler that prints out the method name and parameters, then
 * invokes the original method
 */
class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * Constructs a TraceHandler
     *
     * @param t the implicit parameter of the method call
     */
    public TraceHandler(Object t) {
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        // print implicit argument
        System.out.print(target);
        // print method name
        System.out.print("." + m.getName() + "(");
        // print explicit arguments
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");

        // invoke actual method
        return m.invoke(target, args);
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
В последнем разделе этой главы мы обсудим понятие прокси-классов, которые зачастую называют классами-посредниками. Они
предназначены для того, что бы создавать во время выполнения программы новые классы, реализующие заданные интерфейсы.
Прокси-классы требуются, если на стадии компиляции еще неизвестно, какие именно интерфейсы следует реализовать. В
прикладном программировании такая ситуация возникает крайне редко. Но в некоторых приложениях системного программирования
гибкость, обеспечиваемая прокси-классами, может оказаться весьма уместной.
-----------------------------------------------------------------------------------------------------------------------
И в завершение главы будут представлены прокси-классы, реализующие произ­вольные интерфейсы. Прокси-классы представляют
собой весьма специфические конструкции, полезные для создания инструментальных средств системного программирования.
-----------------------------------------------------------------------------------------------------------------------
*/
