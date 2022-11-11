package io.example.patterns.factory;

public class OperatorMul extends Operation {
    @Override
    public double Calculate() {
        return numA * numB;
    }
}
