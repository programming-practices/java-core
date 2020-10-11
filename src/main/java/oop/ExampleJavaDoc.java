package oop;

/**
 * Komentarii k klasy
 *
 * @autor TRL
 */
public class ExampleJavaDoc {

    /**
     * Масть черви
     */
    public static final int HEARTS = 1;
    private String name;
    private int age;

    public ExampleJavaDoc(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Komentarii k methody
     *
     * @return String value;
     * @throws java.io.IOException eto isklycheie vuxodit potomy chto;
     * @param(name,age);
     */
    public String method(String name, int age) {
        System.out.println("Hello from " + name + age);
        return "o";
    }


    /**
     * Увеличивает зарплату работников
     *
     * @param byPercent содержит величину
     *                  в процентах, на которую повышается зарплата
     *                  (например, 10 = 10%) .
     * @return Величина, на которую повышается зарплата
     * @see /root/Datos/Programacion/studies_a_programing/src/main/java/Examples/_static/ExampleStaticMethod#methodM()
     * @see <a href="www.horstmann.com/corejava.html">Web-страница книги Core Java</a>
     * @see "Core Java volume 2"
     */
    public double raiseSalary(double byPercent) {
        double raise = byPercent / 100;
        return raise;
    }

    /**
     * <b>Piswet zirnum</b> ili <i>piwet cursivom</i>
     * Sozdaet spisok:
     * <ol>
     *     <li>pynkt #1</li>
     *     <li>pynkt #2</li>
     *     <li>pynkt #3</li>
     *     <li>pynkt #4</li>
     *     <li>pynkt #5</li>
     * </ol>
     * <p>
     *     Paragraf
     * </p>
     * <p>
     * Soxraniaet formatirovanie
     * <pre>
     *      ***
     *     *   *
     *     *   *
     *     *   *
     *      ***
     * </pre>
     */
    public void method() {
        System.out.println("tests");
    }
}

class Main {
    public static void main(String[] args) {
        ExampleJavaDoc e = new ExampleJavaDoc("Ostap", 45);
        e.method("nameee", 49);
        e.raiseSalary(.4);
        int hearts = ExampleJavaDoc.HEARTS;
    }
}
