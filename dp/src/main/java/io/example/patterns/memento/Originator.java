package io.example.patterns.memento;

/**
 * @author luxz
 * @date 2022/11/12-06:38
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }

    public void show() {
        System.out.printf("State = %s%n", state);
    }
}
