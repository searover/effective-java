package io.effective.model;

public class Man extends Person{
    private final Object name;

    public Man(Object name) {
        super(name.toString());
        this.name = name;
    }
}
