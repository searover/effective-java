package io.example.factory.method;

import io.example.factory.Operation;

/**
 * @author luxz
 * @date 2022/11/8 20:50
 */
public interface OperatorFactory {
    Operation CreateOperation();
}
