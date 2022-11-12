package io.example.patterns.chain;

/**
 * @author luxz
 * @date 2022/11/12-21:40
 */
public class Main {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        h1.handleRequest(31);
    }
}
