package io.example.patterns.mediator;

/**
 * @author luxz
 * @date 2022/11/13-13:24
 */
public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void inform(String message) {
        System.out.println("同事 1 得到消息：" + message);
    }

    public void send(String message) {
        mediator.Send(message, this);
    }
}
