package io.example.patterns.state.cases;

/**
 * @author luxz
 * @date 2022/11/11-11:23
 */
public class Work {
    private WorkState currentState;
    private double workHour;
    private boolean finished;

    public Work() {
        this.currentState = new ForenoonWorkState();
    }

    public WorkState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(WorkState currentState) {
        this.currentState = currentState;
    }

    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void coding() {
        this.currentState.Coding(this);
    }
}
