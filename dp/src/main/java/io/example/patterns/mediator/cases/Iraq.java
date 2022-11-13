package io.example.patterns.mediator.cases;

/**
 * @author luxz
 * @date 2022/11/13-16:11
 */
public class Iraq extends Country {
    public Iraq(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String message) {
        mediator.Declare(message, this);
    }

    public void receive(String message) {
        System.out.println("伊拉克获得对方信息：" + message);
    }
}
