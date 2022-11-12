package io.example.patterns.chain;

/**
 * @author luxz
 * @date 2022/11/12-21:34
 */
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}