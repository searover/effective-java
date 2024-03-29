package io.example.patterns.composite;

/**
 * @author luxz
 * @date 2022/11/12-07:20
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component c);

    public abstract void remove(Component c);

    public abstract void display(int depth);
}
