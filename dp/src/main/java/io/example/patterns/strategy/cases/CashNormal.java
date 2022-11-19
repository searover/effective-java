package io.example.patterns.strategy.cases;

/**
 * @author luxz
 * @date 2022/11/19-13:06
 */
public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
