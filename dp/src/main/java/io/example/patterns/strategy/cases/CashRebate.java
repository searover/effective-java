package io.example.patterns.strategy.cases;

/**
 * @author luxz
 * @date 2022/11/19-13:06
 */
public class CashRebate extends CashSuper {
    private double moneyRebate = 1d;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
