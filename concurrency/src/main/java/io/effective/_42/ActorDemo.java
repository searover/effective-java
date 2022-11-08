package io.effective._42;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class ActorDemo {

    static class HelloActor extends UntypedAbstractActor {

        @Override
        public void onReceive(Object message) throws Throwable {
            System.out.println("Hello " + message);
        }
    }

    public static void main(String[] args) {
        // 创建Actor系统
        ActorSystem actorSystem = ActorSystem.create("HelloSystem");
        // 创建HelloActor
        ActorRef helloActor = actorSystem.actorOf(Props.create(HelloActor.class));
        helloActor.tell("Actor", ActorRef.noSender());
    }
}
