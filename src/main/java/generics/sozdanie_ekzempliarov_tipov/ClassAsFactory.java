package generics.sozdanie_ekzempliarov_tipov;

public class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {

        try {

            x = kind.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
