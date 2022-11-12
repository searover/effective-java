package io.example.patterns.chain.cases;

/**
 * @author luxz
 * @date 2022/11/13-07:06
 */
public abstract class Manager {
    protected String name;
    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    public abstract void requestApplications(Request request);
}
