package oop.others.use_keyword_this;

public class UseKeywordThisWithMethod {

    public static void main(String[] args) {

        Women women = new Women();
        women.methodA();

    }

}

class Women {

    public void methodA() {
        System.out.println("Hello form methodA!!!");
        methodB();
        this.methodB();
    }

    public void methodB() {
        System.out.println("Hello from methodB!!!");
    }

}

