package io.example.factory.simple;

import io.example.factory.*;

/**
 * @author luxz
 * @date 2022/11/7-02:20
 */
public class OperationFactory {
    public static Operation CreateOperate(String op) {
        Operation operation = null;
        switch (op) {
            case "+":
                operation = new OperatorAdd();
                break;
            case "-":
                operation = new OperatorSub();
                break;
            case "*":
                operation = new OperatorMul();
                break;
            case "/":
                operation = new OperatorDiv();
                break;
        }
        return operation;
    }
}
