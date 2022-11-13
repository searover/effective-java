package io.example.patterns.visitor.cases;

/**
 * @author luxz
 * @date 2022/11/13-18:48
 */
public class Failing extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.printf("%s%s时，闷头喝酒，谁也不用劝。%n", man, this);
    }

    @Override
    public void getWomenConclusion(Woman woman) {
        System.out.printf("%s%s时，眼泪汪汪，谁也劝不了。%n", woman, this);
    }

    @Override
    public String toString() {
        return "失败";
    }
}
