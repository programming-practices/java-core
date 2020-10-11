package Examples.OOP.Others.interfase_use.staticheskie_y_default_metodu_v_intefeise;

public interface MyData {
    static boolean isNull(String str) {
        System.out.println("Статический метод проверки на null");

        return str == null ? true : "".equals(str) ? true : false;
    }

    default void print(String str) {
        if (!isNull(str))
            System.out.println("Класс MyData. Печатаем строку: " + str);
    }
}
