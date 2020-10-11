package additional;

interface A01 {
    void run();
}


interface B01 {
    void run();
}

public class MnozestvennoeNasledovanie01 implements A01, B01 {
    public static void main(String[] args) {
        new MnozestvennoeNasledovanie01().run();
    }


    @Override
    public void run() {

    }
}


