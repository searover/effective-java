package io.example.patterns.bridge.cases;

/**
 * @author luxz
 * @date 2022/11/12-18:38
 */
public class HandsetBrandB extends HandsetBrand {
    @Override
    public void run() {
        System.out.print("Handset brand B - ");
        soft.run();
    }
}
