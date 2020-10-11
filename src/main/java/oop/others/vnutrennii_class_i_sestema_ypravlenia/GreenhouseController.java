package Examples.OOP.Others.vnutrennii_class_i_sestema_ypravlenia;

import java.util.LinkedList;

public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        // Vmesto zestkoii fiksacii parametorov v kode
        // mozno bulo bu schitat informaciy
        // iz tekstovoho faila

        gc.addEvent(gc.new Bell(900));
        LinkedList<Event> eventList = new LinkedList<Event>();
        eventList.add(gc.new ThermostateNight(0));
        eventList.add(gc.new LightOn(200));
        eventList.add(gc.new WaterOn(600));
        eventList.add(gc.new AirConditionerOff(500));
        eventList.add(gc.new ThermostateDay(1400));
        eventList.add(gc.new LightOff(400));
        eventList.add(gc.new WaterOff(800));
        eventList.add(gc.new AirConditionerOn(300));
        gc.addEvent(gc.new Restart(2000, eventList));
//        if (args.length == 1){
//            gc.addEvent(new GreenhouseControls.Terminate(1800));
//        }
        gc.addEvent(new GreenhouseControls.Terminate(1800));
        gc.run();
    }

    // Storinka 316
}
