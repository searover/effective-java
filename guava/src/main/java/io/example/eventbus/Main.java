package io.example.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author luxz
 * @date 2022/11/11-17:34
 */
public class Main {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        EventListener listener = new EventListener();
//        eventBus.register(listener);
        eventBus.post("String Event");
        System.out.println(EventListener.getEventHandled());
    }

    @Subscribe
    public void handDeadEvent(DeadEvent deadEvent) {
        System.out.println("handle dead event: " + deadEvent.getEvent());
    }
}