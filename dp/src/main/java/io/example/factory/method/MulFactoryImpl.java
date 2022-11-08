package io.example.factory.method;

import io.example.factory.Operation;
import io.example.factory.OperatorMul;

/**
 * @author luxz
 * @date 2022/11/8-20:53
 */
public class MulFactoryImpl implements OperatorFactory {
    @Override
    public Operation CreateOperation() {
        return new OperatorMul();
    }
}
