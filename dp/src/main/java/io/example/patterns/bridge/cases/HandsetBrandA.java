package io.example.patterns.bridge.cases;

/**
 * @author luxz
 * @date 2022/11/12-18:37
 */
public class HandsetBrandA extends HandsetBrand {
    @Override
    public void run() {
        System.out.print("Handset brand A - ");
        soft.run();
    }
}
