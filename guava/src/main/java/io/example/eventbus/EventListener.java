package io.example.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author luxz
 * @date 2022/11/11-17:37
 */
public class EventListener {
    private static int eventHandled;

    @Subscribe
    public void StringEvent(String event) {
        eventHandled++;
        System.out.println("event: " + event + " handled.");
    }

    public static int getEventHandled() {
        return eventHandled;
    }

    public static void setEventHandled(int eventHandled) {
        EventListener.eventHandled = eventHandled;
    }
}