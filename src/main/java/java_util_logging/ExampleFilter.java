package java_util_logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ExampleFilter {

    private static final Logger logger = Logger.getLogger(ExampleFilter.class.getName());

    public static void main(String[] args) throws IOException {

        FileHandler fileHandler = new FileHandler();
        // zdes zadaiom filter
        fileHandler.setFilter(new MyFilter());

        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        logger.info("Hello");
        logger.info("Hello re");
    }


}

class MyFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        // s pomowchiy record mozno nastroivat filter
        return record.getMessage().endsWith("re");
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
•boolean isLoggable (LogRecord record)
        Возвращает логическое значение true, если указанная запись должна быть зарегистрирована.
-----------------------------------------------------------------------------------------------------------------------
*/