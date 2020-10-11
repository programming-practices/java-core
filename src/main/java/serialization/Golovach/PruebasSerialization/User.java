package serialization.Golovach.PruebasSerialization;


public class User extends Person {
    private int userId;

    public User(String firstName, String lastName, byte age, boolean sexo, int userId) {
        super(firstName, lastName, age, sexo);
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }
}
