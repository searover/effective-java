package io.example.patterns.factory.simple;

import io.example.patterns.factory.Operation;

/**
 * @author luxz
 * @date 2022/11/7-02:23
 */
public class Main {
    public static void main(String[] args) {
        Operation operation = OperationFactory.CreateOperate("+");
        operation.setNumA(1);
        operation.setNumB(1);
        System.out.println(operation.getNumA() + "+" + operation.getNumB() + "=" + operation.Calculate());
    }
}
