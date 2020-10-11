package advanced;

import java.util.Date;
import java.util.HashMap;

// Sources: 1. https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
//          2. https://www.youtube.com/watch?v=2PPPW6I-C34
//          3. https://www.journaldev.com/129/how-to-create-immutable-class-in-java

public class ExampleImutable {
    public static void main(String[] args) {
// ---------------------------------------------------------------------------------------------------------------------
        Student student = new Student(18, "Roman", new Date());
        int i = student.getAge();
        String s = student.getName();
        Date d = student.getDate();
        i = 1;
        s = "Mike";
        d.setTime(0);
//        System.out.println(student.getAge());
//        System.out.println(student.getName());
//        System.out.println(student.getDate());

//        Student student1 = new MyStudent(18, "Max", new Date());
//        System.out.println(student1.getDate());

// ---------------------------------------------------------------------------------------------------------------------
        // To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes param args
        HashMap<String, String> h1 = new HashMap<String, String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String str = "original";

        int value = 10;

        FinalClassExample ce = new FinalClassExample(value, str, h1);

        //Lets see whether its copy by field or reference
        System.out.println(str == ce.getName());
        System.out.println(h1 == ce.getTestMap());
        //print the ce values
        System.out.println("ce id:" + ce.getId());
        System.out.println("ce name:" + ce.getName());
        System.out.println("ce testMap:" + ce.getTestMap());
        //change the local variable values
        value = 20;
        str = "modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:" + ce.getId());
        System.out.println("ce name after local variable change:" + ce.getName());
        System.out.println("ce testMap after local variable change:" + ce.getTestMap());

        HashMap<String, String> hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:" + ce.getTestMap());

    }
// ---------------------------------------------------------------------------------------------------------------------
}


// ---------------------------------------------------------------------------------------------------------------------
final class Student {
    private final int age;
    private final String name;
    private final Date date;

    public Student(int age, String name, Date date) {
        this.age = age;
        this.name = name;
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
//        return date;  // Ostorozno zdes
        return (Date) date.clone();
    }
}
//class MyStudent extends Student {
//    public MyStudent(int age, String name, Date date) {
//        super(age, name, date);
//    }
//
//    @Override
//    public Date getDate() {
//        Date date = new Date();
//        date.setTime(0);
//        return date;
//    }
//}

// ---------------------------------------------------------------------------------------------------------------------
final class FinalClassExample {

    private final int id;
    private final String name;
    private final HashMap<String, String> testMap;

    /**
     * Constructor performing Deep Copy
     *
     * @param i
     * @param n
     * @param hm
     */

//    public FinalClassExample(int i, String n, HashMap<String, String> hm) {
//        System.out.println("Performing Deep Copy for Object initialization");
//        this.id = i;
//        this.name = n;
//        HashMap<String, String> tempMap = new HashMap<String, String>();
//        String key;
//        Iterator<String> it = hm.keySet().iterator();
//        while (it.hasNext()) {
//            key = it.next();
//            tempMap.put(key, hm.get(key));
//        }
//        this.testMap = tempMap;
//    }


    /*
     * Constructor performing Shallow Copy
     * @param i
     * @param n
     * @param hm
     */
    public FinalClassExample(int i, String n, HashMap<String, String> hm) {
        System.out.println("Performing Shallow Copy for Object initialization");
        this.id = i;
        this.name = n;
        this.testMap = hm;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Accessor function for mutable objects
     */
    public HashMap<String, String> getTestMap() {
        //return testMap;
        return (HashMap<String, String>) testMap.clone();
    }

}

// ---------------------------------------------------------------------------------------------------------------------

/*
------------------------------------------------------------------------------------------------------------------------
Imutable class dolzen imet vse polia private i final.
Imutable class ne dolzen imet seterov.
Ostorozno s sulochnimi obektami, takimi kak Date. Ssulochnie obiektu dolznu bit clonirovanu
Imutable class dolzen bit final.

------------------------------------------------------------------------------------------------------------------------

*/
