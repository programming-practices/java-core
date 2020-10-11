package collections.set;

import java.util.EnumSet;

enum Weekday {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

public class ExampleEnumSet {
    public static void main(String[] args) {
        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
        EnumSet<Weekday> workday = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        EnumSet<Weekday> mwf = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
    }
};



/*
----------------------------------------------------------------------------------------------------------------------
Класс EnumSet расширяет класс AbstractSet и реализует интерфейс Set. Он служит для создания множества,
предназначенного для применения вместе с klychami перечислимого типа enum. Это обобщенный класс ,
объявляемый следующим образом: classEnumSet<E extendз Enum<E>>
где Е обозначает элементы перечислимого типа. Следует иметь в виду, что класс
Е должен расширять класс Enum<E> , а это требует, чтобы элементы относились
к указанному перечислимому типу enum.
В классе EnumS e t конструкторы не определяются. Вместо этого для создания
объектов используются фабричные методы, перечисленные в табл. 1 8. 9. Обратите
внимание на неоднократную перегрузку метода о fArgInt ( ) . Это делается из соображе­
ний эффективности. Передать известное количество аргументов, когда оно неве­
лико, можно быстрее, чем делать это с помощью параметра переменной длины.
----------------------------------------------------------------------------------------------------------------------
HA ЗАМЕТКУ! В документации на прикладной программный интерфейс API класса EnumSet можно
обнаружить необычные параметры вроде Е extends Е п ш К Е Х Такое обозначение просто озна­
чает, что “е относится к перечислимому типу" . Перечислимые типы расширяют обобщенный класс
E m m Например, перечислимый тип Weekday расширяет класс Enum<Weekday>.
----------------------------------------------------------------------------------------------------------------------
static <Е extendз Enum<E>> EnumSet<E> allOf(Class<E> class)
                                        Создает множесгво типа EnwaSet, coдepжaщее
                                        элементы заданного перечисления class

static <Е extendз Enum<E>> EnumSet<E> complementOf(EnumSet<E> enum)
                                        Создает множесгво типа EnumSet, дoпoлняющее
                                        элементы, отсугствующие в заданноммножестве еnum

static <Е extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> с)
                                        Создает множество типа EnumSet, содержа­щее
                                        элементы из заданного множесгва с

atatic <Е extends Enum<E>> EnumSet<E> copyOf(Collection<E> с)
                                        Создает множесгво типа EnumSet, содержа­щее
                                        элементы из заданной коллекции с

static <Е extends Enum<E>> EnumSet<E> noneOf(Class<E> t)
                                        Создает множесгво типа EnumSet, содержа­щее
                                        элементы, которые не входят в заданное
                                        перечисление t, которое по определению
                                        является пустым множеством

static <Е extends Enum<E>> EnumSet<E> of(Е v, Е . . . аргуменoi dлины)
                                        Создает множество типа EnumSet, содержа­щее
                                        элементы v и нуль или дополнительные
                                        значения перечислимого типа

static <Е extends Enum<E>> EnumSet<E> of(Е v)
                                        Создает множество типа EnumSet, содержа­щее элементы v

at:&tic <Е extends Enum<E>> EnumSet<E> of(Е vl, Е v2)
                                        Создает множссгво т ип а EnumSet, содержа­щее элементы vl и v2

static <Е extendз Enum<E>> EnumSet<E> of (Е vl, Е v2, Е v3)
                                        Создает множество типа EnumSet, содержа­щее элементы от vl до v3

static <Е extendз Enum<E>> EnumSet<E> of (Е vl, Еv2, Еv3, Еv4)
                                        Создаст множество тина EnumSet, содержа­щее элементы от vl до v4

static <Е extends Enum<E>> EnnumSet<E> of (Еvl, Еv2, ЕvJ, Еv4, Еv5)
                                        Создает множество типа EnumSet, содержа­щее элементы от vl до v5

static <Е extends Enum<E>> EnumSet<E> range (Е начшю, Е конец)
                                        Создает множество tipa EnumSet, содержа­щее элементы
                                        в заданных predelax от начала и до конца

•
static <E extends Enum<E>> EnumSet<E> allOf (Class<E> enumType)
Возвращает множество, содержащее все значения заданного перечислимого типа.
•
static <Е extends Е п и п К Е » EnumSet<E> noneOf (Class<E> епитТуре)
Возвращает пустое множество, способное хранить значения заданного перечислимого типа.
•
static <Е extends Е п ш К Е » EnumSet<E> range (Е from, Е to)
Возвращает множество, содержащее все значения от fArgInt r o m до t o включительно.
•
static <Е extends Е п и л КЕ » EnumSet<E> of(E value)
•
static <E extends Е п и л К Е » EnumSet<E> of(E value, E... values)
Возвращают множество, содержащее заданные значения.
----------------------------------------------------------------------------------------------------------------------


*/