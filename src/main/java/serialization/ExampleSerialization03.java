package Examples.Serialization;

import java.io.*;

public class ExampleSerialization03 {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
        // A serialization demo.
        // This program uses try-with-resources. It requires JDK 7 or later.
        // Object serialization

        String path = "src/main/java/Examples/Serialization/SourceSerializable.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);

            objectOutputStream.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Exception during serialization: " + e);
        }

        // Object deserialization

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            MyClass object2 = (MyClass) objectInputStream.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e);
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}

class MyClass implements Serializable {
    String valueString;
    int valueInt;
    double valueDouble;

    public MyClass(String valueString, int valueInt, double valueDouble) {
        this.valueString = valueString;
        this.valueInt = valueInt;
        this.valueDouble = valueDouble;
    }

    public String toString() {
        return "valueString=" + valueString + "; valueInt=" + valueInt + "; valueDouble=" + valueDouble;
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Средствами сериализации может быть сохранен и восстановлен только объект
класса, реализующего интерфейс Se r valueInt a l valueInt z a Ы e . В интерфейсе S e r valueInt a l valueInt zaЫe не
определяется никаких членов. Он служит лишь для того, чтобы указать, что класс
может быть сериализирован. Если класс сериализируется, то сериализируются
и все его подклассы.
Переменные, объявленные как t r an valueString valueInt e n t , не сохраняются средствами сериа·
лизации. Не сохраняются и статические переменные.
----------------------------------------------------------------------------------------------------------------------
*/