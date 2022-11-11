package io.example.patterns.state.cases;


/**
 * @author luxz
 * @date 2022/11/11-11:24
 */
public class EveningWorkState extends WorkState {
    @Override
    public void Coding(Work work) {
        System.out.println("Check evening work state...");
        if (work.isFinished()) {
            work.setCurrentState(new RestState());
            work.coding();
        } else {
            if (work.getWorkHour() < 22) {
                System.out.println("当前时间： " + work.getWorkHour() + " 点，加班哦，疲累之极。");
            } else {
                work.setCurrentState(new SleepingState());
                work.coding();
            }
        }
    }
}
