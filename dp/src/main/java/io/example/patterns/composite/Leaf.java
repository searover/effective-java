package io.example.patterns.composite;

/**
 * @author luxz
 * @date 2022/11/12-07:22
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("Cannot add to a leaf.");
    }

    @Override
    public void remove(Component c) {
        System.out.println("Cannot remove from a leaf.");
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.printf("-");
        }
        System.out.println(name);
    }
}
