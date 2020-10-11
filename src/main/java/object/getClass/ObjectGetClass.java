package object.getClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectGetClass {
    public static void main(String[] args) {

        ArrayList<String> arrayListString = new ArrayList<>();
        ArrayList<Integer> arrayListInteger = new ArrayList<>();

        System.out.println(arrayListString.getClass() == arrayListInteger.getClass());
        System.out.println(arrayListString.equals(arrayListInteger));
        System.out.println();

        List<Integer> arrayListInteger1 = Arrays.asList(1, 2, 3);
        List<String> arrayListString1 = Arrays.asList("q", "e");

        System.out.println(arrayListString1.getClass() == arrayListInteger1.getClass());
        System.out.println(arrayListString1.equals(arrayListInteger1));

        System.out.println("--------------------------");
        System.out.println(arrayListInteger.getClass());
        System.out.println(arrayListInteger.getClass().getName());
        System.out.println(arrayListInteger.getClass().getSimpleName());
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
•Class getClass()
    Возвращает класс объекта, содержащий сведения об объекте. Как будет показано далее в этой
    главе, в Java поддерживается динамическое представление классов, инкапсулированное в классе Class.
----------------------------------------------------------------------------------------------------------------------
*/
