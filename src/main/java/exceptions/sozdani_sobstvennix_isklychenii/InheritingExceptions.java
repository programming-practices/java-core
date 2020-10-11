package exceptions.sozdani_sobstvennix_isklychenii;

class SimpleException extends Exception {
}

public class InheritingExceptions {
    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
            System.out.println(e.toString());
//            e.printStackTrace();

        }
    }

    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from q()");
        throw new SimpleException();
    }
}
