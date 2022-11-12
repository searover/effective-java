package io.example.patterns.command;

/**
 * @author luxz
 * @date 2022/11/12-19:40
 */
public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}
