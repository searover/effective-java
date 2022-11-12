package io.example.patterns.chain;

/**
 * @author luxz
 * @date 2022/11/12-21:36
 */
public class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.printf("%s 处理请求 %s%n", this.getClass().getSimpleName(), request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
