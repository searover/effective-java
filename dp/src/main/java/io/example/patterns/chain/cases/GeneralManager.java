package io.example.patterns.chain.cases;

/**
 * @author luxz
 * @date 2022/11/13-07:14
 */
public class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if (request.getRequestType().equals("请假")) {
            System.out.printf("%s : %s 数量 %d 被批准%n", name, request.getRequestContent(), request.getNumber());
        } else if (request.getRequestType().equals("加薪") && request.getNumber() <= 500) {
            System.out.printf("%s : %s 数量 %d 被批准%n", name, request.getRequestContent(), request.getNumber());
        } else if (request.getRequestType().equals("加薪") && request.getNumber() > 500) {
            System.out.printf("%s : %s 数量 %d 再说吧%n", name, request.getRequestContent(), request.getNumber());
        }
    }
}
