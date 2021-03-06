package collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExampleLinkedHashMap {
    public static void main(String[] args) {
//--------------------------------ExampleRemoveEldesEntryLinkedHashMap-------------------------------------------------
        /*Порядок доступа удобен для реализации дисциплины кеширования с так называемым "наиболее давним использованием".
        Допустим, требуется сохранять часто используемые элементы в памяти и вводить менее часто используемые элементы
        из базы данных. Если нужный элемент не обнаруживается в таблице, а таблица уже почти заполнена, тогда можно получить
        итератор таблицы и удалить несколько первых элементов, которые он перечисляет. Ведь эти элементы использовались очень
        давно. Данный процесс можно даже автоматизировать. Для этого достаточно образовать подкласс, производный от класса
        LinkedHashMap, и переопределить в нем слдующий метод:
                            protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
        И тогда при вводе нового элемента будет удаляться самый старый (eldest) элемент всякий раз, когда данный метод
        возвратит логическое значение true. Так, в следующем примере кода максимальный размер кеша поддерживается на уровне 100
        элементов:*/
//        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(6);
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(6) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
//                return super.removeEldestEntry(eldest);
                return size() > 5;
            }
        };

//      String str[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20"};
        String str[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "a", "b", "c", "d", "e", "fArgInt", "g", "h", "i", "j"};
        for (String value : str) {
            int j = 0;
            for (int i = 0; i < value.length(); i++) {
                j += (int) value.charAt(i);
            }
//            System.out.println("size is: " + linkedHashMap.size());
            linkedHashMap.put(j, value);
        }
        for (int int1 : linkedHashMap.keySet()) {
            System.out.println(int1 + ": " + linkedHashMap.get(int1));
        }
//----------------------------------------------------------------------------------------------------------------------------------------
        Map<Integer, String> linkedHashMap1 = new LinkedHashMap<>();

        /*Только что созданный объект linkedHashMap, помимо свойств унаследованных от HashMap (такие как table,
           loadFactor, threshold, size, entrySet и т.п.), так же содержит два доп. свойства:
                      header — «голова» двусвязного списка. При инициализации указывает сам на себя;
                      accessOrder — указывает каким образом будет осуществляться доступ к элементам при
                      использовании итератора. При значении true — по порядку последнего доступа.
                      При значении false доступ осуществляется в том порядке, в каком элементы были вставлены.

            Конструкторы класса LinkedHashMap достаточно скучные, вся их работа сводится к вызову конструктора
            родительского класса и установке значения свойству accessOrder. А вот инициализация свойства header происходит в                      переопределенном методе init() (теперь становится понятно для чего в конструкторах класса HashMap
            присутствует вызов этой, ничегонеделающей функции).*/
//---------------------------------------------------------------------------------------------------------------------------------------

        /*  А теперь давайте рассмотрим пример когда свойство accessOrder имеет значение true.
          В такой ситуации поведение LinkedHashMap меняется и при вызовах методов get() и put()
          порядок элементов будет изменен — элемент к которому обращаемся будет помещен в конец.
            Kohda accessOrder: true to poriadok sohlasno dostypa k elementy,
          toest element kotorui vukorestali o vuzvali stanovitsa v konec mapu. Na eto svoistvo vliayt
          tolko metodu get() i put().
            Kohda accessOrder: false ( ystanovleno po ymolchaniy ) to poriadok sohalsno vstavke v map*/

//        Map<Integer, String> linkedHashMap =
//            new LinkedHashMap<Integer, String>(15, 0.75f, true /*false*/) {{
//            put(1, "obj1");
//            put(15, "obj15");
//            put(4, "obj4");
//            put(38, "obj38");
//            put(98, "obj98");
//        }};
//        // {1=obj1, 15=obj15, 4=obj4, 38=obj38}
//        System.out.println(linkedHashMap);
//
//        linkedHashMap.get(1);  /*or*/ /*linkedHashMap.put(1, "Object1");*/
//        linkedHashMap.get(1);
//        // {15=obj15, 4=obj4, 38=obj38, 1=obj1}
//        linkedHashMap.get(4);
//        //        linkedHashMap.get(4);
//        System.out.println(linkedHashMap);
//        linkedHashMap.get(1);
//        System.out.println(linkedHashMap);
//        linkedHashMap.get(4);
//        linkedHashMap.get(4);
//        System.out.println(linkedHashMap);
//        linkedHashMap.get(15);
//        System.out.println(linkedHashMap);
//        System.out.println("--------------------------------------------------------------------------------------------------------");
//---------------------------------------------------------------------------------------------------------------------------------------
        // 1.
//        Iterator<Map.Entry<Integer, String>> itr1 = linkedHashMap.entrySet().iterator();
//        while (itr1.hasNext()) {
//            Map.Entry<Integer, String> entry = itr1.next();
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }
//
//        // 2.
//        Iterator<Integer> itr2 = linkedHashMap.keySet().iterator();
//        while(itr2.hasNext()) System.out.println(itr2.next());
//
//        // 3.
//        Iterator<String> itr3 = linkedHashMap.values().iterator();
//        while (itr3.hasNext()) System.out.println(itr3.next());

        /*Ну и не забывайте про fail-fast. Коли уж начали перебор элементов — не изменяйте
            содержимое или заранее позаботьтесь о синхронизации.*/
//---------------------------------------------------------------------------------------------------------------------------------------
//        Map<Integer, String> linkedHashMap2 = new LinkedHashMap<>();
//        linkedHashMap2.put(3, "c");
//        linkedHashMap2.put(2, "d");
//        linkedHashMap2.put(4, "b");
//        linkedHashMap2.put(1, "e");
//        linkedHashMap2.put(5, "a");
//        for(Map.Entry<Integer, String> map: linkedHashMap2.entrySet()){
//            System.out.println(map.getKey() + ", " + "\"" + map.getValue() + "\"");
//        }
    }
}

/*
------------------------------------------------------------------------------------------------------------------------------------------
Ostorozno zdes esli nado zberihat class "zdelanui vlasnorychno" v LinkedHashMap()
to nado realizovat metod hashCode(), potomy chto esli ne realizovat metod hashCode() to
ne polychica soxranennie v vide xewei a v vide sviaznoho spiska (polychitsa chtoto poxozoe na LinkedList)
------------------------------------------------------------------------------------------------------------------------------------------
Если параметр порядок принимает ло­гическое значение true , то используется порядок доступа, а сели он принимает
логическое значение false порядок ввода элементов.
------------------------------------------------------------------------------------------------------------------------------------------
В классе L i n kedHa s hMap добавляется только один новый метод к тем, что опре­
делены в классе H a s hMap. Это метод r emove E l de s t E n t ry ( ) , общая форма которо­
го приведена ниже.

protected boolean removeEldestEntry(Map.Entry<K , V> е)
Этот метод вызывается из методов put ( ) и p u tA l l ( ) Самая старая запись
отображении передается в качестве параметра е. По умолчанию этот метод воз­
вр ащает логическое значение fArgInt a l s e и ничего не делает. Но если переопределить
его, то можно удалить самую старую запись из отображения типа L i n kedH a s hMap.
Для этого переопределенный метод должен возвратить логическое значение
true. А для того чтобы сохранить самую старую запись в отображении, из пере­
определенного метода следует возвратить логическое значение fArgInt a l s e
------------------------------------------------------------------------------------------------------------------------------------------
ВНИМАНИЕ! Будьте внимательны и аккуратны, изменяя элементы хеш-множества. Если хеш-код элемента изменится, этот элемент
уже не будет находиться на правильной позиции в структуре данных.
------------------------------------------------------------------------------------------------------------------------------------------
Класс L i n kedH a s hMap расширяет класс H a s hMap . Он создает связный список
элементов, располагаемых в отображении в том порядке, в котором они вводил ись
в него. Это позволяет организовать итерацию с вводом элементов в отображе н ие
в определенном порядке. Следовательно, при итерации представления отображе­
ния типа L i n kedHas hMap в виде коллекции его элементы будут возвращаться в том
порядке, в котором они вводились в него. Можно также создать отображение типа
L i n kedH a s hMap , возвращающее свои элементы в том порядке, в котором к ним осу·
ществлялся доступ в последний раз.
------------------------------------------------------------------------------------------------------------------------------------------
 LinkedHashMap — это упорядоченная реализация хэш-таблицы. Здесь, в отличии от HashMap, порядок итерирования равен порядку добавления элементов. Данная особенность достигается благодаря двунаправленным связям между элементами (аналогично LinkedList). Но это           преимущество имеет также и недостаток — увеличение памяти, которое занимет коллекция.
------------------------------------------------------------------------------------------------------------------------------------------
 Из названия можно догадаться что данная структура является симбиозом связанных списков и хэш-мапов. Действительно, LinkedHashMap расширяет класс HashMap и реализует интерфейс Map, но что же в нем такого от связанных списков?
------------------------------------------------------------------------------------------------------------------------------------------
 Вместо итогов:
     Данная структура может слегка уступать по производительности родительскому HashMap, при этом время выполнения операций add(), contains(), remove() остается константой — O(1). Понадобится чуть больше места в памяти для хранения элементов и их связей, но это совсем небольшая плата за дополнительные фишечки.
     Вообще, из-за того что всю основную работу на себя берет родительский класс, серьезных отличий в реализации HashMap и LinkedHashMap не много. Можно упомянуть о парочке мелких:
     Методы transfer() и containsValue() устроены чуть проще из-за наличия двунаправленной связи между элементами;

 В классе LinkedHashMap.Entry реализованы методы recordRemoval() и recordAccess() (тот самый, который помещает
 элемент в конец при  accessOrder = true). В HashMap оба этих метода пустые.
------------------------------------------------------------------------------------------------------------------------------------------
 LinkedHashMap mozno ispolzovat kak prostoi LRU-konteiner (naprimer, LRU-Cache)
------------------------------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Начиная с версии Java SE 8, вместо связных списков в заполненных группах приме­
няются сбалансированные двоичные деревья. Благодаря этому повышается производительность,
если в результате неудачно выбранной хеш-функции возникает немало конфликтов или же если
в злонамеренном коде предпринимается попытка заполнить хеш-таблицу многими значениями
с одинаковыми хеш-кодами.
------------------------------------------------------------------------------------------------------------------------------------------
•
LinkedHashMap()
•
LinkedHashMap (int ini tialCapaci ty)
•
LinkedHashMap (int initialCapacity, float loadFactor)
•
LinkedHashMap (int initialCapacity, float loadFactor,
boolean accessOrder)
Конструируют пустое связное хеш-отображение заданной емкости с указанным коэффициентом за­
грузки и упорядочением. Логическое значение true параметра accessOrder задает порядок
доступа, а его логическое значение false — порядок ввода.
•
protected boolean removeEIdestEntry (Map.E nt ry <K , V > eldest)
Этот метод должен быть переопределен, чтобы возвращать логическое значение true, если тре­
буется удалить самый старый элемент. Параметр eldest обозначает самый старый элемент, ко­
торый предполагается удалить. Данный метод вызывается после того, как в отображение введен
элемент. В его реализации по умолчанию возвращается логическое значение false, т.е. старые
элементы по умолчанию не удаляются. Но этот метод можно переопределить для выборочного воз­
врата логического значения true, если, например, самый старый элемент удовлетворяет опреде­
ленным условиям или размеры отображения достигают определенной величины.
------------------------------------------------------------------------------------------------------------------------------------------

*/
