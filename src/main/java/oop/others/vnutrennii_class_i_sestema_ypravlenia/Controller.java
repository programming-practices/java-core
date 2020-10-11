package Examples.OOP.Others.vnutrennii_class_i_sestema_ypravlenia;

// Vmeste s classom Event sostavliaet sistemy
// ypravlenia obwcheho xaraktera

import java.util.Iterator;
import java.util.LinkedList;

public class Controller {
    public LinkedList<Event> eventList = new LinkedList<>();

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void run() {


        Iterator<Event> iteratorEvent = new LinkedList<Event>(eventList).iterator();
        while (iteratorEvent.hasNext()) {

            Event ee = iteratorEvent.next();

            if (ee.ready()) {
                System.out.println(ee);
                ee.action();
                eventList.remove(ee);
            }
        }


//        while (eventList.size() > 0){
//            // Sozdat kopiy, chtobi izbezat modifikaciy cpiska
//            // vo vrema viborki elementa
//            for (Event e: new LinkedList<>(eventList)) {
//                if (e.ready()){
//                    System.out.println(e);
//                    e.action();
//                    eventList.remove(e);
//                }
//            }
//        }
    }
}
