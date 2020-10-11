package generics.sozdanie_ekzempliarov_tipov;

public class IntegerFactory implements FactoryI<Integer> {
    public Integer create() {
        return new Integer(0);
    }
}
