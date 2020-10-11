package java_util_logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class ExampleHandler {
    private static final Logger logger = Logger.getLogger(ExampleHandler.class.getName());

    public static void main(String[] args) throws IOException {
        Handler consoleHandler = new ConsoleHandler();
//        FileHandler fileHandler = new FileHandler();
        // smenit imia faila v kotorui zapisuvaytsa logi
        FileHandler fileHandler = new FileHandler("%h/myJavaLog.log");
//        new StreamHandler();
//        new SocketHandler();
//        new MemoryHandler();

        // otklychit hendler po default
        // esli zacomentirovat etot punct to hendler budet vivodit na consol(po ymolchaniy) i v fail
        logger.setUseParentHandlers(false);

        logger.addHandler(fileHandler);
        logger.info("IFO");
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
•abstract void publish (LogRecord r e c o r d )
            Посылает протокольную запись по указанному адресу.

•abstract void flush()
            Выводит данные из буфера.

•abstract void close()
            Выводит данные из буфера и освобождает все ресурсы.

•Filter getFilter()
•void setFilter(Filter fArgInt)
            Получает и устанавливает фильтр для данного обработчика протоколов.

•Formatter getFormatter()
•void setFormatter(Formatter fArgInt)
            Получают и устанавливают средство форматирования для данного обработчика протоколов.

•Level getLevel()
•void setLevel (Level 1)
            Получают и устанавливают уровень данного обработчика протоколов.
-----------------------------------------------------------------------------------------------------------------------
*/