package io.example.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luxz
 * @date 2022/11/12-14:09
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> items = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int count() {
        return items.size();
    }

    public List<Object> getItems() {
        return items;
    }
}