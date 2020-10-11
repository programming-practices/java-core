package Examples.Reflection_API;

public class ExampleProxy {
}

/*
----------------------------------------------------------------------------------------------------------------------
•static Class getProxyClass (ClassLoader loader, Class[] inte rface s)
    Возвращает прокси-класс, реализующий заданные интерфейсы.

•static Object newProxylnstance (ClassLoader loader, Class [] interfaces, InvocationHandler handler)
    Создает новый экземпляр прокси-класса, реализующего заданные интерфейсы. Во всех методах
    вызывается метод invoke() для объекта, указанного в качестве обработчика вызовов.

•static boolean isProxyClass(Class cl)
    Возвращает логическое значение true, если параметр c l оказывается прокси-классом.
----------------------------------------------------------------------------------------------------------------------
*/