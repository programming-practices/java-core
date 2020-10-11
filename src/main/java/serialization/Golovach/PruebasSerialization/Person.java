package serialization.Golovach.PruebasSerialization;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String FirstName;
    private String LastName;
    private byte age;
    private boolean sexo;

    public Person(String firstName, String lastName, byte age, boolean sexo) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.age = age;
        this.sexo = sexo;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public byte getAge() {
        return this.age;
    }

    public boolean isSexo() {
        return this.sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.age == person.age && this.sexo == person.sexo && Objects.equals(this.FirstName, person.FirstName) && Objects.equals(this.LastName, person.LastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.FirstName, this.LastName, this.age, this.sexo);
    }
}
