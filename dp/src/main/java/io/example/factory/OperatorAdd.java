package io.example.factory;

public class OperatorAdd extends Operation {

    @Override
    public double Calculate() {
        return numA + numB;
    }
}
