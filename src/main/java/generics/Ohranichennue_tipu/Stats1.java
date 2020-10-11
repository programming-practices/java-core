package generics.Ohranichennue_tipu;

// In this version of Stats, the type argument for
// T must be either Number, or age class derived
// from Number.
public class Stats1<T extends Number> {
    T[] nums; // array of Number or subclass

    // Pass the constructor age reference to
    // an array of type Number or subclass.
    Stats1(T[] o) {
        nums = o;
    }

    // Return type double in all cases. public class d {}
    double average() {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++)
            sum += nums[i].doubleValue();

        return sum / nums.length;
    }

    boolean someAvg(Stats1<?>/*<T>*/ ob) {
        if (this.average() == ob.average()) {
            return true;
        }
        return false;
    }
}

// Demonstrate Stats.
class BoundsDemo {
    public static void main(String args[]) {

        Integer inums[] = {1, 2, 3, 4, 5};
        Stats1<Integer> iob = new Stats1<Integer>(inums);
        double v = iob.average();
        System.out.println("iob average is " + v);

        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats1<Double> dob = new Stats1<Double>(dnums);
        double w = dob.average();
        System.out.println("dob average is " + w);

        // This won't compile because String is not age
        // subclass of Number.
        //    String strs[] = { "1", "2", "3", "4", "5" };
        //    Stats1<String> strob = new Stats1<String>(strs);

        //    double x = strob.average();
        //    System.out.println("strob average is " + v);


//        boolean b = iob.someAvg(dob);// ERROR
//        System.out.println(b);
    }
}
