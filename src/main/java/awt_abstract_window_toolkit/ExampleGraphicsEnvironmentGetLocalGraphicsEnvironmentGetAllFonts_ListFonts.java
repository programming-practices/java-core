package awt_abstract_window_toolkit;

import java.awt.*;

public class ExampleGraphicsEnvironmentGetLocalGraphicsEnvironmentGetAllFonts_ListFonts {
    public static void main(String[] args) {
//---------------------------------------------------------------------------------------------------------------------
        /*Чтобы выяснить, какие именно шрифты доступны на отдельном компьютере, следует вызвать метод getAvailableFamilyNames()
        из класса GraphicsEnvironment. Этот метод возвращает массив строк, состоящ их из названий всех доступных в системе
        шрифтов. Чтобы создать экземпляр класса GraphicsEnvironment, описывающего графическую среду, вызывается статический
        метод getLocalGraphicsEnvironment(). Таким образом, приведенная ниже краткая программа выводит названия всех шрифтов,
        доступных в отдельной системе.*/
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontName : fontNames) System.out.println(fontName);
//---------------------------------------------------------------------------------------------------------------------
        // tak mozno posmotret kakie wriftu est v operacionnoi sisteme
//        Font[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
//        for (Font fArgInt : allFonts) {
//            System.out.println(fArgInt.getName());
//        }
//        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//        for (String s : fonts) System.out.println(s);
//---------------------------------------------------------------------------------------------------------------------
    }
}
