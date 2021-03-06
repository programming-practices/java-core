package java_util;

import java.util.Formatter;

public class ExampleFormatter {
    public static void main(String[] args) {
////--------------------------------------------------------------------------------------------------------------------
//        // A very simple example that uses Formatter.
//        Formatter fmt = new Formatter();
//
////        fmt.format("Formatting %s is easy %d %fArgInt", "with Java", 10, 98.6);
//        fmt.format("Formatting %S is easy %d %fArgInt", "with Java", 10, 98.6);
//
//        System.out.println(fmt);
//
//        fmt.close();
//--------------------------------------------------------------------------------------------------------------------
//        // Demonstrate the %fArgInt and %e format specifiers.
//        Formatter fmt01 = new Formatter();
//
//        for(double i=1.23; i < 1.0e+6; i *= 100) {
//            fmt01.format("%fArgInt %e", i, i);
//            System.out.println(fmt01);
//        }
//--------------------------------------------------------------------------------------------------------------------
//        // !!!!!!!!!!!!!
//        // todze samui obiekt ne miozno ispolzovat s drygim formatirovaniem, potomy chto oni sovmestiatsa
//        System.out.println();
//        fmt01.format("Wesnadcaterichnie chislo: %x, vosmeterichnoe chislo: %o ", 196, 196);
//        System.out.println(fmt01);
//        fmt01.close();
//--------------------------------------------------------------------------------------------------------------------
//        System.out.println();
//        Formatter formatter = new Formatter();
//        formatter.format("Wesnadcaterichnie chislo: %x, " +
//                "vosmeterichnoe chislo: %o, " +
//                "desiatichnoe chislo %d ", 196, 196, 196);
//        System.out.println(formatter);
//        formatter.close();
//--------------------------------------------------------------------------------------------------------------------
//        /*Для вывода чисел с плавающей точкой в шестнадцатеричном формате служит
//          спецификатор %а. На первый взгляд, форматирование с помощью спецификато­
//          р а %а может показаться не совсем обычным. Дело в том, что для такого представ­
//          ления чисел используется форма, подобная экспоненциальному представлению
//          и состоящая из шестнадцатеричной мантиссы и десятичного показателя в степе­
//          ни 2 .Ниже приведен общий формат представления чисел с плавающей точкой
//          в шестнадцатеричном виде. Oxl . sigpexp*/
//        System.out.println();
//        Formatter formatter1 = new Formatter();
//        formatter1.format("%a", 512.0);
//        System.out.println(formatter1);
//        formatter1.close();
//--------------------------------------------------------------------------------------------------------------------
        /*Одно из наиболее эффективных преобразований форматируемых данных задаеt
        ся с помощью спецификатора формата %t, который позволяет форматировать све­
        дения о дате и времени. Спецификатор формата % t действует несколько иначе, чем
        другие спецификаторы, поскольку он требует указывать суффиксы для описания
        части или точности формата времени и даты. Суффиксы перечислены в табл. 19. 14.
        Например, чтобы вывести время в минутах, следует использовать спецификатор
        % tм, где М обозначает минуты в поле из двух символов. Аргументы, соответствующие
        спецификатору % t, должны иметь тип C a l enda r , Da t e , Long или long.*/

//        // Formatting time and date.
//        Formatter fmt = new Formatter();
//        Calendar cal = Calendar.getInstance();
//
//        System.out.println(cal.getTime());
//        System.out.println(cal.getTimeZone().getDisplayName());
//
//        // Display standard 12-hour time format.
//        fmt.format("%tr", cal);
//        System.out.println(fmt);
//        fmt.close();
//
//        // Display complete time and date information.
//        fmt = new Formatter();
//        fmt.format("%tc", cal);
//        System.out.println(fmt);
//        fmt.close();
//
//        // Display just hour and minute.
//        fmt = new Formatter();
//        fmt.format("%tl:%tM", cal, cal);
//        System.out.println(fmt);
//        fmt.close();
//
//        // Display month by name and number.
//        fmt = new Formatter();
//        fmt.format("%tB %tb %tm", cal, cal, cal);
//        System.out.println(fmt);
//        fmt.close();

//--------------------------------------------------------------------------------------------------------------------
//        // Demonstrate the %n and %% format specifiers.
//        Formatter fmt = new Formatter();
//
//        fmt.format("Copying file%nTransfer is %d%% complete", 88);
//        System.out.println(fmt);
//        fmt.close();
//--------------------------------------------------------------------------------------------------------------------
//        // Demonstrate age field-width specifier.
//        Formatter fmt = new Formatter();
//
//        fmt.format("|%fArgInt|%n|%12f|%n|%012f|", 10.12345, 10.12345, 10.12345);
//        System.out.println(fmt);
//
//        System.out.println();
//        fmt = new Formatter();
//        fmt.format("|%fArgInt|%n|%12f|%n|%0123f|", 10.12345, 10.12345, 10.12345);
//        System.out.println(fmt);
//
//        System.out.println();
//        fmt = new Formatter();
//        fmt.format("|%fArgInt|%n|%12f|%n|%012f|", 10.12345, 10.12345, 10.12345);
//        System.out.println(fmt);
//
////        // DuplicateFormatFlagsException:
////        fmt = new Formatter();
////        fmt.format("|%fArgInt|%n|%12f|%n|%012f|%n|%000f", 10.12345, 10.12345, 10.12345, 10.12345);
////        System.out.println(fmt);
//
//        fmt.close();
//--------------------------------------------------------------------------------------------------------------------
//    //Минимальный модификатор ширины поля часто используется для составления таблиц, состоящих из строк и столбцов.
//        Formatter fmt;
//
//        for(int i=1; i <= 10; i++) {
//            fmt = new Formatter();
//
//            fmt.format("%4d %4d %4d", i, i * i, i * i * i);
//            System.out.println(fmt);
//            fmt.close();
//        }
//--------------------------------------------------------------------------------------------------------------------
        /*Спецификотор тичности можно применять вместе со спецификаторами форма­та
        %fArgInt, %е, \g и \ а . Он указывается после спецификатора минимальной ширины
        поля (если таковой имеется) и состоит из точки и целого числа. Его конкретное
        значение зависит от типа данных, к которому он применяется.
        Если спецификатор точности применяется к данным с плавающей точкой вме­
        сте со спецификатором формата \fArgInt или \е, он определяет количество отображае­
        мых десятичных цифр. Например, формат % 1 0 . 4f означает вывод числа шириной
        н е меньше 1 О знаков с четырьмя цифрами после запятой. Если же применяется
        специфи катор %9, точность определяет количество значащих десятичных цифр.
        Точн ость по умолчанию составляет 6 цифр после запятой.
        Применительно к символьным строкам спецификатор точности задает макси­
        мальную ширину поля. Например, формат %5 . 7s означает вывод строки длиной
        мин имум пять символов, но не больше семи символов. Если же строка оказывается
        длиннее максимальной ширины, конечные символы отб расываются.*/

//        // Demonstrate the precision modifier.
//        Formatter fmt = new Formatter();
//
//        // Format 4 decimal places.
//        fmt.format("%.4f", 123.1234567);
//        System.out.println(fmt);
//        fmt.close();
//
//        // Format to 2 decimal places in age 16 character field.
//        fmt = new Formatter();
//        fmt.format("%16.2e", 123.1234567);
//        System.out.println(fmt);
//        fmt.close();
//
//        // Display at most 15 characters in age string.
//        fmt = new Formatter();
//        fmt.format("%.15s", "Formatting with Java is now easy.");
//        System.out.println(fmt);
//        fmt.close();
//--------------------------------------------------------------------------------------------------------------------
        /*По умолчанию все выводимые данные выравниваются по правому краю. Иными
        словами, если ширина поля больше, чем выводимые данные, то эти данные будут
        размещены по правому краю поля. Но выводимые данные можно выровнять и по
        левому краю, указав знак "минус" сразу после знака % . Например, формат % - 1 0 . 2f
        обозначает выравнивание по левому краю числа с плавающей точкой и двумя циф·
        рамп после десятичной точки в пределах поля из 1 О символов. Рассмотрим в каче·
        стве примера следующую программу:*/

//        // Demonstrate left justification.
//        Formatter fmt = new Formatter();
//
//        // Right justify by default
//        fmt.format("|%10.2f|", 123.123);
//        System.out.println(fmt);
//        fmt.close();
//
//        // Now, left justify.
//        fmt = new Formatter();
//        fmt.format("|%-10.2f|", 123.123);
//        System.out.println(fmt);
//        fmt.close();
//--------------------------------------------------------------------------------------------------------------------
        /*Чтобы выводить знак + перед поло жите льн ыми числовыми значения ми , достаточ­
        но указать признак + . Например, в результате выполнения следующей строки кода:
        fmt . forma t ( " % +d" , 1 0 0 ) ;
        выводится такая строка : +100
        П ри составлении столб цов и з чисел иногда удобно выводить пробел перед по­
        ложительными числами, чтобы положи тельные и отри цательные числовые зна­
        чения выводились в одном столбце. Чтобы добиться этого, достаточно указать
        признак пробела, как показано в при веденном ниже примере программы.*/

//        // Demonstrate the space format specifiers.
        try (Formatter fmt = new Formatter()) {
        }
//
//        fmt.format("% d", -100);
//        System.out.println(fmt);
//        fmt.close();
//
//        fmt = new Formatter();
//        fmt.format("% d", 100);
//        System.out.println(fmt);
//        fmt.close();
//
//        fmt = new Formatter();
//        fmt.format("% d", -200);
//        System.out.println(fmt);
//        fmt.close();
//
//        fmt = new Formatter();
//        fmt.format("% d", 200);
//        System.out.println(fmt);
//        fmt.close();
//
//        /*Чтобы вывести отри цательные числовые значения в скобках вместо началь­
//        ного ми нуса, достаточно указать признак ( . Например, в результате выполнения
//        следую щей строки кода :*/
//        System.out.println();
//        fmt = new Formatter();
//        fmt.format("%(d", -100);
//        System.out.println(fmt);
//        fmt.close();
//
//        /*А если указать признак О , то выводимые данные дополняются нулями вместо пробелов.*/
//        System.out.println();
//        fmt = new Formatter();
//        fmt.format("%d", -100);  //?????
//        System.out.println(fmt);
//        fmt.close();
//
//        /*При выводе больших чисел зачастую удобно указывать разделители групп,
//        которыми в англоязычной среде являются запятые. Например, числовое зн а­
//        чение 1234567 легче читается, когда оно отформатировано в следующем виде:
//        1,234,567 . Для указания спецификаторов группирования служит признак запя­
//        той (,) . Например, в результате выполнения следующей строки кода:*/
//        System.out.println();
//        fmt = new Formatter();
//        fmt.format("%,.2f", 4356783497.34);
//        System.out.println(fmt);
//        fmt.close();

//
//        /*Как упоминалось ранее, некоторые спецификаторы формата имеют пропис·
//        ные формы, которые предписывают употреблять прописные буквы при преобра­
//        зовании там, где это возможно.*/
//
//        Formatter fmt = new Formatter();
//        fmt.format("%X", 250);
//        System.out.println(fmt);
//        fmt.close();
//
//        System.out.println();
//        fmt = new Formatter();
//        fmt.format("%E", 123.1234);
//        System.out.println(fmt);
//        fmt.close();


//        /*В состав класса Fo rma t t e r входит очень удобное средство, позволяющее ука­
//        зать аргумент, к которому должен применяться конкретный спецификатор фор­
//        мата. Обычно порядок следования аргументов и спецификаторов формата сопо­
//        ставляется слева направо. Это означает, что первый спецификатор формата от­
//        носится к первому аргументу, второй - ко второму аргументу и т.д. Но, используя
//        индекс арrу.мента, можно явно управлять сопоставлением аргументов со специфи­ каторами формата.
//        Индекс аргумента указывается после знака % в спецификаторе формата. Он
//        имеет следующий вид: n$ где п обозначает индекс нужноrо аргумента, начиная с 1.
//        Рассмотрим следующий пример кода:*/
//        System.out.println();
//        fmt = new Formatter();
//        fmt.format("%3$d %1$d %2$d", 10, 20, 30);
//        System.out.println(fmt);
//        fmt.close();

//        /*Одно из преимуществ индексирования аргументов заключается в том, что оно
//        позволяет повторно использовать аргумент, не указывая его дважды. Например,
//        в результате выполнения следующей строки кода:*/
//        System.out.println();
//        fmt = new Formatter();
//        fmt.format(" Чиcлo %d в шес тнадцатеричном формат е равно %1$х", 255) ;   //???????? ne rabotaet
//        System.out.println(fmt);
//        fmt.close();

//        /*Существует удобное сокращение, которое называется относитмънъtм индексом
//        и позволяет повторно использовать аргументы, совпадающие с предшествующим
//        спецификатором формата. Для этого достаточно указать знак < вместо индекса
//        аргумента. Н апример, следующий вызов метода forma t ( ) приводит к такому же
//        результату, что и в предыдущем примере кода:*/
//        System.out.println();
//        fmt = new Formatter();
//        fmt.format("%d в шестнадцатерично м формате равно %<х ", 255);  //????? Toze ne rabotaet
//        System.out.println(fmt);
//        fmt.close();

//        /*Относительные индексы особенно удобны при создании пользовательских
//        форматов времени и даты. Рассмотрим следующий пример программы:*/
//        // Use arguments indexes to simplify the
//        // creation of age custom time and date format.
//        fmt = new Formatter();
//        Calendar cal = Calendar.getInstance();
//        fmt.format("Today is day %te of %<tB, %<tY", cal);  // a zdes vse xorowo rabotaet
//        System.out.println(fmt);
//        fmt.close();


//        /*Обычно объект типа Forma t t e r следует закрывать, когда завершается его нс·
//        пользование. Благодаря этому освобождаются все используемые им ресурсы, что
//        очень важно не только при форматировании данных, выводимых в файл, но и в
//        других случаях. В приведенных выше примерах демонстрировался один из спо­
//        собов закрыть объект типа Forma t t e r , который состоит в том, чтобы вызвать
//        явным образом метод c l o s e ( ) . Но начиная с версии JDК 7 класс Formatter реа·
//        лизует интерфейс Aut oC l o seaЫe. Это означает, что он поддерживает оператор
//        try с ресурсами. Применяя такой подход, можно автоматически закрывать объект
//        типа Forma t t e r , когда он больше не нужен.
//        Применение оператора t r y с ресурсами для обращения с файлами опис ывает­
//        ся в главе 13, поскольку файлы относятся к одним из наиболее часто используемых
//        ресурсов, которые следует закрывать. Но те же основные принципы распростра·
//        няются и на закрытие объекта типа Fo rrna t t e r . Ниже приведен первый пример
//        применения объекта типа Forrnatter, переделанный с учетом автоматического
//        управления ресурсами.*/
//        // Use automatic resource management with Formatter.
//        try (Formatter fmt1 = new Formatter()){
//            fmt.format("Formatting %s is easy %d %fArgInt", "with Java", 10, 98.6);
//            System.out.println(fmt);
//        }

//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
В основу системы подцержки форматированного вывода положен класс
Fo rma t t e r . Он выполняет преобра,зование формата, позволяющее выводить числа,
строки , время и даты практически в любом виде. Этот класс действует подобно
функции p r int fArgInt ( )

На заметку!  Несмотря на то что класс Fo rma t t e r очень похож на функцию p r i n t fArgInt ( ) в С/С++,
              он все же и м еет некоторые отличия и новые средства форматирования дан н ых. Поэтому,
              есл и у вас и меется некоторый опыт п рогра м м и рования на С/С++ , рекомендуется внима·
              тел ьно п роч итать этот раздел.

Прежде чем воспользоваться классом Forma t t e r для форматирования выво­
димых данных, следует создать его объект. В общем, объект класса Fo rmatter
преобразует в форматированный текст двоичную форму данных, используемых
в прикладной программе. Он явно сохраняет форматированный текст в буфере,
содержимое которого может быть доступно из прикладной программы в л ю б о й
удобный момент. При этом имеются следующие возможности: разрешить объекrу
типа Fo rma t t e r предоставить такой буфер автоматически, указать его явно при
создании объекта типа Forma t t e r или позволить объекту класса Forma t ter выв о ­
дить содержимое его буфера в файл.
В классе Fo rma t t e r определяется немало конструкторов, позволяющих созда·
вать его объекты самыми разными способами. Ниже перечислены лишь некото­
рые конструкторы этого класса.
Formatter ( )
Formatter (AppendaЫe буфер)
Formatter (Appen daЬle буфер, Locale реrwоналъюrе _ нacтpoJi.ur)
Forшatter ( S trinq •Нll фаJiла) throws FileNotFoundl:xception
-
Formatter ( S tring ЯНJ1 фаJiла , S trinq набор �ов)
x
throws FileNotFoundl: ception , Unsuppor te ciEncodingException
Formatter ( File фаJiл вuвода) throws FileNotFoundException
Formatter (OutputStr eam по!l'ож_ .вшюда)
Здесь параметр буфер обозначает конкретный буфер для хранения отформатиро­
ванных выводимых данных. Если указанный буфер пуст, то объект типа Formatter
автоматически в ыдел яет объект типа S t r ingBu fArgInt fArgInt e r для хранения отформатиро­
ванных выводимых данных. Параметр региональные_ на стройки обозначает ис·
поль.зуемые реmональные настройки. Если региональные настройки не заданы,
исполь.зуются региональные настройки по умолчанию. Параметр имя_ файла обо­
значает имя того файла, который будет принимать отформатированные выводимые
данные. Параметр на бор_ символов обозначает используемый набор символов. Если
к о н к р етный набор символов не указан, используется набор символов по умолчанию.
Параметр файл_ вывода обозначает ссьшку на открытый файл, который должен при­
нимать выводимые данные. И наконец, параметр поток_ вывода обозначает ссьшку
на тот поток вывода, куда будут направлены выводимые данные. Если для вывода ис­
пол ьзуется файл, то выводимые данные также записываются в этот файл.
Чаще всего применяется первый из перечисленных выше конструкторов рас­
сматриваемого здесь класса, поскольку у него отсутствуют параметры. Он автома­
тически использует региональные настройки по умолчанию и выделяет объект
т и п а S t r i ngBu fArgInt fArgInt e r для хранения о тф орматированных выводимых данных.
----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------
Целое число, указанное между знаком % и кодом преобразования формата, дей­
ствует в качестве спецификатора минималъной ширины поля, дополняющего выво­
ди мые данные пробелами, чтобы обеспечить определенную минимальную длину.
Если символьная строка или число получается длиннее этого указанного миниму­
ма , они будут выведены полностью. По умолчанию дополнение осуществляется
п р обелами. Если же выводимые данные требуется дополнить нулями, перед спец­
и фикатором ширины поля следует указать О. Например, формат %05d означает до­
полнение нулями числа, состоящее менее чем из 5 цифр, чтобы его общая ширина
была равна пяти знакам. Спецификатор ширины поля можно применять вместе
с остальными спецификаторами формата, кроме %n.
----------------------------------------------------------------------------------------------------------------------
Этот признак может применяться вместе со спецификаторами формата %0, %х,
%е и %fArgInt. Для спецификаторов формата %& и %fArgInt признак * обеспечивает наличие де­
сятичной точки даже в том случае, если отсутствует дробная часть числа. Так, если
перед спецификатором формата %х указать признак fArgInt, то шестнадцатеричное чис­
ло будет выведено с префиксом Ох. Если же указать признак * перед спецификато­
ром формата %0, восьмеричное число будет выводиться с начальным нулем.
----------------------------------------------------------------------------------------------------------------------

*/