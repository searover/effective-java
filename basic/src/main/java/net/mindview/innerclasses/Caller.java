package net.mindview.innerclasses;

/**
 * @author searover
 */
public class Caller {
    private Incrementable callbackReference;

    Caller(Incrementable cbn) {
        callbackReference = cbn;
    }

    void go() {
        callbackReference.increment();
    }
}
