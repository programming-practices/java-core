package generics.Bazovue_tipu_i_ynasledovanui_kod;

import java.util.ArrayList;
import java.util.List;

public class Pruebas {
    public static void main(String[] args) {
        List listS = new ArrayList();
        listS.add("w");

        List<Integer> listIntg = new ArrayList<>();
        listIntg.add(2);

//        listS = listIntg;
        listIntg = listS;
        Integer i = listIntg.get(0);   // ERROR
    }
}
