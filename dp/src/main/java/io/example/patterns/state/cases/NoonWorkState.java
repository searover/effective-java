package io.example.patterns.state.cases;


/**
 * @author luxz
 * @date 2022/11/11-11:24
 */
public class NoonWorkState extends WorkState {
    @Override
    public void Coding(Work work) {
        System.out.println("Check noon work state...");
        if (work.getWorkHour() < 13) {
            System.out.println("当前时间 " + work.getWorkHour() + " 点，饿了，午饭、犯困、午休");
        } else {
            work.setCurrentState(new AfternoonWorkState());
            work.coding();
        }
    }
}