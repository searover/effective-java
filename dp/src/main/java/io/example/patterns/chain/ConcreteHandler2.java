package io.example.patterns.chain;

/**
 * @author luxz
 * @date 2022/11/12-21:37
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.printf("%s 处理请求 %s%n", this.getClass().getSimpleName(), request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
