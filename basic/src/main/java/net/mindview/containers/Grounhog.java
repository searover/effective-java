package net.mindview.containers;

public class Grounhog {
    protected int number;

    public Grounhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Groundhog #" + number;
    }
}
