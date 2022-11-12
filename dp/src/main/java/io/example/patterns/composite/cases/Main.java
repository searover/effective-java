package io.example.patterns.composite.cases;

/**
 * @author luxz
 * @date 2022/11/12-07:46
 */
public class Main {
    public static void main(String[] args) {
        Company root = new ConcreteCompany("北京总公司");
        root.add(new HRDept("总公司人力资源部"));
        root.add(new FinanceDept("总公司财务部"));

        Company shComp = new ConcreteCompany("上海华东分公司");
        shComp.add(new HRDept("华东分公司人力资源部"));
        shComp.add(new FinanceDept("华东公公司财务部"));
        root.add(shComp);

        Company njComp = new ConcreteCompany("南京办事处");
        njComp.add(new HRDept("南京办事处人力资源部"));
        njComp.add(new FinanceDept("南京办事处财务部"));
        shComp.add(njComp);

        Company hzComp = new ConcreteCompany("杭州办事处");
        hzComp.add(new HRDept("杭州办事处人力资源部"));
        hzComp.add(new FinanceDept("杭州办事处财务部"));
        shComp.add(hzComp);

        System.out.println("结果图:");
        root.display(1);
        System.out.println();
        System.out.println("职责：");
        root.lineOfDuty();
    }
}
