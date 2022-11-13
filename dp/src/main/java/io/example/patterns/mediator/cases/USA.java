package io.example.patterns.mediator.cases;

/**
 * @author luxz
 * @date 2022/11/13-16:11
 */
public class USA extends Country {
    public USA(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String message) {
        mediator.Declare(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println("美国获得对方信息：" + message);
    }
}
