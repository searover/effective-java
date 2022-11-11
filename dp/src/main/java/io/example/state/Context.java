package io.example.state;

/**
 * @author luxz
 * @date 2022/11/11-11:08
 */
public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("Current state: " + state.getClass().getSimpleName());
    }

    public void Request() {
        state.Handle(this);
    }
}
