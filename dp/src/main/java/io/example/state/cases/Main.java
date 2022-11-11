package io.example.state.cases;

/**
 * @author luxz
 * @date 2022/11/12-05:31
 */
public class Main {
    public static void main(String[] args) {
        Work emerProj = new Work();
        emerProj.setWorkHour(9);
        emerProj.coding();
        emerProj.setWorkHour(10);
        emerProj.coding();
        emerProj.setWorkHour(12);
        emerProj.coding();
        emerProj.setWorkHour(13);
        emerProj.coding();
        emerProj.setWorkHour(14);
        emerProj.coding();
        emerProj.setWorkHour(17);
        emerProj.coding();
        emerProj.setFinished(true);
        emerProj.coding();
        emerProj.setWorkHour(19);
        emerProj.coding();
        emerProj.setWorkHour(22);
        emerProj.coding();
    }
}
