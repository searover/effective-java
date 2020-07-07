package io.effective._32;

public class SingletionOld {
    private static SingletionOld singletionOld;

    private SingletionOld() {

    }

    // 性能很差，因为互斥锁将该方法串行化了
    public static synchronized SingletionOld getInstance() {
        if (singletionOld == null) {
            return new SingletionOld();
        }
        return singletionOld;
    }
}
