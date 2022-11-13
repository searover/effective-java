package io.example.patterns.visitor.cases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luxz
 * @date 2022/11/13-18:53
 */
public class ObjectStructure {
    private List<Person> people = new ArrayList<>();

    public void attach(Person p) {
        people.add(p);
    }

    public void remove(Person p) {
        people.remove(p);
    }

    public void display(Action action) {
        for (Person person : people) {
            person.accept(action);
        }
    }
}
