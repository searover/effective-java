package io.example.patterns.iterator;

/**
 * @author luxz
 * @date 2022/11/12-14:18
 */
public class Main {
    public static void main(String[] args) {
        ConcreteAggregate ca = new ConcreteAggregate();
        ca.getItems().add("大鸟");
        ca.getItems().add("小菜");
        ca.getItems().add("行李");
        ca.getItems().add("老外");
        ca.getItems().add("公交内部员工");
        ca.getItems().add("小偷");

        Iterator i = ca.createIterator();
        while (!i.isDone()) {
            System.out.printf("%s 请买车票!%n", i.current());
            i.next();
        }
        System.out.println("--------");
        Iterator i2 = new ConcreteIteratorDesc(ca);
        while (!i2.isDone()) {
            System.out.printf("%s 请买车票!%n", i2.current());
            i2.next();
        }
    }
}
