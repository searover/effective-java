package io.example.patterns.iterator;

/**
 * @author luxz
 * @date 2022/11/12-14:09
 */
public class ConcreteIterator implements Iterator {
    private ConcreteAggregate aggregate;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregate.getItems().get(0);
    }

    @Override
    public Object next() {
        current++;
        if (current < aggregate.count()) {
            return aggregate.getItems().get(current);
        }
        return null;
    }

    @Override
    public boolean isDone() {
        return current >= aggregate.count();
    }

    @Override
    public Object current() {
        return aggregate.getItems().get(current);
    }
}
