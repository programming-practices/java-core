package Examples.Type_Information.zarehestrirovanie_fabriki;


class Filter extends Part {
}


class FuelFilter extends Filter {
    // Create a Class Factory for each specific type:
    public static class Factory implements Examples.Type_Information.zarehestrirovanie_fabriki.Factory<FuelFilter> {

        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}


class AirFilter extends Filter {
    public static class Factory implements Examples.Type_Information.zarehestrirovanie_fabriki.Factory<AirFilter> {

        public AirFilter create() {
            return new AirFilter();
        }
    }
}


class CabinAirFilter extends Filter {
    public static class Factory implements Examples.Type_Information.zarehestrirovanie_fabriki.Factory<CabinAirFilter> {

        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}


class OilFilter extends Filter {
    public static class Factory implements Examples.Type_Information.zarehestrirovanie_fabriki.Factory<OilFilter> {

        public OilFilter create() {
            return new OilFilter();
        }
    }
}


class Belt extends Part {
}


class FanBelt extends Belt {
    public static class Factory implements Examples.Type_Information.zarehestrirovanie_fabriki.Factory<FanBelt> {

        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements Examples.Type_Information.zarehestrirovanie_fabriki.Factory<GeneratorBelt> {

        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}


class PowerSteeringBelt extends Belt {
    public static class Factory implements Examples.Type_Information.zarehestrirovanie_fabriki.Factory<PowerSteeringBelt> {

        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}


public class RegisteredFactories {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}
