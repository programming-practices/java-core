package java_net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ExampleServerSocket {
    public static void main(String[] args) {
//--------------------------------------------------------------------------------------------------------------------
//        try (ServerSocket serverSocket = new ServerSocket(19000);){
//            System.out.println("Server starting, waiting for connection.");
//            while (true){
//                Socket socketIncoming = serverSocket.accept();
//                System.out.println("Client socket accepted: " + socketIncoming.getInetAddress());
//
//                try (InputStream inputStream = socketIncoming.getInputStream();
//                     OutputStream outputStream = socketIncoming.getOutputStream()){
//
//                    byte[] buffer = new byte[32 * 1024];
//                    int readBytes = inputStream.read(buffer);
//                    String lines = new String(buffer, 0, readBytes);
//                    System.out.println("Received from the client: " + lines);
//
//                    outputStream.write(lines.toUpperCase().getBytes());
//                    outputStream.flush();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//--------------------------------------------------------------------------------------------------------------------
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            while (true) {
                System.out.println("wait for TPC-connection...");
                Socket socket = serverSocket.accept();
                System.out.println("get one!");
                try (InputStream in = socket.getInputStream();
                     OutputStream out = socket.getOutputStream()) {
                    // READ rquest
                    byte[] request = ExampleHttpUtils.readRequestFully(in);
                    System.out.println("---------------------");
                    System.out.print(new String(request, "ASCII"));
                    System.out.println("---------------------");
                    //WRITE response
                    byte[] response = new Date().toString().getBytes("ASCII");
                    out.write(response);
                } finally {
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//--------------------------------------------------------------------------------------------------------------------
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
Как упоминалось ранее, в Java имеются различные классы сокетов, которые
должны применяться при разработке серверных приложений. В частности, класс
S e rve rS o c ke t применяется для создания серверов, которые принимают запросы
как от локальных, так и от удаленных клиентских программ, желающих установить
соединение с ними через открытые порты. Класс Serve r S o c ke t заметно отличае"Г­
ся от обычных классов типа Socket. Когда создается объект класса Se rverSocket,
о н регистрируется в системе как заинтересованный в соединении с клиентами.
Конструкторы класса Se rve r S o c ke t отражают номер порта, через который требу­
ется принимать запросы на соединение, а также (хотя и необязательно) длину оче­
реди, которая организуется для данного порта. Длина очереди сообщает системе,
сколько клиентских соединений можно поддерживать, прежде чем отказать в со­
единении. По умолчанию задается длина очереди 50 соединений. При определен­
н ых условиях конструкторы класса Se rverSocket могут сгенерировать исключение
типа IOException.
-----------------------------------------------------------------------------------------------------------------------
Любая серверная программа, например, веб-сервер, работающий по протоколу HTTP, выполняет
аналогичный цикл следующих действий.
1. Получение из потока ввода входящих данных запроса на конкретную информацию от клиентской программы.
2. Расшифровка клиентского запроса.
3. Сбор информации, запрашиваемой клиентом.
4. Передача обнаруженной информации клиентской программе через поток вывода исходящих данных.
-----------------------------------------------------------------------------------------------------------------------
*/
