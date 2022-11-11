package io.example.state;

/**
 * @author luxz
 * @date 2022/11/11-11:12
 */
public class Main {
    public static void main(String[] args) {
        Context ctx = new Context(new ConcreteStateA());
        ctx.Request();
        ctx.Request();
        ctx.Request();
        ctx.Request();
        ctx.Request();
        ctx.Request();
        ctx.Request();
    }
}
