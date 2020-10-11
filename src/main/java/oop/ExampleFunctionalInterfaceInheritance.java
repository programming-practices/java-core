package Examples.OOP;

@FunctionalInterface
interface Interface00_A {
    public int f00();
}
//------------------------------Interfeisu kotorue ne imeyt mezdy soboi nasledovania---------------------------------

@FunctionalInterface
interface Interface01_A {
    public int f01();
}

@FunctionalInterface
interface Interface011_A {
    public void f01();
}

@FunctionalInterface
interface Interface00_B {
    public void f00();
}

//---------------------------------------------------------------------------------------------------------------------

@FunctionalInterface
interface Interface01_B {
    public void f01();
}

@FunctionalInterface
interface Interface011_B {
    public int f01();
}

//FunctionalInterface ne mohyt unasledovatsa ot dryhyx intrfeisov
@FunctionalInterface
interface Interface02 {
    public void f02();
}

//-----------------------------------Interfeisu kotorue nasledyytsa mezdy soboi----------------------------------------

//@FunctionalInterface     // ERROR eto ne funtional interface
interface Interface03 extends Interface02 {
    public void f03();
}

//@FunctionalInterface     // ERROR eto ne funtional interface
interface Interface04 {
    default public void f02() {
    }

    ;
}

//-----------------------------------------------------------------------------------------------------------------

//@FunctionalInterface     // ERROR eto ne funtional interface
interface Interface05 extends Interface02 {
    public void f03();
}

public class ExampleFunctionalInterfaceInheritance {
    public static void main(String[] args) {
//-----------------------------AAAAAAAAAAAAA---------------------------------------------------------------------------

        Interface00_A interface00_a = ExampleFunctionalInterfaceInheritance::printHelloInt;

        // Potomy chto eto raznue interfeisu
//        Interface01_A interface01_a = interface00_a;   // ERROR

        // Eto ochen vaznaia vewch !!!!!!!!!!!!!!!
        // Eto polychaetsa iz za toho chto oni iavliaytsa sovmestnumi (imeyt odinakovue metodu)
        Interface01_A interface01_a = interface00_a::f00;

        // S etim toze nado bit ostoroznum
        // Metod kotorui vozvrashchaet kakoeto znachenie mozet bit sovmestimum
        // s metodom kotorui ne vozvrawchaet nikakoho znachenia
        Interface011_A interface011_a = interface00_a::f00;   // A zdes nety owubki

//---------------------------------------------------------------------------------------------------------------------

        Interface00_B interface00_b = ExampleFunctionalInterfaceInheritance::printHelloVoid;

        // Potomy chto eto raznue interfeisu
//        Interface01_A interface01 = interface00;   // ERROR

        // Eto ochen vaznaia vewch !!!!!!!!!!!!!!!
        // Eto polychaetsa iz za toho chto oni iavliaytsa sovmestnumi (imeyt odinakovue metodu)
        Interface01_B interface01_b = interface00_b::f00;

        // S etim toze nado bit ostoroznum
        // Metod kotorui ne vozvrashchaet ni kakoe znachenie ne mozet bit sovmestimum
        // s metodom kotorui vozvrawchaet kakoet znachenie
//        Interface011_B interface011 = interface00_b::f00;  // ERROR

//---------------------------------------------------------------------------------------------------------------------

        // Error potomy chto Interface03 ne iavliaetsa FunctionalInteface, iz za nasledovania
//        Interface03 interface03 = System.out::println;  // ERROR

        // A Interfface02 iavilaetsa FunctionalInterface potomy chto on ne nasleduetsa ni ot koho.
        Interface02 interface02 = System.out::println;

//--------------------------------------------------------------------------------------------------------------------
        // Interface04 ne iavliaetsa Functional Interface potomu chto ne imeet ni odnoho metoda
        // nerealizirovanoho, a imeet  tolko metod default
//        Interface04 interface04 = System.out::println;  // ERROR

        // Functional Interface ne mozet ot kohoto nasledovatsa, i po etomu Interface05 eto ne FunctionalInterface.
//        Interface05 interface05 = System.out::println; // ERROR

//--------------------------------------------------------------------------------------------------------------------
    }

    public static void printHelloVoid() {
        System.out.println("Hello");
    }

    public static int printHelloInt() {
        System.out.println("Hello");
        return 43;
    }
}

//-----------------------------------------------------------------------------------------------------------------


