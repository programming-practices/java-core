package others.Modefikatoru_dostypa.PackageA;

public class ClassA {

    protected final int finalProtectedVariable;   //  protected final polia nyzno inicializirovat v konstryktore predka, ne ostovliat inicializaciy na potomka
    protected final ClassV finalProtectedclassV;
    protected int protectedVariable;
    int defaultVariable = 1;

    public ClassA(int finalProtectedVariable, ClassV c) {
        this.finalProtectedVariable = finalProtectedVariable;
        finalProtectedclassV = c;
    }

    protected final void finalMethod() {
    }

    private void methodPrivate() {

//        public int a = 3;      // error
//        private int aa = 4;        //error
//        protected int aaa = 2;        // error
        final int e = 1;
    }
}
