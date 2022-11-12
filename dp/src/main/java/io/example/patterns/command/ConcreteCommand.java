package io.example.patterns.command;

/**
 * @author luxz
 * @date 2022/11/12-19:42
 */
public class ConcreteCommand extends Command {
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
