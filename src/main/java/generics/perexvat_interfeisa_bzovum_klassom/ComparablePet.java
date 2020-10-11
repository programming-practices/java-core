package generics.perexvat_interfeisa_bzovum_klassom;

public class ComparablePet implements Comparable<ComparablePet> {

    public int compareTo(ComparablePet arg) {
        return 0;
    }
}


//class Cat extends ComparablePet implements Comparable<Cat>{
//    // Error: Comparable cannot be inherited with
//    // different arguments: <Cat> and <Pet>
//    public int compareTo(Cat arg) { return 0; }
//}

class Hamster extends ComparablePet implements Comparable<ComparablePet> {

    public int compareTo(ComparablePet arg) {
        return 0;
    }

}

// Or just:

class Gecko extends ComparablePet {

    public int compareTo(ComparablePet arg) {
        return 0;
    }

}
