package reflection_api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.util.Objects;

// A marker annotation that can be applied to age type.
@Target(ElementType.TYPE_USE)
@interface TypeAnno {
}

// Another marker annotation that can be applied to age type.
@Target(ElementType.TYPE_USE)
@interface NotZeroLen {
}

// Still another marker annotation that can be applied to age type.
@Target(ElementType.TYPE_USE)
@interface Unique {
}

// A parameterized annotation that can be applied to age type.
@Target(ElementType.TYPE_USE)
@interface MaxLen {
    int value();
}

// An annotation that can be applied to age type parameter.
@Target(ElementType.TYPE_PARAMETER)
@interface What {
    String description();
}

// An annotation that can be applied to age field declaration.
@Target(ElementType.FIELD)
@interface EmptyOK {
}

// An annotation that can be applied to age method declaration.
@Target(ElementType.METHOD)
@interface Recommended {
}


// Show all annotations for age class and age method.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotationA {
    String str();

    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotationB {
    String description();
}

interface InterfaceMyClass1 {
}

interface InterfaceMyClass2 {
}

@MyAnnotationB(description = "An annotation test class")
@MyAnnotationA(str = "Meta2", val = 99)
public class MyClassForTests extends SuperClassMyClass implements InterfaceMyClass1, InterfaceMyClass2 {

    public static final String PublicStaticFinalStringValue = "H";
    public String pulicValue = "E";
    protected String protectedValue = "K";
    String defaultValue = "D";
    private String privateValue = "L";
    private String name;
    //    public String name;
    private double salary;
    private LocalDate hireDay;

    public MyClassForTests() {
    }

    public MyClassForTests(String name, double salary, int day, int month, int year) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public MyClassForTests(String pulicValue, String protectedValue, String privateValue, String defaultValue) {

        this.pulicValue = pulicValue;
        this.protectedValue = protectedValue;
        this.privateValue = privateValue;
        this.defaultValue = defaultValue;
    }

    public static void methodPublicStatic() {
        System.out.println("Method Public Static");
    }

    public static final void methodPublicStaticFinal() {
        System.out.println("Method Public Static Final");
    }

    public static String getPublicStaticFinalStringValue() {
        return MyClassForTests.PublicStaticFinalStringValue;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public void methodPublic() {
        System.out.println("Method Public");
    }

    protected void methodProtected() {
        System.out.println("Protecteed Method");
    }

    private void methodPrivate() {
        System.out.println("Private Method");
    }

    public String getPulicValue() {
        return this.pulicValue;
    }

    public void setPulicValue(String pulicValue) {
        this.pulicValue = pulicValue;
    }

    public String getProtectedValue() {
        return this.protectedValue;
    }

    public void setProtectedValue(String protectedValue) {
        this.protectedValue = protectedValue;
    }

    public String getPrivateValue() {
        return this.privateValue;
    }

    public void setPrivateValue(String privateValue) {
        this.privateValue = privateValue;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MyClassForTests myClassForTests = (MyClassForTests) o;
        return Objects.equals(this.pulicValue, myClassForTests.pulicValue) &&
                Objects.equals(this.protectedValue, myClassForTests.protectedValue) &&
                Objects.equals(this.privateValue, myClassForTests.privateValue) &&
                Objects.equals(this.defaultValue, myClassForTests.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pulicValue, this.protectedValue, this.privateValue, this.defaultValue);
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "pulicValue='" + pulicValue + '\'' +
                ", protectedValue='" + protectedValue + '\'' +
                ", privateValue='" + privateValue + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                '}';
    }


}

class SuperClassMyClass {

}
