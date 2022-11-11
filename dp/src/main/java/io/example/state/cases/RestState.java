package io.example.state.cases;

/**
 * @author luxz
 * @date 2022/11/12-05:27
 */
public class RestState extends WorkState {
    @Override
    public void Coding(Work work) {
        System.out.println("Check rest work state...");
        System.out.println("当前时间： " + work.getWorkHour() + " 点，下班回家了。");
    }
}
