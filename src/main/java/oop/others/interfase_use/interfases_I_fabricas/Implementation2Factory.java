package OOP.Others.interfase_use.interfases_I_fabricas;

class Implementation2Factory implements ServiceFactory {

    @Override
    public void metod1() {

    }

    @Override
    public void metod2() {

    }

    @Override
    public Service getService() {
        return new Implementation2();
    }

}
