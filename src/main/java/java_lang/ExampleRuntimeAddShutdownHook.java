package java_lang;

public class ExampleRuntimeAddShutdownHook {
    public static void main(String[] args) {
        ClassP classP = new ClassP();


//        Runtime.runFinalizersOnExit(true);
        Runtime runtime = Runtime.getRuntime();

//        System.exit(0);
        if (true) throw new Error();

        runtime.addShutdownHook(new Thread(() -> {
            System.out.println("Hook");
        }));

    }
}


class ClassP {
    public ClassP() {
        System.out.println("Constructor!!!");
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Вызов метода System.runFinalizerOnExit (true) гарантирует, что метод
finalize ( ) будет вызван до того, как программа завершит свою работу. Но и этот метод крайне
ненадежен и не рекомендован к применению. В качестве альтернативы можно воспользоваться
методом Runtime.addShutdownHookO. Дополнительные сведения о нем можно найти в доку­
ментации на прикладной программный интерфейс API.
-----------------------------------------------------------------------------------------------------------------------
*/