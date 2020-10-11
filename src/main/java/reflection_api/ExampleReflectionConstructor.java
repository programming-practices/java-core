package reflection_api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ExampleReflectionConstructor {
    public static void main(String[] args) throws NoSuchMethodException {
        MyClassForTests myClassForTests = new MyClassForTests();

        Class c = myClassForTests.getClass();

        Constructor[] constructors = c.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println("Constructor number: " + i);
            Class[] parameterTypes = constructors[i].getParameterTypes();
            for (Class cl : parameterTypes) {
                System.out.println(cl.getName());
            }
        }

        Constructor constructor = c.getConstructor(String.class, String.class, String.class, String.class);
        System.out.println(constructor.toString());
        System.out.println(constructor.getName());

        try {
            Object o = constructor.newInstance("q", "w", "e", "r");
            if (o instanceof MyClassForTests) {
                MyClassForTests myC = (MyClassForTests) o;
                System.out.println(myC);
                System.out.println("Ouhhh eeee");
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Если при создании объекта по имени класса требуется передать конструктору каки ­е-нибудь параметры, то
использовать приведенные выше операторы нельзя. Вместо этого следует вызвать метод newlnstance() из класса Constructor.
-----------------------------------------------------------------------------------------------------------------------
•Object newlnstance (Object [] args)
    Создает новый экземпляр класса.
        Параметры: args  Параметры, передаваемые конструктору.

•Class getDeclaringClass()
    Возвращает объект типа Class, соответствующий классу, в котором определен заданный конструк­
    тор, метод или поле.

•Class [ ] getExceptionTypes () (в классах Constructor и Method)
    Возвращает массив объектов типа Class, представляющих типы исключений, генерируемых за ­
    данным методом.

•int getModifiers ()
    Возвращает целое значение, соответствующее модификатору заданного конструктора, метода или
    поля. Для анализа возвращаемого значения следует использовать методы из класса Modifier.

•String getName()
    Возвращает символьную строку, в которой содержится имя конструктора, метода или поля.

•Class[] getParameterTypes () (в классах Constructor и Method)
    Возвращает массив объектов типа Class, представляющих типы параметров.

•Class getRetumType() (в классе Method)
    Возвращает объект тип Class, соответствующий возвращаемому типу.
-----------------------------------------------------------------------------------------------------------------------
*/
