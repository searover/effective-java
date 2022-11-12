package io.example.patterns.command.cases;

/**
 * @author luxz
 * @date 2022/11/12-21:10
 */
public class BakeMuttonCmd extends Command {
    public BakeMuttonCmd(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.BakeMutton();
    }
}
