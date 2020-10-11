package Examples.OOP.Others.ihra_z_vnutrenimi_classami;

public class Outer {
    public Outer() {
        Inner1.Inner2.Inner3.Inner4.Inner5.Inner6 inner6 = new Inner1.Inner2.Inner3.Inner4.Inner5.Inner6();

    }

    private void privateMetodOuter() {
        System.out.println("Metod private class Outer.");
    }

    public void publicMetodOuter() {
        System.out.println("Metod public classa Outer.");
    }

    private static class Inner1 {

        private void privateMetodInner1() {
            System.out.println("Class Inner1 private metod!");
        }

        public void publicMetodInner1() {
            System.out.println("Class Inner1 public metod!");
        }

        private static class Inner2 {

            private void privateMetodInner2() {
                System.out.println("Class Inner2 private metod!");
            }

            public void publicMetodInner2() {
                System.out.println("Class Inner2 public metod!");
            }

            private static class Inner3 {

                private void privateMetodInner3() {
                    System.out.println("Class Inner3 private metod!");
                }

                public void publicMetodInner3() {
                    System.out.println("Class Inner3 public metod!");
                }

                private static class Inner4 {

                    private void privateMetodInner4() {
                        System.out.println("Class Inner4 private metod!");
                    }

                    public void publicMetodInner4() {
                        System.out.println("Class Inner4 public metod!");
                    }

                    private static class Inner5 {

                        private void privateMetodInner5() {
                            System.out.println("Class Inner5 private metod!");
                        }

                        public void publicMetodInner5() {
                            System.out.println("Class Inner5 public metod!");
                        }

                        private static class Inner6 {
                            private void privateMetodInner6() {
                                System.out.println("Class Inner6 private metod!");
                            }

                            public void publicMetodInner6() {
                                System.out.println("Class Inner6 public metod!");
                            }
                        }
                    }
                }
            }
        }
    }
}
