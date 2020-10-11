package oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii;

public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using processor " + p.name());
        System.out.println(p.process(s));
    }
//    public static String s = "Disagreeement with beliefs is by definition incorrect";
//
//    public static void main(String[] args) {
//        process(new Upcase(), s);
//        process(new Downcase(), s);
//        process(new Splitter(), s);
//    }

}
