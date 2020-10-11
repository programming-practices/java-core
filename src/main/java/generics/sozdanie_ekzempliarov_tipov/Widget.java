package generics.sozdanie_ekzempliarov_tipov;

public class Widget {
    public static class Factory implements FactoryI<Widget> {
        public Widget create() {
            return new Widget();
        }
    }
}
