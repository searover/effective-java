package io.example.patterns.factory.method;

import io.example.patterns.factory.Operation;
import io.example.patterns.factory.OperatorDiv;

/**
 * @author luxz
 * @date 2022/11/8-20:53
 */
public class DivFactoryImpl implements OperatorFactory {
    @Override
    public Operation CreateOperation() {
        return new OperatorDiv();
    }
}
