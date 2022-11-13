package io.example.patterns.visitor.cases;

/**
 * @author luxz
 * @date 2022/11/13-18:41
 */
public abstract class Action {
    public abstract void getManConclusion(Man man);

    public abstract void getWomenConclusion(Woman woman);
}
