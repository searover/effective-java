package io.example.patterns.strategy.cases;

/**
 * @author luxz
 * @date 2022/11/19-13:06
 */
public class CashContext {
    private CashSuper cashSuper;

    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                cashSuper = new CashNormal();
                break;
            case "满300减100":
                cashSuper = new CashReturn(300, 100);
                break;
            case "打 8 折":
                cashSuper = new CashRebate(0.8);
                break;
        }
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
