package io.example.patterns.factory.method;

import io.example.patterns.factory.Operation;

/**
 * @author luxz
 * @date 2022/11/8-20:55
 */
public class Main {
    public static void main(String[] args) {
        OperatorFactory factory = new AddFactoryImpl();
        Operation operation = factory.CreateOperation();
        operation.setNumA(1);
        operation.setNumB(1);
        System.out.println(operation.getNumA() + "+" + operation.getNumB() + "=" + operation.Calculate());
    }
}
