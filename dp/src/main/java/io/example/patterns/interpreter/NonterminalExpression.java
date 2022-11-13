package io.example.patterns.interpreter;

/**
 * @author luxz
 * @date 2022/11/13-17:35
 */
public class NonterminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        System.out.println("非终端解释器");
    }
}
