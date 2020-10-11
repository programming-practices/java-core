package object.finalize;

import java.util.Objects;

public class ObjectFinalize {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------

        /*С этой целью в любой класс можно ввести метод finalize(), который будет вы­
        зван перед тем, как система сборки "мусора" уничтожит объект. Но на практике,
        если требуется возобновить ресурсы и сразу использовать их повторно, нельзя пола­
        гаться только на метод finalize(), поскольку заранее неизвестно, когда именно этот
        метод будет вызван.*/

        ClassF classF = new ClassF();
        try {
            classF.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        /*НА ЗАМЕТКУ! Вызов метода System.runFinalizerOnExit(true) гарантирует, что метод
        finalize() будет вызван до того, как программа завершит свою работу. Но и этот метод крайне
        ненадежен и не рекомендован к применению. В качестве альтернативы можно воспользоваться
        методом Runtime.addShutdownHook(). Дополнительные сведения о нем можно найти в доку­
        ментации на прикладной программный интерфейс API.*/
//---------------------------------------------------------------------------------------------------------------------
    }
}

class ClassF {
    private String name;
    private int age;

    public ClassF() {
    }

    public ClassF(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ClassF classF = (ClassF) o;
        return this.age == classF.age &&
                Objects.equals(this.name, classF.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.name, this.age);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

/*
Etot method ne sovetyyt ispolzovat
*/
