package applet.JApppet_CayHorstmann;

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.24 2015-06-12
 */
public class ExampleJApplet extends JApplet {
    public void init() {
        EventQueue.invokeLater(() -> {
            JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
            add(label);
        });
    }
}

/*
------------------------------------------------------------------------------------------------------------------------
НА ЗАМЕТКУ! Если аплет содержит компоненты библиотеки Swing, следует расширить класс JApplet. Компоненты Swing не будут 
правильно отображаться, находясь в объекте обычного клас­са Applet.
------------------------------------------------------------------------------------------------------------------------
СОВЕТ. Если вы внесли изменения в аплет и скомпилировали его снова, вам придется перезапу­ стить браузер, чтобы он смог 
загрузить новые файлы классов. Простое обновление H TM L-страницы не приводит к загрузке нового кода. Утомительной 
процедуры повторного запуска браузера можно избежать, открыв консоль Java и введя команду х, которая очищает кеш 
загрузчика классов. После этого можно повторно открывать HTM L-файл, и всякий раз будет использоваться новый код аплета.
Если вы работаете в Windows, щелкните на пиктограмме Java Plug-In, доступной на панели управ­ления, а в Linux воспользуйтесь
командой jcontrol и запросите вывод на экран консоли Java. Консоль будет отображаться при каждой загрузке аплета.
------------------------------------------------------------------------------------------------------------------------
Графическое приложение Java нетрудно преобразовать в аплет и встроить в веб-страницу. Примечательно, что весь код пользовательского 
интерфейса можно при этом оставить без изменений. Итак, для преобразования графического приложе­ния Java в аплет выполните следующие действия.
1 . Создайте HTML-страницу с соответствующим дескриптором для загрузки кодааплета.
2. Определите подкласс, производный от класса JApplet. Этот класс должен быть открытым (public), иначе аплет нельзя будет загрузить.
3. Удалите из приложения метод main(). Окно фрейма для приложения созда­вать не следует, поскольку оно будет отображаться в окне браузера.
4. Перенесите все операторы инициализации из конструктора окна фрейма в ме­тод аплета init(). Специально создавать объект для аплета 
   не обязательно браузер сам создаст его и вызовет метод init().
5. Удалите вызов метода setSize(). В аплетах размеры задаются в HTML-файле с помощью атрибутов width и height.
6 . Удалите вызов метода setDefaultCloseOperation(). Аплет нельзя закрыть; он прекращает работу вместе с браузером.
7. Если в приложении имеется вызов метода setTitle(), его следует удалить, поскольку заголовки у аплетов отсутствуют. (Разумеется, 
   можно указать заго­ловок самой веб-страницы, используя HTML-дескриптор <title>. )
8 . Не вызывайте метод setVisible (true). А плет отображается на экране авто­матически.
------------------------------------------------------------------------------------------------------------------------
*/