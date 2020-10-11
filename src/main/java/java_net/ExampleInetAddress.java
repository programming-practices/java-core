package java_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

// Demonstrate InetAddress.
public class ExampleInetAddress {
    public static void main(String args[]) throws UnknownHostException {
//---------------------------------------------------------------------------------------------------------------------
//        InetAddress address = InetAddress.getLocalHost();
//        System.out.println(address);
//        System.out.println();
//
//        address = InetAddress.getByName("www.HerbSchildt.com");
//        System.out.println(address);
//        System.out.println();
//
//        InetAddress NBA[] = InetAddress.getAllByName("www.nba.com");
//        for (int valueInt=0; valueInt<NBA.length; valueInt++) System.out.println(NBA[valueInt]);
//        System.out.println();
//
//        InetAddress GOOGLE[] = InetAddress.getAllByName("www.google.com");
//        for (int valueInt=0; valueInt<GOOGLE.length; valueInt++) System.out.println(GOOGLE[valueInt]);
//        System.out.println();
//
//        InetAddress GOOGLE01[] = InetAddress.getAllByName("www.google.es");
//        for (int valueInt=0; valueInt<GOOGLE01.length; valueInt++) System.out.println(GOOGLE01[valueInt]);
//        System.out.println();
//--------------------------------------------------------------------------------------------------------------------
        InetAddress address = InetAddress.getByName("time-a.nist.gov");
//        InetAddress address = InetAddress.getByName("localhost");
        System.out.println(address.getHostName());
        System.out.println(address.getCanonicalHostName());
        System.out.println(address.getHostAddress());
        byte[] bytes = address.getAddress();
        System.out.println(InetAddress.getByAddress(bytes));
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
----------------------------------------------------------------------------------------------------------------------
Этот класс служит для инкапсуляции как числового IР-адреса, так и его домен­
ного имени. Для взаимодействия с этим классом используется имя IР-хоста, т.е.
узла сети, которое намного удобнее и понятнее, чем IР-адрес. Числовое значение
IР-адреса скрывается в классе I ne tAddre s s . Этот класс может оперировать адре­
сами как по протоколу 1Pv4, так и по протоколу IPvб.
----------------------------------------------------------------------------------------------------------------------
В состав класса I ne tAddre s s входит также фабричный метод ge t DyAddre s s ( ) ,
который принимает IР-адрес и возвращает объект типа Ine tAddre s s . Причем мо­
гут использоваться адреса как по протоколу IPv4, так и по протоколу IPvб.
----------------------------------------------------------------------------------------------------------------------
• static InetAddress getByName(String host)
• static InetAddress [ ] getAllByName (String host)
Конструируют объект типа InetAddress или массив всех межсетевых адресов для
заданного имени хоста.
• static InetAddress getLocalHost()
Конструирует объект типа InetAddress для локального хоста.
• byte [ ] getAddress ()
Возвращает массив байтов, содержащий числовой адрес.
• String getHostAddress()
Возвращает адрес хоста в виде символьной строки с десятичными числами, разделенными
точками, например "132.163.4.102".
• String getHostNameO
Возвращает имя хоста.
----------------------------------------------------------------------------------------------------------------------
*/
