package stringAPI._string.postoianstvo_strok.pryebas;

import java.util.Date;

public class Pruebas {

    public Integer immutable(Integer numero) {
        Integer i = numero;
        return i + 10;
    }

    public Integer mutable(Integer numero) {
        numero = numero + 10;
        return numero;
    }
}

final class BrokenPerson {

    private String firstName;
    private String lastName;
    private Date dob;
    private Integer age;

    public BrokenPerson(String firstName,
                        String lastName, Date dob, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getDOB() {
        return this.dob;
    }

    public Integer getAge() {
        return this.age;
    }
}

class Main {

    public static void main(String[] args) {

//======================================================================================================================

//        Date myDate = new Date();
//        String myFirstName = "David";
//        String myLastName = "O'Meara";
//        Integer age = 20;
//
//        BrokenPerson myPerson = new BrokenPerson( myFirstName, myLastName, myDate, age);
//        System.out.println(myPerson.getDOB() );
//        myDate.setMonth(myDate.getMonth() + 1 );
//        System.out.println(myPerson.getDOB() );
//        System.out.println();
//
//        System.out.println(myPerson.getFirstName());
//        myFirstName = myFirstName + "eee";
//        System.out.println(myPerson.getFirstName());
//
//        System.out.println(myPerson.getAge());
//        age = age + 2;
//        System.out.println(myPerson.getAge());

//======================================================================================================================

        Pruebas p = new Pruebas();
        Integer numeroPM = 3;
        Integer numeroPI = 3;

        System.out.println(numeroPM);
        System.out.println(p.mutable(numeroPM));
        System.out.println(numeroPM);

        System.out.println();

        System.out.println(p.immutable(numeroPI));
        System.out.println(numeroPI);

        System.out.println();

        String myString = "old String";
        System.out.println(myString);
        myString.replaceAll("old", "new");
        System.out.println(myString);

        System.out.println();

        String myString1 = new String("old String");
        System.out.println(myString1);
        myString1 = new String("new String");
        System.out.println(myString1);

        String myString2 = new String("old String");
        String myCache = myString2;
        System.out.println("equal: " + myString2.equals(myCache));
        System.out.println("same:  " + (myString2 == myCache));

        myString2 = "not " + myString2;
        System.out.println("equal: " + myString2.equals(myCache));
        System.out.println("same:  " + (myString2 == myCache));

//======================================================================================================================
    }
}