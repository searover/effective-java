package io.example.patterns.mediator.cases;

/**
 * @author luxz
 * @date 2022/11/13-16:18
 */
public class Main {
    public static void main(String[] args) {
        UnitedNationsSecurityCouncil unsc = new UnitedNationsSecurityCouncil();
        Iraq iraq = new Iraq(unsc);
        USA usa = new USA(unsc);
        unsc.setUsa(usa);
        unsc.setIraq(iraq);

        usa.declare("不准研制核武器，否则要发动战争！");
        iraq.declare("我们没有核武器，也不怕侵略！");
    }
}
