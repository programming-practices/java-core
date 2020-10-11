package Examples.OOP;

import java.util.Random;

//--------------------------------------------------------------------------------------------------------------------
interface PruebasInteface {
    int a = 3;
    final static int a0 = 3;
//    int s;     // ERROR
}

//--------------------------------------------------------------------------------------------------------------------
interface SharedConstants {
    int NO = 0;
    int YES = 1;
    int MAYBE = 2;
    int LATER = 3;
    int SOON = 4;
    int NEVER = 5;
}

public class ExampleInterfaceField {
    public static void main(String args[]) {
//---------------------------------------------------------------------------------------------------------------------
        Question q = new Question();

        AskMe.answer(q.ask());
        AskMe.answer(q.ask());
        AskMe.answer(q.ask());
        AskMe.answer(q.ask());
//---------------------------------------------------------------------------------------------------------------------
        int a = PruebasInteface.a;
//---------------------------------------------------------------------------------------------------------------------
    }
}

class Question implements SharedConstants {
    Random rand = new Random();

    int ask() {
        int prob = (int) (100 * rand.nextDouble());
        if (prob < 30)
            return NO;           // 30%
        else if (prob < 60)
            return YES;          // 30%
        else if (prob < 75)
            return LATER;        // 15%
        else if (prob < 98)
            return SOON;         // 13%
        else
            return NEVER;        // 2%
    }
}

class AskMe implements SharedConstants {
    static void answer(int result) {
        switch (result) {
            case NO:
                System.out.println("No");
                break;
            case YES:
                System.out.println("Yes");
                break;
            case MAYBE:
                System.out.println("Maybe");
                break;
            case LATER:
                System.out.println("Later");
                break;
            case SOON:
                System.out.println("Soon");
                break;
            case NEVER:
                System.out.println("Never");
                break;
        }
    }


}
