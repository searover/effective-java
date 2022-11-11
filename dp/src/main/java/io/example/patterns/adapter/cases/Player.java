package io.example.patterns.adapter.cases;

/**
 * @author luxz
 * @date 2022/11/12-05:57
 */
public abstract class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void Attack();

    public abstract void Defence();
}
