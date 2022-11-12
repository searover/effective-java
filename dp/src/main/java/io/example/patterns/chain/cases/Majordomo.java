package io.example.patterns.chain.cases;

/**
 * @author luxz
 * @date 2022/11/13-07:13
 */
public class Majordomo extends Manager {
    public Majordomo(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if (request.getRequestType().equals("请假") && request.getNumber() <= 5) {
            System.out.printf("%s : %s 数量 %d 被批准%n", name, request.getRequestContent(), request.getNumber());
        } else if (superior != null) {
            superior.requestApplications(request);
        }
    }
}
