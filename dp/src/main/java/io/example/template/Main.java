package io.example.template;

/**
 * @author luxz
 * @date 2022/11/8-22:59
 */
public class Main {
    public static void main(String[] args) {
        TestPaper t1 = new TestPaperA();
        t1.QuestionOne();
        t1.QuestionTwo();
        t1.QuestionThree();
        TestPaper t2 = new TestPaperB();
        t2.QuestionOne();
        t2.QuestionTwo();
        t2.QuestionThree();
    }
}
