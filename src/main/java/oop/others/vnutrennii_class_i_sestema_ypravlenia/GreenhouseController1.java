package Examples.OOP.Others.vnutrennii_class_i_sestema_ypravlenia;

import java.util.LinkedList;

public class GreenhouseController1 {
    public static void main(String[] args) {
        GreenhouseControls1 gc1 = new GreenhouseControls1();
        gc1.addEvent(gc1.new Bell(900));
        LinkedList<Event> eventList = new LinkedList<Event>();
        eventList.add(gc1.new ThermostateNight(0));
        eventList.add(gc1.new LightOn(200));
        eventList.add(gc1.new WaterOn(600));
        eventList.add(gc1.new AirConditionerOff(500));
        eventList.add(gc1.new ThermostateDay(1400));
        eventList.add(gc1.new LightOff(400));
        eventList.add(gc1.new WaterOff(800));
        eventList.add(gc1.new AirConditionerOn(300));
        gc1.addEvent(gc1.new Restart(2000, eventList));
//        if (args.length == 1){
//            gc.addEvent(new GreenhouseControls.Terminate(1800));
//        }
        gc1.addEvent(new GreenhouseControls.Terminate(1800));
        gc1.run();
    }
}
