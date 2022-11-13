package io.example.patterns.mediator.cases;

/**
 * @author luxz
 * @date 2022/11/13-16:10
 */
public abstract class Country {
    protected UnitedNations mediator;

    public Country(UnitedNations mediator) {
        this.mediator = mediator;
    }
}
