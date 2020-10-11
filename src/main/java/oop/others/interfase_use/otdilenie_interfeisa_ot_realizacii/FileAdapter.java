package oop.others.interfase_use.otdilenie_interfeisa_ot_realizacii;


import oop.others.interfase_use.otdilenie_intrfeisa_ot_realizacii_1.Filter;

class FilterAdapter implements Processor {
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public Object process(Object input) {
        return null;
    }
}
