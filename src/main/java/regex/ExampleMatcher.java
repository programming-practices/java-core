package Examples.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleMatcher {
    public static void main(String[] args) {

        // Matcher — класс, который представляет строку, реализует механизм согласования (matching) с РВ
        // и хранит результаты этого согласования (используя реализацию методов интерфейса MatchResult).
        // Не имеет публичных конструкторов, поэтому для создания объекта этого класса нужно
        // использовать метод matcher класса Pattern:

        // будем искать URL
        String regexpURL = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";
        String url = "http://habrahabr.ru/post/260767/";

        Pattern patternURL = Pattern.compile(regexpURL);
        Matcher matcherURL = patternURL.matcher(url);

        // Но результатов у нас еще нет. Чтобы их получить нужно воспользоваться методом find. Можно
        // использовать matches — этот метод вернет true только тогда, когда вся строка соответствует
        // заданному РВ, в отличии от find, который пытается найти подстроку, которая удовлетворяет РВ.
        // Для более детальной информации о результатах согласования можно использовать реализацию
        // методов интерфейса MatchResult, например:

        // IP адрес
        String regexpIP = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        // для сравнения работы find() и matches()
        String goodIp = "192.168.0.3";
        String badIp = "192.168.0.3g";

        Pattern patternIP = Pattern.compile(regexpIP);

        Matcher matcherIP = patternIP.matcher(goodIp);

        // matches() - true, find() - true
        matcherIP = patternIP.matcher(badIp);// matches() - false, find() - true

        // а теперь получим дополнительную информацию
        System.out.println(matcherIP.find() ?
                "I found '" + matcherIP.group() + "' starting at index " +
                        matcherIP.start() + " and ending at index " + matcherIP.end() + "." :
                "I found nothing!");
        // I found the text '192.168.0.3' starting at index 0 and ending at index 11.


        // Также можно начинать поиск с нужной позиции используя find(int start). Стоит отметить
        // что существует еще один способ поиска — метод lookingAt. Он начинает проверку совпадений
        // РВ с начала строки, но не требует полного соответствия, в отличии от matches.

//----------------------------------------------------------------------------------------------------------------------

        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("aabtextaabtextabtextb the end");
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, "-");
            // buffer = "-" -> "-text-" -> "-text-text-" -> "-text-text-text-"
        }
        matcher.appendTail(buffer);
        // buffer = "-text-text-text- the end"
        System.out.println(buffer);
//----------------------------------------------------------------------------------------------------------------------
    }
}


