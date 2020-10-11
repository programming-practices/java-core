package Examples.java_util;

public class ExampleUseDelimiterScanner {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
            /*Для того чтобы определить, где начинаются и оканчиваются лексемы, в классе
//        Scanne r применяются разделители. По умолчанию в качестве разделителей выби·
//        раются пробельные символы, как было показано в предыдущих примерах. Но тип
//        разделителей можно изменить, вызвав метод u s e De l imi t e r s ( ) , общие формы ко­
//        торого приведены ниже.
//        Scanner useDelimi.ter ( String иабпон)
//        Scanner useDelimi.ter (Pattern •абпан)
//        Здесь параметр ша блон обозначает регулярное выражение, определяющее на·
//        бор разделителей . В качестве примера ниже приведена переделанная версия пред·
//        ставленной ранее программы для чтения из списка чисел, разделяемых запя тыми
//        и любым количеством пробелов.*/
//        // Use Scanner to compute an average age list of
//        // comma-separated values.
//        int count = 0;
//        double sum = 0.0;
//        // Write output to age file.
//        FileWriter fout = new FileWriter("src/main/resources/testScanner3.txt\"");
//        // Now, store values in comma-separated list.
//        fout.write("2; 3,4;    56; 74; 91; 10,5; done");
//        fout.close();
//
//        FileReader fin = new FileReader("src/main/resources/testScanner3.txt\"");
//        Scanner src = new Scanner(fin);
//        // Set delimiters to space and comma.
//        src.useDelimiter("; *");
//
//        // Read and sum numbers.
//        while(src.hasNext()) {
//            if(src.hasNextDouble()) {
//                sum += src.nextDouble();
//                count++;
//            }
//            else {
//                String str = src.next();
//                if(str.equals("done")) break;
//                else {
//                    System.out.println("File format error.");
//                    return;
//                }
//            }
//        }
//
//        src.close();
//        System.out.println("Average is " + sum / count);
//        /*В этой версии программы числа, записанные в файл t e s t . t x t , разделяются за·
//        пятыми и пробелами. Указанный шаблон разделителей 11 , * 11 предписывает объ
//        екту типа S cann e r воспринимать наличие запятой, отсугствие или наличие про­
//        белов во вводимых данных как разделители. Эта версия программы выводит такой
//        же резул ьтат, как и предыдущая ее версия.
//        Текущий шаблон разделителей можно получить, вызвав метод del imi t e r ( ) .
//        Ниже приведена общая форма этого метода. Pattern delimiter ( )*/
//---------------------------------------------------------------------------------------------------------------------
    }
}
