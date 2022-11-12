package io.example.patterns.command;

/**
 * @author luxz
 * @date 2022/11/12-19:43
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
