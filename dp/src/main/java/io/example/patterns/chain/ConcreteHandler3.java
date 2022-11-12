package io.example.patterns.chain;

/**
 * @author luxz
 * @date 2022/11/12-21:39
 */
public class ConcreteHandler3 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.printf("%s 处理请求 %s%n", this.getClass().getSimpleName(), request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
