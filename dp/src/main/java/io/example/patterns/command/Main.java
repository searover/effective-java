package io.example.patterns.command;

/**
 * @author luxz
 * @date 2022/11/12-19:44
 */
public class Main {
    public static void main(String[] args) {
        Invoker i = new Invoker();
        i.setCommand(new ConcreteCommand(new Receiver()));
        i.executeCommand();
    }
}
