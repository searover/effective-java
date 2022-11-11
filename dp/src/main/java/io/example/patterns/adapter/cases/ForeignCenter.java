package io.example.patterns.adapter.cases;

/**
 * @author luxz
 * @date 2022/11/12-06:07
 */
public class ForeignCenter {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void JinGong() {
        System.out.printf("外籍中锋 %s 进攻！%n", name);
    }

    public void FangShou() {
        System.out.printf("外籍中锋 %s 防守！%n", name);
    }
}
