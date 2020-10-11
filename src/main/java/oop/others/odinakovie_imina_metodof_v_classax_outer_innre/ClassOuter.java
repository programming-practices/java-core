package Examples.OOP.Others.odinakovie_imina_metodof_v_classax_outer_innre;

public class ClassOuter {
    public void metod(String s) {

    }

    class ClassInner {
        public void metod() {

        }

        public void anotherMetod() {
            metod();
            ClassOuter.this.metod("s");
        }
    }
}
