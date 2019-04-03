package net.mindview.innerclasses;

/**
 * Very simple to just implement the interface.
 */
public class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}
