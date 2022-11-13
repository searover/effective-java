package io.example.patterns.interpreter.cases;

/**
 * @author luxz
 * @date 2022/11/13-17:38
 */
public abstract class Expression {
    public void interpret(PlayContext context) {
        if (context.getText().length() == 0) {
            return;
        }
        String playKey = context.getText().substring(0, 1);
        context.setText(context.getText().substring(2));
        double playValue = Double.parseDouble(context.getText().substring(0, context.getText().indexOf(" ")));
        context.setText(context.getText().substring(context.getText().indexOf(" ") + 1));
        execute(playKey, playValue);
    }

    public abstract void execute(String key, double value);
}
