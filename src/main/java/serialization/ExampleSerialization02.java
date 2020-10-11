package serialization;


import static others.PrintUtils.lineSeparator;

import java.io.*;

public class ExampleSerialization02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //  SERELIZACIA
        lineSeparator(1);
        ClassSeralisable classSeralisable = new ClassSeralisable("name_A", 22);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(
                        new File("core/src/main/java/serialization/tetx.txt")));

        System.out.println(classSeralisable);


        objectOutputStream.writeObject(classSeralisable);
        objectOutputStream.flush();
        objectOutputStream.close();

        lineSeparator(2);
        classSeralisable.setName("name_B");
        classSeralisable.setAge(29);
        System.out.println(classSeralisable);

        //   DESERELIZACIA
        lineSeparator(3);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("core/src/main/java/serialization/tetx.txt"));
        ClassSeralisable deseralisable = (ClassSeralisable) objectInputStream.readObject();
        System.out.println(deseralisable);
    }
}


class ClassSeralisable implements Serializable {
    private String name;
    private int age;

    public ClassSeralisable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassSeralisable{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

