package io.example.patterns.command.cases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luxz
 * @date 2022/11/12-21:11
 */
public class Waiter {
    private List<Command> commands = new ArrayList<>();

    public void setOrder(Command command) {
        if (command instanceof BakeChickenWingCmd) {
            System.out.println("服务员：鸡翅没有了，请点别的烧烤！");
        } else {
            System.out.println("增加订单：" + command.getClass().getSimpleName());
            commands.add(command);
        }
    }

    public void Notify() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
