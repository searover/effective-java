package io.example.patterns.visitor.cases;

/**
 * @author luxz
 * @date 2022/11/13-18:44
 */
public class Success extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.printf("%s%s时，背后多半有一个伟大的女人。%n", man, this);
    }

    @Override
    public void getWomenConclusion(Woman woman) {
        System.out.printf("%s%s时，背后多半有一个不成功的男人。%n", woman, this);
    }

    @Override
    public String toString() {
        return "成功";
    }
}
