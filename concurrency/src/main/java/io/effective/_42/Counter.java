package io.effective._42;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter {

    static class CounterActor extends UntypedAbstractActor {
        private int counter = 0;

        @Override
        public void onReceive(Object message) throws Throwable {
            // 如果接收到的消息是数字类型的，执行累加操作，否则打印
            if (message instanceof Number) {
                counter += ((Number) message).intValue();
            } else {
                System.out.println("counter: " + counter);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ActorSystem system = ActorSystem.create();
        ExecutorService es = Executors.newFixedThreadPool(4);
        ActorRef counterActor = system.actorOf(Props.create(CounterActor.class));
        for (int i = 0; i < 4; i++) {
            es.execute(() -> {
                for (int i1 = 0; i1 < 100000; i1++) {
                    counterActor.tell(1, ActorRef.noSender());
                }
            });
        }
        es.shutdown();
        Thread.sleep(1000);
        counterActor.tell("", ActorRef.noSender());
        system.terminate();
    }
}
