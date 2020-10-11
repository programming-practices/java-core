package Examples.Type_Information.zarehestrirovanie_fabriki;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Part {
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    private static Random rand = new Random(47);

    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

    public String toString() {
        return getClass().getSimpleName();
    }

}
