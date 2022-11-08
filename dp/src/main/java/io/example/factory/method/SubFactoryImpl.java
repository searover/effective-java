package io.example.factory.method;

import io.example.factory.Operation;
import io.example.factory.OperatorSub;

/**
 * @author luxz
 * @date 2022/11/8-20:53
 */
public class SubFactoryImpl implements OperatorFactory {
    @Override
    public Operation CreateOperation() {
        return new OperatorSub();
    }
}
