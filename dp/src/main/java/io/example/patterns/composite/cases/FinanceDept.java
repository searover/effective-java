package io.example.patterns.composite.cases;

/**
 * @author luxz
 * @date 2022/11/12-07:45
 */
public class FinanceDept extends Company {
    public FinanceDept(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {

    }

    @Override
    public void remove(Company c) {

    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.printf("-");
        }
        System.out.println(name);
    }

    @Override
    public void lineOfDuty() {
        System.out.printf("%s 公司财务收支管理%n", name);
    }
}
