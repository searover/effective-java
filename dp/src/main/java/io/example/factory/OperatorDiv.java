package io.example.factory;

public class OperatorDiv extends Operation {
    @Override
    public double Calculate() {
        if (numB == 0) {
            throw new RuntimeException("Div by zero");
        }
        return numA / numB;
    }
}
