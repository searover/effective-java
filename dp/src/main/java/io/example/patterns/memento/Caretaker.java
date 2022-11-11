package io.example.patterns.memento;

/**
 * @author luxz
 * @date 2022/11/12-06:38
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
