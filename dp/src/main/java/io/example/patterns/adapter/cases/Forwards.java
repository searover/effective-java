package io.example.patterns.adapter.cases;

/**
 * @author luxz
 * @date 2022/11/12-05:58
 */
public class Forwards extends Player {
    public Forwards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.printf("前锋 %s 进攻！\n", name);
    }

    @Override
    public void Defence() {
        System.out.printf("前锋 %s 防守！\n", name);
    }
}
