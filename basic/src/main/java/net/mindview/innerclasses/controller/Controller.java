package net.mindview.innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author searover
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (int i = 0; i < eventList.size(); i++) {
                Event e = eventList.get(i);
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
