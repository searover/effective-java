package io.example.patterns.interpreter;

/**
 * @author luxz
 * @date 2022/11/13-17:34
 */
public class TerminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        System.out.println("终端解释器");
    }
}
