package io.example.patterns.visitor.cases;

/**
 * @author luxz
 * @date 2022/11/13-18:53
 */
public class Main {
    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();
        o.attach(new Man());
        o.attach(new Woman());

        o.display(new Success());
        o.display(new Failing());
        o.display(new Amativeness());
        o.display(new Action() {
            @Override
            public void getManConclusion(Man man) {
                System.out.printf("%s%s时，感慨道，恋爱游戏终结时，'有妻徒刑'遥无期。%n", man, this);
            }

            @Override
            public void getWomenConclusion(Woman woman) {

                System.out.printf("%s%s时，欣慰道，爱情长跑漫漫，婚姻保险保平安。%n", woman, this);
            }

            @Override
            public String toString() {
                return "结婚";
            }
        });
    }
}
