package Examples.Reflection_API;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * This program uses reflection to spy on objects.
 *
 * @author Cay Horstmann
 * @version 1.12 2012-01-26
 */
public class ExampleReflectionObjectAnalyzer_CayHorstmann {
    public static void main(String[] args) {
        /*  В примере кода из листинга 5.14 показано, каким образом создается обобщенный метод toString(), пригодный для
        любого класса. Сначала в нем вызывается метод getDeclaredFields() для получения всех полей, а затем метод
        setAccessible(), делающий все эти поля доступными. Далее определяется имя и значение каждого поля. Кроме того,
        в листинге 5.14 демонстрируется способ преобразования значений в символьные строки путем рекурсивного вызова
        метода toString(), как показанониже.
            В методе toString() необходимо разрешить некоторые затруднения. В частно­сти, циклически повторяющиеся ссылки
        могут привести к бесконечной рекурсии. Следовательно, объект типа ObjectAnalyzer (из листинга 5.15) должен
        отслеживать объекты, которые уже были проанализированы. Кроме того, для просмотра массивов необходим другой
        подход, который более подробно будет рассмотрен в следующем разделе.
            Итак, для просмотра содержимого любого объекта можно воспользоваться мето­
        дом toString(). Так, в результате выполнения следующего фрагмента кода:*/
        ArrayList<Integer> squares = new ArrayList<>();

        for (int i = 1; i <= 5; i++) squares.add(i * i);

        System.out.println(new ObjectAnalyzer().toString(squares));

        /*Используя такой обобщенный метод toString ( ) , можно реализовать конкретные методы toStringO в собственных
        классах. Это можно сделать, например, следую­щим образом:
                            public String toString(){
                                    return new ObjectAnalyzer().toString(this);
                            }
        Такое применение метода toString () оказывается полезным при разработке соб­ственных программ.*/
    }
}

class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * Converts an object to a string representation that lists all fields.
     *
     * @param obj an object
     * @return a string with the object's class name and all field names and
     * values
     */
    public String toString(Object obj) {
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj;
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        // inspect the fields of this class and all superclasses
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);

        return r;
    }
}
