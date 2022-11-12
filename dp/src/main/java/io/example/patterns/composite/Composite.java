package io.example.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luxz
 * @date 2022/11/12-07:24
 */
public class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.printf("-");
        }
        System.out.println(name);
        for (Component child : children) {
            child.display(depth + 2);
        }
    }
}
