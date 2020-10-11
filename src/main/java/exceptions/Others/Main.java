package exceptions.Others;

public class Main {
    public static void main(String[] args) {


//        try{
//            System.out.println("Hola");
////            throw new ArithmeticException();
//            throw new MyException("Opesanie v constryctore");
//        }catch(MyException my){
//            my.printStackTrace();
//            System.out.println(my.getCause());
//        }/*catch(ArithmeticException e){
//            e.printStackTrace();
//            System.out.println(e.getCause());
//            System.out.println(e.getLocalizedMessage());
//            System.out.println(e.getMessage());
//        }*/


//        System.out.println(Arrays.toString(args));

        try {
            System.out.println("Hola");
            throw new ArithmeticException();

        } catch (Exception e) {
//            if(true)return;
            e.printStackTrace();
        } finally {
            System.out.println("Blok finaly");

        }
//
//        try{
//            System.out.println("Hola2");
////            throw new ArithmeticException();
//
//        }finally{
//            System.out.println("Blok finaly2");
//        }


        //        try{
//            ExceptionsPruebas.devide(0,2);
////            ExceptionsPruebas.devide(2,0);
//
//            try{
//                ExceptionsPruebas.devide(1,2);
//                ExceptionsPruebas.devide(1,0);
//                ExceptionsPruebas.array();
//            } /*catch(ArithmeticException e ){
//                System.out.println("AricmeticException vnytriwnoho try cahc: " + e);
//            } */catch(ArrayIndexOutOfBoundsException e){
//                System.out.println(e);
//            }
//
//        }catch(ArithmeticException e){
//            System.out.println("AricmeticException zovniwnoho try cach: " + e);
//        }

    }

}
