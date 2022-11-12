package io.example.patterns.composite.cases;

/**
 * @author luxz
 * @date 2022/11/12-07:44
 */
public class HRDept extends Company {
    public HRDept(String name) {
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
        System.out.printf("%s 员工招聘培训管理%n", name);
    }
}
