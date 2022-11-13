package io.example.patterns.mediator;

/**
 * @author luxz
 * @date 2022/11/13-13:23
 */
public class ConcreteMediator extends Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void Send(String message, Colleague colleague) {
        if (colleague instanceof ConcreteColleague1) {
            colleague2.inform(message);
        }
        if (colleague instanceof ConcreteColleague2) {
            colleague1.inform(message);
        }
    }
}
