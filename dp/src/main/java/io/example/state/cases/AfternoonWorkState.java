package io.example.state.cases;


/**
 * @author luxz
 * @date 2022/11/11-11:24
 */
public class AfternoonWorkState extends WorkState {
    @Override
    public void Coding(Work work) {
        System.out.println("Check afternoon work state...");
        if (work.getWorkHour() < 17) {
            System.out.println("当前时间：" + work.getWorkHour() + " 点，下午状态不错，继续努力");
        } else {
            work.setCurrentState(new EveningWorkState());
            work.coding();
        }
    }
}
