package OOP.Others.interfase_use.interfases_I_fabricas;

public class Implementation1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation1();
    }

    @Override
    public void metod1() {

    }

    @Override
    public void metod2() {

    }

}
