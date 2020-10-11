package Examples.OOP.Others.klassu_vnytri_interfeisov.vprava_19_10;

public interface InterfaceA {
    void metodInterface1();

    void metodInterface2();

    class NestedInterface {
        static void metod1() {
            InterfaceA interfaceA = new InterfaceA() {
                @Override
                public void metodInterface1() {
                    System.out.println("MetodInterface1");
                }

                @Override
                public void metodInterface2() {
                    System.out.println("MetodInterface2");
                }
            };
        }
    }
}

//Vprava ne zakinchena, na danui moment neznay iak ii zakinchutu. Storinka 306
