package java_util;

import java.io.IOException;

public class ExampleScanner {
    public static void main(String[] args) throws IOException {
//---------------------------------------------------------------------------------------------------------------------
//        /*В следующем фрагменте кода создается объект типа S canner для чтения дан­
//        ных из файла tem.Test.txt:*/
//        FileReader fin = new FileReader("tem.Test.txt" ) ;
//        Scanner src = new Scanner( fin ) ;
//        /*Этот код оказывается работоспособным потому, что класс F i l eReade r реали­
//        зуе т интерфейс ReadaЫe . Следовательно, вызов конструктора интерпретируется
//        кaк Scanner(Readabe).*/
//
//        /*В следующей строке кода создается объект типа S cann e r для чтения данных из
//        стандартного потока ввода, которым по умолчанию является клавиатура:*/
//        Scanner conin = new Scanner(System.in);
//
//
//        /*В приведенном ниже фрагменте кода создается объект типа S canne r для чте·
//        ния данных из символьной строки.*/
//        String instr = "10 99.88 сканировать очень просто." ;
//        Scanner conin2 = new Scanner(instr) ;
//---------------------------------------------------------------------------------------------------------------------
//        // Use Scanner to compute an average of the values.
//        Scanner conin01 = new Scanner(System.in);
//
//        int count = 0;
//        double sum = 0.0;
//
//        System.out.println("Enter numbers to average.");
//
//        // Read and sum numbers.
//        while(conin01.hasNext()) {
//            if(conin01.hasNextDouble()) {
//                sum += conin01.nextDouble();
//                count++;
//            }
//            else {
//                String str = conin01.next();
//                if(str.equals("done")) break;
//                else {
//                    System.out.println("Data format error.");
//                    return;
//                }
//            }
//        }
//        conin01.close();
//        System.out.println("Average is " + sum / count);
//---------------------------------------------------------------------------------------------------------------------
//        // Use Scanner to compute an average of the values in age file.
//        int count = 0;
//        double sum = 0.0;
//
//        // Write output to age file.
//        FileWriter fout = new FileWriter("src/main/resources/testScanner.txt");
//        fout.write("2 3,4 5 6 7,4 9,1 10,5 done");//ostorozno s komoi i tochkoi(3.4 nerobotaet)(3,4 rabotaet)
//        fout.close();
//
//        FileReader fin = new FileReader("src/main/resources/testScanner.txt");

//        Scanner src = new Scanner(fin);
//
//        // Read and sum numbers.
//        while(src.hasNext()) {
//            if(src.hasNextDouble()) {
//                sum += src.nextDouble();
//                System.out.println(sum);
//                count++;
//            }else {
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
//
//        try(Scanner src = new Scanner(fin)) {
//            // Read and sum numbers.
//            while(src.hasNext()) {
//                if(src.hasNextDouble()) {
//                    sum += src.nextDouble();
//                    System.out.println(sum);
//                    count++;
//                }else {
//                    String str = src.next();
//                    if(str.equals("done")) break;
//                    else {
//                        System.out.println("File format error.");
//                        return;
//                    }
//                }
//            }
//            System.out.println("Average is " + sum / count);
//        }
//---------------------------------------------------------------------------------------------------------------------
//        // Use Scanner to read various types of data from age file.
//        int i;
//        double d;
//        boolean b;
//        String str;
//
//        // Write output to age file.
//        FileWriter fout = new FileWriter("src/main/resources/testScanner2.txt");
//        fout.write("Testing Scanner 10 12,2 one true two false");// ostorozno s 12.2  i  12,2
//        fout.close();
//
//        FileReader fin = new FileReader("src/main/resources/testScanner2.txt");
//        Scanner src = new Scanner(fin);
//
//        /*При чтении разнотипных данных, как в данном примере программы, следует
//        внимательнее следить за порядком, в котором вызываются методы next. Так, если
//        поменять в цикле порядок вызова методов nex t l n t { ) и next DouЫe ( ) , то оба
//        числовых значения будут прочитаны как относящиеся к типу douЬ l e , поскольку
//        метод nex t DouЫe { ) обнаруживает совпадение с любой символьной строкой, со­
//        держащей число, которое может быть представлено типом douЫe .*/
//        // Read to end.
//        while(src.hasNext()) {
//            if(src.hasNextInt()) {
//                i = src.nextInt();
//                System.out.println("int: " + i);
//            } else if(src.hasNextDouble()) {
//                d = src.nextDouble();
//                System.out.println("double: " + d);
//            } else if(src.hasNextBoolean()) {
//                b = src.nextBoolean();
//                System.out.println("boolean: " + b);
//            } else {
//                str = src.next();
//                System.out.println("String: " + str);
//            }
//        }
//
//        src.close();
//---------------------------------------------------------------------------------------------------------------------
//        /*Для того чтобы определить, где начинаются и оканчиваются лексемы, в классе
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
//        /*В классе Scanne r определяется ряд других методов, помимо упомянугых ранее.
//        В частности, одним из наиболее полезных в некоторых случаях является метод
//        findinLine ( ) . Его общие формы представлены ниже.
//        Strinq findinLine (Pattern 1raб.lraи)
//        Strinq findinLine ( Strinq .аrа б.паи)
//        Этот метод осуществляет поиск на совпадение с указанным шаблоном в следу­
//        строке текста . Если совпадение обнаружено, то соответствую щая этому ша­
//        блону лексема употребляется и возвращается. В противном случае возвращается
//        пустое значение nu l l . Это метод действует независимо от установленного набора
//        разделителей. Он удобен, если требуется обнаружить совпадение с конкретным
//        шаблоном. Так, в следующем примере программы сначала обнаруживается поле
//        возраста во введенной символьной строке, а затем выводится его содержимое.*/
//        // Demonstrate findInLine().
//        String instr = "Name: Tom Age: 28 ID: 77";
//
//        Scanner conin = new Scanner(instr);
//
//        // Find and display age.
//        conin.findInLine("Age:"); // find Age
//
//        if(conin.hasNext())
//            System.out.println(conin.next());
//        else
//            System.out.println("Error!");
//
//        conin.close();
//---------------------------------------------------------------------------------------------------------------------
    }
}
