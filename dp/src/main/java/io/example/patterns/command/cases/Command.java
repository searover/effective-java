package io.example.patterns.command.cases;

/**
 * @author luxz
 * @date 2022/11/12-21:05
 */
public abstract class Command {

    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}
