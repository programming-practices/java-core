package generics.kompensacia_sterania;

import java.util.HashMap;
import java.util.Map;


public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String, Class<?>> map = new HashMap<String, Class<?>>();

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public static void main(String[] args) {

        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);

        System.out.println(ctt1.f(new Building()));

        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);

        System.out.println(ctt2.f(new Building()));

        System.out.println(ctt2.f(new House()));

        ctt1.addType("Building", Building.class);
        ctt1.addType("House", House.class);

        try {
            Class<?> bb = ctt1.createNew("Building");
            Class<?> bb2 = ctt1.createNew("House");
            System.out.println(bb.getName());
            System.out.println(bb2.getName());
            Class<?> bb23 = ctt1.createNew("Hous");
        } catch (ClassNotFoundException e) {
            System.out.println();
        }


    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typeName, Class<?> kind) {
        map.put(typeName, kind);
    }

    public Class<?> createNew(String typeName) throws ClassNotFoundException {

        if (map.containsKey(typeName)) {
            return map.get(typeName);
        } else {
            throw new ClassNotFoundException();
        }

    }
}
