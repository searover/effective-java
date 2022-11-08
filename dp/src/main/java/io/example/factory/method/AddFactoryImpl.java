package io.example.factory.method;

import io.example.factory.Operation;
import io.example.factory.OperatorAdd;

/**
 * @author luxz
 * @date 2022/11/8-20:52
 */
public class AddFactoryImpl implements OperatorFactory {
    @Override
    public Operation CreateOperation() {
        return new OperatorAdd();
    }
}
