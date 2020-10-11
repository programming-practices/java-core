package loops;

public class ExampleWhile_DoWhile {

    public static void main(String[] args) {

//======================================================================================================================
//================================================ do/while loop =======================================================
//======================================================================================================================

        // The example below uses a do/while loop. The loop will always be executed at least once, even if the
        // condition is false, because the code block is executed before the condition is tested:
        int index = 0;
//        do {
//            System.out.println(index);
//            index++;
//        }
//        while (index < 5);


//        do {
//            System.out.println("Hello from do/while");
//        } while (index > 0);

//======================================================================================================================
//=================================================== while ============================================================
//======================================================================================================================

//        while (index > 0) {
//            System.out.println("Hello from while()");
//        }
//        System.out.println("Hello from outside");


        while (index <= 0) {
            System.out.println("Hello from while()");
        }
        System.out.println("Hello from outside");

//======================================================================================================================
//=================================== Comparison while and for() loop ==================================================
//======================================================================================================================

        // These two loop implementations do the same job:
        // 1.
//        int k = 0;
//        while (true) {
//            if (k < 10) {
//                System.out.print(k + ", ");
//                k++;
//            } else {
//                break;
//            }
//        }

        // 2.
//        for (int i = 0; i < 10; i++) {
//            System.out.print(k + ", ");
//        }


//======================================================================================================================
//======================================================================================================================
//======================================================================================================================

    }
}



/*
The while loop loops through a block of code as long as a specified condition is true:
               while (condition) {
                     // code block to be executed
               }


The do/while loop is a variant of the while loop. This loop will execute the code block once, before checking if
the condition is true, then it will repeat the loop as long as the condition is true.
                do {
                     // code block to be executed
                }while (condition);


*/