package _static;

public class ExampleStaticMethod {
    public static void main(String[] args) {

        new ExampleStaticMethod().methodM();  // Tak mozna vuzuvat statucheskii method

        ExampleStaticMethod.methodM(); // Etot vuzov static methoda poniaten

        ExampleStaticMethod exampleStaticMethod = null;
        exampleStaticMethod.methodM();   // I tak mozna zrobutu
    }

    static void methodM() {
        System.out.println("4");

//        this.getClass();    // Error this ne vozmozno ispolzovat v staticheskix methodax
        // получить класс статического метода
        new Object() {
        }.getClass().getEnclosingClass();
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
(Esli metod ykazat kak static to on ne iavno ykazyvaet chto on i final) no eto nado proverit.
-----------------------------------------------------------------------------------------------------------------------
СОВЕТ. При выдаче регистрирующих или отладочных сообщений в них нередко требуется включить имя текущего класса, как в
приведенной ниже строке кода.
            System.err.println("Something awful happened in " + getClass());
Но такой прием не годится для статического метода. Ведь вызов метода getClass(), по существу, означает вызов this.getciass().
Но ссылка this на текущий объект для статического метода не годится. В таком случае можно воспользоваться следующим выражением:
            new Object(){}.getClass().getEnclosingClass()
            // получить класс статического метода
Здесь в операции new Object(){} создается объект анонимного подкласса, производного от класса Object, а метод
getEnclosingClass() получает объемлющий его класс, т.е. класс,cсодержащий статический метод.
-----------------------------------------------------------------------------------------------------------------------
*/
