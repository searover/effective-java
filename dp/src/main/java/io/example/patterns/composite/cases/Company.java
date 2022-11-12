package io.example.patterns.composite.cases;

/**
 * @author luxz
 * @date 2022/11/12-07:39
 */
public abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company c);

    public abstract void remove(Company c);

    public abstract void display(int depth);

    public abstract void lineOfDuty();
}
