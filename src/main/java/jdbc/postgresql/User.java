package jdbc.postgresql;

public class User {
    private int id;
    private String userName;
    private String password;

    public User() {

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String userName, String password) {

        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{Id: " + id
                + ", User Name: " + userName
                + ", Password: " + password + "}";
    }
}
