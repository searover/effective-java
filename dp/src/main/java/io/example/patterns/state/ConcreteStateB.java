package io.example.patterns.state;

/**
 * @author luxz
 * @date 2022/11/11-11:11
 */
public class ConcreteStateB extends State {
    @Override
    public void Handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}
