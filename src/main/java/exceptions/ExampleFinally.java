package exceptions;

public class ExampleFinally {
    static Switch sw = new Switch();

    static int count = 0;

    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
//        System.out.println("Entering first try block");
//        try {
//            System.out.println("Entering second try block");
//            try {
//                throw new FourException();
//            } finally {
//                System.out.println("finally in 2nd try block");
//            }
//        } catch(FourException e) {
//            System.out.println("Caught FourException in 1st try block");
//        } finally {
//            System.out.println("finally in 1st try block");
//        }
//--------------------------------------------------------------------------------------------------------------------
//        try {
//            sw.on();
        // Code that can throw exceptions...
//            OnOffSwitch.fArgInt();
//            throw new RuntimeException();
//        } catch (OnOffException1 e) {
//            System.out.println("OnOffException1");
//        } catch (OnOffException2 e) {
//            System.out.println("OnOffException2");
//        } catch (RuntimeException e) {
//            System.out.println("RuntimeException!!!");
//        } finally {
//            sw.off();
//        }
//--------------------------------------------------------------------------------------------------------------------
//        try {
//            sw.on();
//            // Code that can throw exceptions...
//            OnOffSwitch.fArgInt();
//            throw new RuntimeException();
//        } catch (OnOffException1 e) {
//            System.out.println("OnOffException1");
//        } catch (OnOffException2 e) {
//            System.out.println("OnOffException2");
//        } finally {
//            sw.off();
//        }
//--------------------------------------Zaverwenie-s-pomowchi-finally-------------------------------------------------
//        while(true) {
//            try {
//                System.out.println(count);
//                // Post-increment is zero first time:
//                if(count++ == 0) throw new ThreeException();
//                System.out.println("No exception");
//            } catch(ThreeException e) {
//                System.out.println("ThreeException");
//            } finally {
//                System.out.println("In finally clause");
//                if(count == 2) break; // out of "while"
//            }
//        }
//--------------------------------------------------------------------------------------------------------------------
//        try {
//            throw new Exception("1");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (true) try {
//                throw new Exception("2");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        // Zdes iskluchenia perekruvaytsa
//        try {
//            throw new RuntimeException("1");
//        } finally {
//            throw new RuntimeException("2");
//        }

        // A zdes ne perecruvaytsa
        try {
            throw new Exception("1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            throw new RuntimeException("2");
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}

class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    public String toString() {
        return state ? "on" : "off";
    }
}

class OnOffSwitch {
    private static Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2 {
    }
}

class OnOffException1 extends Exception {
}

class OnOffException2 extends Exception {
}

class FourException extends Exception {
}

class ThreeException extends Exception {
}

/*
----------------------------------------------------------------------------------------------------------------------
Иногда блок finally приводит программирующих на Java в полное отчаяние, например, в тех случаях, когда методы очистки
памяти генерируют исключения. Предположим, что при возникновении исключения требуется закрыть поток ввода, как показано ниже.
                InputStream in =
                ...;
                try{
                    код, способный генерировать исключения
                }finally{
                    in.close();
                }
Допустим также, что код в блоке try генерирует некоторое исклю чение, не относящееся к классу IOException. И в этом случае
выполняется блок finally, в котором вызывается метод close(), способный сгенерировать исключение типа IOException!
В итоге исходное исключение будет потеряно, а вместо него будет сгенерировано исключение в методе close().

Таким образом, при обработке исклю чений возникает затруднительное положение в связи с тем, что первое из упомянутых выше
исключений представляет намного больший интерес. Для того чтобы исправить это положение, придется повторно сгенерировать
исходное исключение, услож н ив в конечном итоге исходный код. Ниже показано, как лучше всего выйти из столь затруднительного положения.
                InputStream in =
                ...;
                Exception ex = null;
                try{
                    try{
                        код, способный генерировать исключения
                    }catch (Exception e){
                        ex=e;
                        throw e;
                    }
                }finally{
                    try{
                        in.close();
                    }catch (Exception e){
                        if (ex == null) throw e;
                    }
                }
----------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Оператор try с ресурсами может также иметь сопутствующие операторы catch и finally. Блоки этих операторов
выполняются после освобождения используемых ресурсов. Но на практике вряд ли стоит нагромождать столько кода в единственном
блоке оператора try с ресурсами.
----------------------------------------------------------------------------------------------------------------------
*/