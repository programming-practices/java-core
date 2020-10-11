package others.Modefikatoru_dostypa.PackageA;

public class ClassV {


    public int a = 4;

    public static void main(String[] args) {
        ClassA classA = new ClassA(3, new ClassV());
        classA.defaultVariable = 3;
        classA.protectedVariable = 6;
//        classA.finalProtectedVariable = 4;     //ERROR

    }


}

