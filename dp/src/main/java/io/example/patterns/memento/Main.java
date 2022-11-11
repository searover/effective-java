package io.example.patterns.memento;

/**
 * @author luxz
 * @date 2022/11/12-06:42
 */
public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("On");
        originator.show();
        Caretaker ck = new Caretaker();
        ck.setMemento(originator.createMemento());
        originator.setState("Off");
        originator.show();
        originator.setMemento(ck.getMemento());
        originator.show();
    }
}
