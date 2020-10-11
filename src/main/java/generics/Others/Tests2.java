package generics.Others;


import others.entities.*;

import java.util.*;

public class Tests2 {

    public static void method1(List list) {

    }

    public static void method2(List<?> list) {

    }

    public static <T> void method3(List<T> list) {

    }

    public static <T> void main(String[] args) {
        Map<Person, List<? extends Pet>> map = new HashMap<Person, List<? extends Pet>>();
        List<? extends Pet> list = Arrays.asList(new Cat(), new Rat(), new Dog());
        map.put(new Person("Quin"), list);

        Map<Person, List<Pet>> map2 = new HashMap<Person, List<Pet>>();
        List<Pet> list2 = Arrays.asList(new Cat(), new Rat(), new Dog());
        map2.put(new Person("Quin"), (List<Pet>) list);

        List list1 = new ArrayList();
        list1.add(new Integer(1));
        list1.add(new StringBuilder("w"));
        list1.add(new Boolean(true));

        List list3 = new ArrayList();
        List<Integer> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList<>();

        method1(list3);
        method1(list4);
        method1(list5);

        method2(list3);
        method2(list4);
        method2(list5);

        method3(list3);
        method3(list4);
        method3(list5);


//        List<T> list33 = new ArrayList<T>();
//        list33.add(new Integer(2));
//        list33.add(3);

    }

    public <T, S, U> U nameCreate(T t, S s) {
        return null;
    }
}
