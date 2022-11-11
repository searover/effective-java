package io.example.state.cases;


/**
 * @author luxz
 * @date 2022/11/11-11:23
 */
public class ForenoonWorkState extends WorkState {

    @Override
    public void Coding(Work w) {
        System.out.println("Check forenoon work state...");
        if (w.getWorkHour() < 12) {
            System.out.println("当前时间: " + w.getWorkHour() + " 点，上午工作精神百倍！");
        } else {
            w.setCurrentState(new NoonWorkState());
            w.coding();
        }
    }
}
