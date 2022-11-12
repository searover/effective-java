package io.example.patterns.command.cases;

/**
 * @author luxz
 * @date 2022/11/12-21:09
 */
public class BakeChickenWingCmd extends Command {
    public BakeChickenWingCmd(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.BakeChickenWing();
    }
}
