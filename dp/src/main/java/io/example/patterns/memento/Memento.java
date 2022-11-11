package io.example.patterns.memento;

/**
 * @author luxz
 * @date 2022/11/12-06:38
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
