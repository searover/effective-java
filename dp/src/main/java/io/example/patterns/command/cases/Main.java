package io.example.patterns.command.cases;

/**
 * @author luxz
 * @date 2022/11/12-21:11
 */
public class Main {
    public static void main(String[] args) {
        Barbecuer b = new Barbecuer();
        Command bmc = new BakeMuttonCmd(b);
        Command bcwc = new BakeChickenWingCmd(b);
        Waiter w = new Waiter();

        w.setOrder(bmc);
        w.setOrder(bmc);
        w.setOrder(bmc);
        w.setOrder(bmc);
        w.Notify();
        w.setOrder(bcwc);
        w.setOrder(bmc);
        w.setOrder(bmc);
        w.Notify();
    }
}
