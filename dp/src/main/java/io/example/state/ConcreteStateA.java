package io.example.state;

/**
 * @author luxz
 * @date 2022/11/11-11:11
 */
public class ConcreteStateA extends State {
    @Override
    public void Handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}
