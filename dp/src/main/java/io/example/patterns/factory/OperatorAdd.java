package io.example.patterns.factory;

public class OperatorAdd extends Operation {

    @Override
    public double Calculate() {
        return numA + numB;
    }
}
