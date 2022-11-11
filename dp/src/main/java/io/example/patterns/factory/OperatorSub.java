package io.example.patterns.factory;

public class OperatorSub extends Operation {

    @Override
    public double Calculate() {
        return numA - numB;
    }
}
