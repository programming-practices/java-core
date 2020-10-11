package exceptions.Others;

public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public MyException() {
    }

    @Override
    public String toString() {
        return "To String My Excepton!!!" + super.toString();
    }
}
