package io.example.patterns.composite;

/**
 * @author luxz
 * @date 2022/11/12-07:27
 */
public class Main {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("A"));
        root.add(new Leaf("B"));

        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));

        root.add(comp);

        Composite comp2 = new Composite("Composite XY");
        comp2.add(new Leaf("Leaf XYA"));
        comp2.add(new Leaf("Leaf XYB"));
        comp.add(comp2);

        root.add(new Leaf("C"));

        Leaf leaf = new Leaf("Leaf D");
        root.add(leaf);
        root.remove(leaf);

        root.display(1);
    }
}
