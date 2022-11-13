package io.example.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luxz
 * @date 2022/11/13-18:32
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void attach(Element e) {
        elements.add(e);
    }

    public void remove(Element e) {
        elements.remove(e);
    }

    public void accept(Visitor v) {
        for (Element e : elements) {
            e.accept(v);
        }
    }
}
