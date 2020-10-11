package java_util_logging;

import java.io.IOException;
import java.util.logging.*;

public class ExampleFormatter {
    private static final Logger logger = Logger.getLogger(ExampleFilter.class.getName());

    public static void main(String[] args) throws IOException {
        Handler handler = new ConsoleHandler();
//        Handler handler = new FileHandler();
        handler.setFilter(new MyFilter());

        // zdes zadaiotsa formatter
        handler.setFormatter(new MyFormatter());

        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        logger.info("Hello");
        logger.info("Hello re");

    }

}

class MyFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        /*Далее протокольная запись форматируется избранным способом и возвращается получаемая в итоге символьная строка.
        В методе format() может потребоваться вызов приведенного ниже метода. Этот метод форматирует сообщение, составляющее
        часть протокольной записи, подставляя параметры и выполняя интернационализацию.
                                String formatMessage(LogRecord record)*/

        /*Во многих форматах файлов (например, XML) предполагается существование начальной и конечной частей файла, заклю
        чающих в себе отформатированные протокольные записи. В таком случае нужно переопределить следующие методы:
                                String getHead(Handler h)
                                String getTail(Handler h)*/
        return record.getMessage() + ", " + record.getLevel();
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
•abstract String format (LogRecord record)
        Возвращает символьную строку, полученную в результате форматирования заданной протокольной записи.

•String getHead(Handler h)
•String getTail(Handler h)
        Возвращают символьные строки, которые должны появиться в начале и в конце документа, содержащего данную протокольную
        запись. Эти методы определены в суперклассе Formatter и по умолчанию возвращают пустую символьную строку. При
        необходимости их следует переопределить.

•String formatMfessage (LogRecord record)
        Возвращает интернационализированное и форматированное сообщение, являющееся частью протокольной записи.
-----------------------------------------------------------------------------------------------------------------------
*/