package io.example.patterns.state.cases;

/**
 * @author luxz
 * @date 2022/11/12-05:29
 */
public class SleepingState extends WorkState {
    @Override
    public void Coding(Work work) {
        System.out.println("Check sleeping work state...");
        System.out.println("当前时间 " + work.getWorkHour() + " 点，不行了睡着了。");
    }
}
