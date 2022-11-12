package io.example.patterns.bridge.cases;

/**
 * @author luxz
 * @date 2022/11/12-18:38
 */
public class Main {
    public static void main(String[] args) {
        HandsetBrand handset = new HandsetBrandA();
        handset.setHandsetSoft(new HandsetGame());
        handset.run();
        handset = new HandsetBrandB();
        handset.setHandsetSoft(new HandsetAddressList());
        handset.run();
    }
}
