package io.example.patterns.factory.method;

import io.example.patterns.factory.Operation;

/**
 * @author luxz
 * @date 2022/11/8 20:50
 */
public interface OperatorFactory {
    Operation CreateOperation();
}
