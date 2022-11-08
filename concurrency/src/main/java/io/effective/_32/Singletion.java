package io.effective._32;

public class Singletion {
    private static volatile Singletion singletion;

    private Singletion() {
    }

    // 双重检查
    public static Singletion getInstance() {
        // 一旦singletion被实例化了，就不会执行synchronized相关的代码，此时getInstance方法的执行路径是无锁的
        if (singletion == null) {
            synchronized (Singletion.class) {
                if (singletion == null) {
                    singletion = new Singletion();
                }
            }
        }
        return singletion;
    }
}
