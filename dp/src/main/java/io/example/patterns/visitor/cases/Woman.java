package io.example.patterns.visitor.cases;

/**
 * @author luxz
 * @date 2022/11/13-18:44
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomenConclusion(this);
    }

    @Override
    public String toString() {
        return "女人";
    }
}
