package io.example.patterns.flyweight.cases;

/**
 * @author luxz
 * @date 2022/11/13-17:11
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
