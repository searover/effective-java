package io.effective.model;

import java.util.Date;

public class Person {
    private final String name;
    private int age;
    private Date birthday;
    private Boolean deleted;

    protected Person(Object name) {
        System.out.println("object invoked");
        this.name = name.toString();
    }

    protected Person(String name) {
        this.name = name;
    }
}
