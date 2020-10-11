package java_util_logging;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/*Свойства системы протоколирования можно изменить, редактируя конфигурационный файл, который по умолчанию находится по
следующему пути: jre/lib/logging.properties
Standartnui fail nastroiok naxoditsa v JDK kotoraia ispolzyetsa v proeke po pyti jdk-8.0_151/jre/lib*/

/*Если требуется сменить конфигурационный файл, при запуске приложения нужно установить свойство java.util.logging.config.file
следующим образом: java -Djava.u til.logging.config.fi1в=конфируционнный_файл ГлавныйКлаcc

 Mozno propisat pyt k faily nastorek ykazav v nastorikax proekta v VM Optons ykazat tak
 -Djava.util.logging.config.file=myfile
 -Djava.util.logging.config.file=/root/Datos/Programacion/java_lessons/src/main/java/Examples/Logging/java_util_logging/logging.properties
 nastraivat lydwe v nastorikax a ne v kode, potomy chto esli nastraevat v kode posle kazdoi nastroiki v kode nado perecompelirovat cod,
 a esli nastraivat v faile nastroek to cod rabotaet srazy (ne nyzno perocompelirovovuvat cod)*/

/*ВНИМАНИЕ! Диспетчер протоколирования инициализируется во время запуска виртуальной машины и перед выполнением метода main().
Если же сделать вызов System.setProperty("java.util.logging.config.file", file) в методе main(), то для повторной
инициализации диспетчера протоколирования придется также вызвать метод LogManager.readConfiguration().*/
public class ExampleLogging {

    /*Так, для создания или извлечения регистратора вызывается метод getLogger():*/
    private static final Logger packageLogger = Logger.getLogger("Examples.Logging.java_util_logging");
    private static final Logger classLogger = Logger.getLogger(ExampleLogging.class.getName());
    private static final Logger globalLogger = Logger.getGlobal();
    /*СОВЕТ. Регистратор, на который больше не делается ссылка ни в одной из переменных, собирается в “мусор”. Во
    избежание этого следует сохранить ссылку на регистратор в статической переменной, как показано в приведенном выше примере кода.*/

    public static void main(String[] args) throws IOException {
//---------------------------------------------------------------------------------------------------------------------
        /*Но если в соответствующем месте программы, например, в начале метода main(), ввести приведенную ниже строку
        кода, то протокольная запись будет запрещена.*/
//        globalLogger.setLevel(Level.OFF);
        /*Для элементарного протоколирования служит глобальный регистратор. Он вызывается следующим образом:*/
//        globalLogger.info("File->Open menu item selected");
//---------------------------------------------------------------------------------------------------------------------
//        /*По умолчанию используются первые три уровня, остальные нужно задавать, вызывая метод setLevel() следующим образом:*/
//        classLogger.setLevel(Level.FINE);
//        /*Кроме того, для разрешения протоколирования на всех уровнях можно воспользоваться константой Level.ALL*/
//        classLogger.setLevel(Level.ALL);
//        /*а константой Level.OFF — для запрета протоколиро­вания.*/
//        classLogger.setLevel(Level.OFF);
//
//        String messageA = "Logging";
//        /*Для всех уровней определены методы протоколирования, как показано в приведенном ниже примере.*/
//        classLogger.warning(messageA);
//        classLogger.fine(messageA);
//
//        /*С другой стороны, можно воспользоваться методом log(), чтобы явно указать нужный уровень:*/
//        String message = "Holla";
//        classLogger.log(Level.FINE, message);
//---------------------------------------------------------------------------------------------------------------------
////        packageLogger.info("message");
//        classLogger.info("message");

        /*ВНИМАНИЕ! Диспетчер протоколирования инициализируется во время запуска виртуальной машины и перед выполнением метода main().
        Если же сделать вызов System.setProperty("java.util.logging.config.file", file) в методе main(), то для повторной
        инициализации диспетчера протоколирования придется также вызвать метод LogManager.readConfiguration().*/
        // no snachala nuzno eshcho raz prochitat fail c configami
        LogManager.getLogManager().readConfiguration();
//        // Fail s configyraciamu
        System.out.println(System.getProperty("java.util.logging.config.file"));
//---------------------------------------------------------------------------------------------------------------------
        /*Обычно протоколирование служит для записи неожиданных исключений. Для этого имеются два удобных метода,
        позволяющих ввести имя исключения в протокольную запись следующим образом:
                void throwing(String className, String methodName, Throwable t)
                void log(Level 1, String message, Throwable t)*/
        try {
            throw new IOException();
        } catch (IOException e) {
            Logger.getLogger("Examples.Logging.java_util_logging").
                    log(Level.WARNING,
                            "Reading image", e);
        }

        // eto y menia ne rabotaet
//        ExampleLogging exampleLogging = new ExampleLogging();
//        exampleLogging.read();
//---------------------------------------------------------------------------------------------------------------------
    }

    public void read() {
        if (true) {
//            Logger logger = Logger.getLogger("Examples.Logging.java_util_logging");
            IOException exception = new IOException("exception45");
            if (true) try {
                throw exception;
            } catch (IOException e) {
//                e.printStackTrace();
//                logger.throwing("Examples.Logging.java_util_logging", "read", e);
                Logger.getLogger("Examples.Logging.java_util_logging").
                        throwing("Examples/Logging/JUL_java_util_logging/ExampleLogging.java", "read", e);

            }
        }
    }
}

/*
-----------------------------------------------------------------------------------------------------------------------
                                        "Рецепт” протоколирования
Ниже приведен "рецепт" организации протоколирования, в котором сведены наиболее употребительные операции.
1. Для простых приложений выбирайте один регистратор. Желательно, чтобы имя регистратора совпадало с именем основного
    пакета приложения, например com.mycompany.myprog. Создать регистратор можно, сделав следующий вызов:
                        Logger logger = Logger.getLogger("com.mycompany.myprog");

2. Для удобства в те классы, где интенсивно используется протоколирование, можно добавить статические поля:
                    private static final Logger logger = Logger.getLogger("com.mycompany.myprog");

3. По умолчанию все сообщения, имеющие уровень INFO и выше, выводятся на консоль. Пользователи могут изменить конфигурацию,
предусмотренную по умолчанию, но, как пояснялось ранее, это довольно сложный процесс. Следовательно, лучше задать более
оправданные настройки приложения по умолчанию. Приведенный ниже код гарантирует, что все сообщения будут зарегистрированы
в файле протокола, связанном с конкретным приложением. Введите этот код в тело метода main() своего приложения.
                    if (System.getProperty("java.util.logging.config.class") == null
                            && System.getProperty("java.util.logging.config.file") == null){
                            try{
                                Logger.getLogger("").setLevel(Level.ALL);
                                final int LOG_ROTATION_COUNT = 10;
                                Handler handler = new FileHandler("%h/myapp.log", 0, LOG_ROTATION_COUNT);
                                Logger.getLogger("").addHandler(handler);
                            }catch (IOException e){
                                logger.log(Level.SEVERE, "Can't create log file handler", e );
                            }
                    }

4. Теперь все готово для протоколирования. Помните, что все сообщения, имеющие уровень протоколирования INFO, WARNING и
SEVERE, выводятся на консоль. Следовательно, эти уровни протоколирования нужно зарезервировать для сообщений, представляющих
ценность для пользователей вашей программы. Уровень FINE лучше выделить для сообщений, предназначенных для программистов.
В тех местах кода, где вы обычно вызывали метод System.out.println(), регистрируйте сообщения следующим образом:
                    logger.fine("File open dialog canceled");

5. Рекомендуется также регистрировать неожиданные исключения, например, так, как показано ниже.
                    try{
                        ....
                    }catch (SomeException е){
                        logger.log(Level.FINE, "explanation", e) ;
                    }
-----------------------------------------------------------------------------------------------------------------------
Существует семь уровней протоколирования:
    •SEVERE
    •WARNING
    •INFO
    •CONFIG
    •FINE
    •FINER
    •FINEST
-----------------------------------------------------------------------------------------------------------------------
СОВЕТ. По умолчанию регистрируются все записи, имеющие уровень INFO и выше. Следовательно, для отладочных сообщений,
требующихся для д иагностики программ, но совершенно не нужных пользователям, следуетуказыватьуровни CONFIG,fine,finer и finest.

ВНИМАНИЕ! Если уровень протоколирования превышает величину INFO, следует изменить конфигурацию обработчика протоколов.
По умолчанию обработчик протоколов блокирует сообщения, имеющие уровень ниже INFO.
-----------------------------------------------------------------------------------------------------------------------
•Logger getLogger (String loggerName)
•Logger getLogger (String loggerName, String bundleName)
            Возвращают регистратор протоколов с указанным именем. Если регистратор не существует, он создается.
            Параметры:
                    loggerName         Иерархическое имя регистратора, например com.myconpany.myapp.
                    bundleName          Имя комплекта ресурсов для поиска интернационализированных сообщений

•void severe (String message)
•void warning (String message)
•void info (String message)
•void config (String message)
•void fine (String message)
•void finer (String message)
•void finest (String message)
            Протоколируют запись на уровне, соответствующем имени метода, вместе с заданным сообщением message.

•void entering (String className, String methodName)
•void entering (String className, String methodName, Object param)
•void entering (String className, String methodName, Object [] param)
•void exiting (String className, String methodName)
•void exiting (String className, String methodName, Object result)
            Протоколируют запись, описывающую вход и выход из метода с заданными параметрами или возвращаемым значением.

• void throwing (String className, String methodName, Throwable t)
            Протоколирует запись, описывающую процесс генерирования объекта исключения.

•void log(Level level, String message)
•void log(Level level, String message, Object oJbj)
•void log(Level level, String message, Object [] objs)
•void log(Level level, String message, Throwable t)
            Протоколируют запись на заданном уровне вместе с указанным сообщением. Запись может содержать обычные объекты
            или объект исключения. Для этой цели в сообщении предусмотрены заполнители {0}, {1} ит.д .

•void logp(Level level, String className, String methodName, String message)
•void logp(Level level, String className, String methodName, String message, Obj ect obj)
•void logp(Level level, String className, String methodName, String message, Object[] objs)
•void logp(Level level, String className, String methodName, String message, Throwable t)
            Протоколируют запись на заданном уровне с данными о вызове и указанным сообщением. Запись может включать
            обычные объекты или объекты исключений.

•void logrb(Level level, String className, String methodName, String bundleName, String message)
•void logrb (Level level, String className,String methodName, String bundleName, String message, Object obj)
•void logrb (Level level, String className,String methodName, String bundleName, String message, Object[] objs)
•void logrb (Level level, String className,String methodName, String bundleName, String message, Throwable t)
            Протоколируют запись на заданном уровне с данными о вызове, указанным сообщением и именем комплекта ресурсов.
            Запись может включать обычные объекты или объекты исключений.

•Level getLevel()
•void setLevel(Level 1)
            Получают и устанавливают уровень данного регистратора.

•Logger getParent()
•void setParent(Logger 1)
            Получают и устанавливают родительский регистратор.

•Handler[] getHandlers()
            Получает все обработчики протоколов для данного регистратора.

•void addHandler(Handler h)
•void removeHandler(Handler h)
            Добавляют и удаляют обработчик протоколов для данного регистратора.

•boolean getUseParentHandlers()
•void setUseParentHandlers(boolean b)
            Получают и устанавливают свойство, определяющее режим использования родительского обработчика протоколов.
            Если это свойство принимает логическое значение true, регистратор направляет все протоколируемые записи
            обработчикам своего родительского регистратора.

•Filter getFilter()
•void setFilter(Filter fArgInt)
            Получают и устанавливают фильтр для данного регистратора.
-----------------------------------------------------------------------------------------------------------------------
*/
