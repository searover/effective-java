package io.example.patterns.adapter.cases;

/**
 * @author luxz
 * @date 2022/11/12-05:58
 */
public class Center extends Player {
    public Center(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.printf("中锋 %s 进攻！\n", name);
    }

    @Override
    public void Defence() {
        System.out.printf("中锋 %s 防守！\n", name);
    }
}
