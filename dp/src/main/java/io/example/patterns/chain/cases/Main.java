package io.example.patterns.chain.cases;

/**
 * @author luxz
 * @date 2022/11/13-07:16
 */
public class Main {
    public static void main(String[] args) {
        CommonManager cm = new CommonManager("金利");
        Majordomo m = new Majordomo("宗剑");
        GeneralManager gm = new GeneralManager("钟精劢");
        cm.setSuperior(m);
        m.setSuperior(gm);

        Request r1 = new Request();
        r1.setRequestType("请假");
        r1.setRequestContent("小菜请假");
        r1.setNumber(1);
        cm.requestApplications(r1);
        Request r2 = new Request();
        r2.setRequestType("请假");
        r2.setRequestContent("小菜请假");
        r2.setNumber(4);
        cm.requestApplications(r2);
        Request r3 = new Request();
        r3.setRequestType("加薪");
        r3.setRequestContent("小菜加薪");
        r3.setNumber(500);
        cm.requestApplications(r3);
        Request r4 = new Request();
        r4.setRequestType("加薪");
        r4.setRequestContent("小菜加薪");
        r4.setNumber(1000);
        cm.requestApplications(r4);
    }
}
