package io.example.patterns.iterator;

/**
 * @author luxz
 * @date 2022/11/12-14:22
 */
public class ConcreteIteratorDesc implements Iterator {
    private ConcreteAggregate ca;
    private int current = 0;

    public ConcreteIteratorDesc(ConcreteAggregate ca) {
        this.ca = ca;
        current = ca.count() - 1;
    }

    @Override
    public Object first() {
        return ca.getItems().get(current);
    }

    @Override
    public Object next() {
        current--;
        if (current >= 0) {
            return ca.getItems().get(current);
        }
        return null;
    }

    @Override
    public boolean isDone() {
        return current < 0;
    }

    @Override
    public Object current() {
        return ca.getItems().get(current);
    }
}
