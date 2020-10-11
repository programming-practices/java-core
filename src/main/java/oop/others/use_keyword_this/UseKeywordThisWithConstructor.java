package oop.others.use_keyword_this;

public class UseKeywordThisWithConstructor {

    public static void main(String[] args) {

        Boy boy = new Boy("Joy");
        System.out.println(boy);

    }

}

class Boy {

    String name;
    int age;

    public Boy(String name) {
        this(0);
        this.name = name;
    }

    private Boy(int age) {
        this.age = age;
    }

    public Boy(String name, int age) {
        this.age = age;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}


