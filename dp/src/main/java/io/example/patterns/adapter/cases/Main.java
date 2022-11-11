package io.example.patterns.adapter.cases;

/**
 * @author luxz
 * @date 2022/11/12-06:05
 */
public class Main {
    public static void main(String[] args) {
        Player b = new Forwards("巴蒂尔");
        Player m = new Guards("麦克");
        Player z = new Center("YM");

        b.Attack();
        m.Attack();
        z.Attack();
        b.Defence();
        m.Defence();
        z.Defence();

        Player yaoMing = new ForeignCenterAdapter("Yao Ming");
        yaoMing.Attack();
        yaoMing.Defence();
    }
}
