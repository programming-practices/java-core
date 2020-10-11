package collections.others.Golovach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Point2D /*implements  Comparable<Point2D>*/ {
    private final int x;
    private final int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" + "x=" + x + ", y=" + y + '}';
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj == null) return false;
//        if(this.getClass() != obj.getClass()) return false;
//        Point2D that = (Point2D) obj;
//        return this.x == that.x && this.y == that.y;
//    }

    @Override
    public int hashCode() {
//        return 0;   //  matematicheskii korektnii kod, rabotaet corectno no ochen medlenno, HashSet poxoz na linkedLidt elsli hasCode return 0
//        return x + y;  // matematicheskii korektnii kod, toze rabotaet corectno i namnoho bestree
        return 31 * x + y;  // matematicheskii korektnii kod, toze rabotaet corectno i pochti maksemalno bistro hasset
    }


//    @Override
//    public int compareTo(@NotNull Point2D that) {
////        return this.x - that.x;   // ploxoi comparator, pri takom comtaratore Point2D(0,0) i Point2D(0,10) ravnu
//        int dX = this.x - that.x;
//        if(dX != 0){
//            return dX;
//        } else {
//            return this.y - that.y;
//        }
//    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}


class TestString {
//    public static void main(String[] args) {
//
//        Set<String> set = new TreeSet<>(new StrComparator());
////        NavigableSet<String> navigableSet = new TreeSet<>(new StrComparator());
////        navigableSet.add("a");
////        navigableSet.add("b");
////        navigableSet.add("c");
////        navigableSet.add("d");
////        navigableSet.add("e");
////        navigableSet.add("fArgInt");
//        NavigableSet<String> navigableSet = new TreeSet<>(/*new StrComparator()*/);
//        navigableSet.add("aa");
//        navigableSet.add("bb");
//        navigableSet.add("cc");
//        navigableSet.add("dd");
//        navigableSet.add("ee");
//        navigableSet.add("ff");
//        navigableSet.add("xx");
//
//        System.out.println(navigableSet);
//        NavigableSet<String> b = navigableSet.tailSet("b", false);
//        System.out.println(b);
//
//        NavigableSet<String> b1 = navigableSet.headSet("ff", false);
//        System.out.println(b1);
//
////        System.out.println(navigableSet.descendingSet());
////        System.out.println(navigableSet.pollFirst());
////        System.out.println(navigableSet.pollLast());
////        System.out.println(navigableSet.first());
////        System.out.println(navigableSet.pollFirst());
////        System.out.println(navigableSet.pollFirst());
////        NavigableSet<String> strings = navigableSet.subSet("b", true, "e", false);
////        System.out.println(strings);
//
////        Iterator<String> iterator = set.iterator();
////        System.out.println(iterator.next());
////        System.out.println(iterator.next());
////        System.out.println(iterator.next());
////        System.out.println(iterator.next());
//    }

}

//class StrComparator implements Comparator<String> {
//    @Override
//    public int compare(String str1, String str2) {
//        int lengDeff = str1.length() - str2.length();
//        if(lengDeff != 0){
//            return lengDeff;
//        } else {
//            return str1.compareTo(str2);
//        }
//    }
//}


//class TestTreeSet{
//    public static void main(String[] args) {

//        Set<Point2D> set = new TreeSet<>();
//        set.add(new Point2D(0,10));
//        set.add(new Point2D(10,0));
//        set.add(new Point2D(0,1));
////        set.add(new Point2D(2,0));
////        set.add(new Point2D(1,2));
////        set.add(new Point2D(0,4));
//        set.add(new Point2D(0,0));
//        set.add(new Point2D(0,0));
////
////        set.add(new Point2D(3,1));
////        set.add(new Point2D(1,3));
////        set.add(new Point2D(1,1));
//
//        System.out.println(set);


//        Set<Integer> set1 = new TreeSet<>();
//        set1.add(100);
//        set1.add(-100);
//        set1.add(0);
//        set1.add(50);
//        set1.add(-34);
//        System.out.println(set1);
//        System.out.println();
//
//
//        Set<String> set2 = new TreeSet<>();
//        set2.add("Hello");
//        set2.add("hello");
//        set2.add("Good bye");
//        set2.add("Hola");
//        set2.add("a");
//        set2.add("A");
//        System.out.println(set2);
//        System.out.println();

//
//    }
////
//}


class TestArrayList {
    public static void main(String[] args) {
        List<Point2D> point2DS = new ArrayList<>();
        point2DS.add(new Point2D(0, 1));
        point2DS.add(new Point2D(0, 11));
        point2DS.add(new Point2D(1, 0));
        point2DS.add(new Point2D(10, 10));
        point2DS.add(new Point2D(10, 2));
        for (Point2D p : point2DS) {
            System.out.println(p);

        }
        System.out.println();
        Collections.sort(point2DS, new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
//                int def = o1.getX() - o2.getX();
//                if(def != 0){
//                    return def;
//                } else {
//                    return o1.compareTo(o2);
//                }
                return o1.getY() - o2.getY();
            }
        });

        Collections.sort(point2DS, new Comparator<Point2D>() {
            @Override


            public int compare(Point2D o1, Point2D o2) {
//                int def = o1.getX() - o2.getX();
//                if(def != 0){
//                    return def;
//                } else {
//                    return o1.compareTo(o2);
//                }
                return o1.getX() - o2.getX();
            }
        });
        for (Point2D p : point2DS) {
            System.out.println(p);

        }
//        String s0 = new String("Hello");
//        String s1 = new String("Hello");
//        System.out.println(s0 == s1);
//        System.out.println(s0.equals(s1));
//        System.out.println();
//
//        String s2 = new String("Hello");
//        String s3 = s2;
//        System.out.println(s2 == s3);
//        System.out.println(s2.equals(s3));
//
//        System.out.println();
//        String s4 = "Hello" + " " + System.currentTimeMillis();
//        String s5 = "Hello" + " " + System.currentTimeMillis();
//        System.out.println(s4 + "     " + s5);
//        System.out.println(s4 == s5);
//        System.out.println(s4.equals(s5));
//        System.out.println();

//        Integer i0 = 100;
//        Integer i1 = 100;
//        System.out.println(i0 == i1);         // true
//        System.out.println(i0.equals(i1));   // true
//        System.out.println();
//
//        Integer i2 = 200;
//        Integer i3 = 200;
//        System.out.println(i2 == i3);        //false
//        System.out.println(i2.equals(i3));   // true
//        System.out.println();
//
//        Integer i4 = 127;
//        Integer i5 = 127;
//        System.out.println(i4 == i5);        // true
//        System.out.println(i4.equals(i5));   // true
//        System.out.println();
//
//        Integer i6 = 128;
//        Integer i7 = 128;
//        System.out.println(i6 == i7);        //false
//        System.out.println(i6.equals(i7));   // true
//        System.out.println();
//
//        int i8 = 127;
//        int i9 = 127;
//        System.out.println(i8 == i9);        // true
////        System.out.println(i8.equals(i9));   // ne rabotaet v primitivov nety equals
//        System.out.println();
//
//        int i10 = 128;
//        int i11 = 128;
//        System.out.println(i10 == i11);        // true
////        System.out.println(i10.equals(i11));   // ne rabotaet v primitivov nety equals
//        System.out.println();

//        Integer i0 = new Integer(100);
//        Integer i1 = new Integer(100);
//        int in = i0.intValue() + i1.intValue();   // name ne nado eto delat, jvm sama delaet unboxing
//        System.out.println(i0 == i1);            //  false
//        System.out.println(i0.equals(i1));//  true
//        System.out.println();
//
//        Integer i2 = Integer.valueOf(100);
//        Integer i3 = Integer.valueOf(100);
//        System.out.println(i2 == i3);            //  true
//        System.out.println(i2.equals(i3));       //  true
//        System.out.println();
//
//        Integer i4 = Integer.valueOf(200);
//        Integer i5 = Integer.valueOf(200);
//        System.out.println(i4 == i5);            //  false
//        System.out.println(i4.equals(i5));       //  true


//        List<Point2D> list = new ArrayList<>();
//        list.add(new Point2D(0,0));
//        list.add(new Point2D(0,0));
//        list.add(new Point2D(1,3));
//        list.add(new Point2D(1,1));
//
//        System.out.println(list);
//        System.out.println(list.contains(new Point2D(0,0)));
//        System.out.println(list.remove(new Point2D(0,0)));
//        System.out.println(list);
//
//        while(list.remove(new Point2D(0,0)));
//        System.out.println(list);

    }
}


//class TestHashSet{
//    public static void main(String[] args) {
//
//        Set<Point2D> set = new HashSet<>();
//        set.add(new Point2D(0,0));
//        set.add(new Point2D(0,0));
//        set.add(new Point2D(0,1));
//        set.add(new Point2D(1,3));
//        set.add(new Point2D(1,1));
//
//        System.out.println(set);
//        System.out.println(set.contains(new Point2D(0,0)));
//        System.out.println(set.remove(new Point2D(0,0)));
//        System.out.println(set);
//
//
//    }
//
//}

