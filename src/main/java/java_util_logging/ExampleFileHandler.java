package java_util_logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class ExampleFileHandler {
    private static final Logger logger = Logger.getLogger("ExmpleFileHandler");

    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler();
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
                                    Opusanie                                     Значение по умолчанию
java.util.logging.FileHandler.level
                                Уровень обработчика                                     Level.ALL

java.util.logging.FileHandler.append
                                Определяет, должен ли обработчик                        false
                                добавлять записи в существующий
                                файл или же открывать новый файл при
                                очередном запуске программы

java.util.logging.FileHandler.limit
                                Приблизительная оценка максимального                        0 (т.е. без ограничений)
                                размера файла. При превышении этого                         в классе FileHandler; 5 00 00
                                размера открывается новый файл (0 —                         в исходной конфигурации
                                размер файла не ограничен)                                  диспетчера протоколирования


java.util.logging.FileHandler.pattern
                                Шаблон имени файла протокола                                %h/java%u.log
                                (см.табл. 7.2)

java.util.logging.FileHandler.count
                                Количество файлов протокола,                                1 (ротация не производится)
                                участвующих в ротации

java.util.logging.FileHandler.filter
                                Класс, используемый для фильтрации                          Фильтрация отсутствует

java.util.logging.FileHandler.encoding
                                Применяемая кодировка                                       Кодировка, принятая на текущей платформе

java.util.logging.FileHandler.formatter
                            Средство форматирования протокольных записей                    java.util.logging. XMLFormatter
-----------------------------------------------------------------------------------------------------------------------
%h      Значение системного свойства user.home
%t      Временный системный каталог
%u      Однозначный номер, позволяющий избежать конфликта имен
%g      Определяет режим формирования номеров для подвергаемых ротации файлов протоколов. (Если
        ротация производится, а в шаблоне отсутствует переменная %д, то используется суффикс.%g.)
%%      Знак процента
-----------------------------------------------------------------------------------------------------------------------
•FileHandler(String pattern )
•FileHandler(String pattern, boolean append)
•FileHandler(Stringpattern, int lim it, int count)
•FileHandler(Stringpattern, int lim it, int count, boolean append)
            Создают файловый обработчик протоколов.
                Параметры:
                        pattern      Шаблон для создания имени файла протокола (см. табл. 7.2)
                        limit        Приблизительная оценка максимального размера файла протокола. При превышении этого
                                     размера открывается новый файл
                        count        Количество файлов, участвующих в ротации
                        append       Принимает логическое значение true, если вновь созданный объект файлового обработчика
                                     должен выводить данные в существующий файл протокола
-----------------------------------------------------------------------------------------------------------------------
*/
