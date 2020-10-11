package Examples.OOP.Others.vnutrennii_class_i_sestema_ypravlenia;

// Primer konkretnoho prilozenia na osnove sistemu
// ypravlen, vse naxoditsa v odnom classe. Vnytrinnie
// classu dayt vozmoznost inkapsylirovat raznyy
// fynkcionalnost dlya kazdoho oddelnoho sobitia.

import java.util.LinkedList;

public class GreenhouseControls extends Controller {
    private boolean light = false;
    private boolean water = false;
    private String thermostate = "Dien";
    private boolean airConditioner = false;

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Otklychenie";
        }
    }

    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Pomestite cyda cod ypravlenia oborydovaniem
            // vupolniaywchii neposredstvenno vklychenie sveta
            light = true;
        }

        @Override
        public String toString() {
            return "Svet Vklychon";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Pomestite cyda cod ypravlenia oborydovaniem
            // vupolniaywchii vuklycheniem sveta
            light = false;
        }

        @Override
        public String toString() {
            return "Svet Vuklychen";
        }
    }

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Zdes razmiwchaem kod ypravlenia oborydovaniem
            water = true;
        }

        @Override
        public String toString() {
            return "Poluv Vklychon";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Zdes razmiwchaem kod ypravlenia oborydovaniem
            water = false;
        }

        @Override
        public String toString() {
            return "Poluv Vuklychon";
        }
    }

    public class ThermostateNight extends Event {
        public ThermostateNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Zdes razmiwchaem kod ypravlenia oborydovaniem
            thermostate = "Noch";
        }

        @Override
        public String toString() {
            return "Termostat isolzyetsya nochnoii rezim";
        }
    }

    public class ThermostateDay extends Event {
        public ThermostateDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Zdes razmiwchaem kod ypravlenia oborydovaniem
            thermostate = "Dien";
        }

        @Override
        public String toString() {
            return "Termostat isolzyetsya dnevnoi rezim";
        }
    }

    // Primer metoda action(); vstavliaywchoho noviii ekzemplyar
    // samoho sebia v cpisok sobitiii
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));

        }

        @Override
        public String toString() {
            return "Bammm";
        }
    }

    public class Restart extends Event {
        private LinkedList<Event> eventsList;

        public Restart(long delayTime, LinkedList<Event> eventsList) {
            super(delayTime);
            this.eventsList = eventsList;
            for (Event e : eventsList) {
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e : eventsList) {
                e.start();   // Perezapysk kazdoho sobitia
                addEvent(e);
            }
            start(); // Perezapysk tekywcheho sobitia
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Perezapysk sistemu";
        }
    }

    public class AirConditionerOn extends Event {
        public AirConditionerOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            airConditioner = true;
        }

        @Override
        public String toString() {
            return "Air Conditioner on";
        }
    }

    public class AirConditionerOff extends Event {
        public AirConditionerOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            airConditioner = false;
        }

        @Override
        public String toString() {
            return "Air Conditioner off";
        }
    }

}
