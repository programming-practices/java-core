package others.entities;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    // Types that you want to be randomly created:
    private static String[] typeNames = {
            "Books.Filosofia_Java.hlava_14.proverka_pered_privedeniem_tipov.Mutt",
            "Books.Filosofia_Java.hlava_14.proverka_pered_privedeniem_tipov.Pug",
            "Books.Filosofia_Java.hlava_14.proverka_pered_privedeniem_tipov.EgyptianMau",
            "Books.Filosofia_Java.hlava_14.proverka_pered_privedeniem_tipov.Manx",
            "Books.Filosofia_Java.hlava_14.proverka_pered_privedeniem_tipov.Cymric",
            "Books.Filosofia_Java.hlava_14.proverka_pered_privedeniem_tipov.Rat",
            "Books.Filosofia_Java.hlava_14.proverka_pered_privedeniem_tipov.Mouse",
            "Books.Filosofia_Java.hlava_14.proverka_pered_privedeniem_tipov.Hamster",
            "Books.Filosofia_Java.hlava_14.proverka_pered_privedeniem_tipov.Gerbil"
    };

    static {
        loader();
    }

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) types.add((Class<? extends Pet>) Class.forName(name));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Class<? extends Pet>> types() {
        return types;
    }
}
