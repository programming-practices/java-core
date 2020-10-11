package Examples.OOP.Others.vnutrennii_class_i_sestema_ypravlenia;

public class GreenhouseControls1 extends GreenhouseControls {

    private boolean roomHumidification = false;

    public class RoomHumidificationOn extends Event {
        public RoomHumidificationOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            roomHumidification = true;
        }

        @Override
        public String toString() {
            return "Yvlaznenie doma vklucheno";
        }
    }

    public class RoomHumidificationOff extends Event {
        public RoomHumidificationOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            roomHumidification = false;
        }

        @Override
        public String toString() {
            return "Yvlaznenie doma vuklucheno";
        }
    }
}
