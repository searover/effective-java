package io.example.patterns.bridge.cases;

/**
 * @author luxz
 * @date 2022/11/12-18:33
 */
public abstract class HandsetBrand {
    protected HandsetSoft soft;

    public void setHandsetSoft(HandsetSoft soft) {
        this.soft = soft;
    }

    public abstract void run();
}
