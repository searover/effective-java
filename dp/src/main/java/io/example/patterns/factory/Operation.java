package io.example.patterns.factory;

/**
 * @author luxz
 * @date 2022/11/7-02:15
 */
public abstract class Operation {
    protected double numA;
    protected double numB;

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }

    public abstract double Calculate();
}

