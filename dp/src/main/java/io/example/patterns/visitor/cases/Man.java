package io.example.patterns.visitor.cases;

/**
 * @author luxz
 * @date 2022/11/13-18:43
 */
public class Man extends Person {

    @Override
    public void accept(Action action) {
        action.getManConclusion(this);
    }

    @Override
    public String toString() {
        return "男人";
    }
}
