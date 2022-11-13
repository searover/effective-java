package io.example.patterns.visitor.cases;

/**
 * @author luxz
 * @date 2022/11/13-18:51
 */
public class Amativeness extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.printf("%s%s时，凡事不懂也要装懂。%n", man, this);
    }

    @Override
    public void getWomenConclusion(Woman woman) {
        System.out.printf("%s%s时，遇事懂也装作不懂。%n", woman, this);
    }

    @Override
    public String toString() {
        return "恋爱";
    }
}
