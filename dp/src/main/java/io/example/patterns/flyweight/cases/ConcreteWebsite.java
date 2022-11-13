package io.example.patterns.flyweight.cases;

/**
 * @author luxz
 * @date 2022/11/13-17:10
 */
public class ConcreteWebsite extends Website {
    private String name;

    public ConcreteWebsite(String name) {
        this.name = name;
    }

    @Override
    public void use(User user) {
        System.out.println("网站分类：" + name + ", 用户：" + user.getName());
    }
}
