package io.example.patterns.mediator;

/**
 * @author luxz
 * @date 2022/11/13-13:29
 */
public class Main {
    public static void main(String[] args) {
        ConcreteMediator cm = new ConcreteMediator();
        ConcreteColleague1 c1 = new ConcreteColleague1(cm);
        ConcreteColleague2 c2 = new ConcreteColleague2(cm);
        cm.setColleague1(c1);
        cm.setColleague2(c2);
        c1.send("吃过饭了没？");
        c2.send("没有呢，你打算请客？");
    }
}
