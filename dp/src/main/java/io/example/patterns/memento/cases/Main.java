package io.example.patterns.memento.cases;

/**
 * @author luxz
 * @date 2022/11/12-06:57
 */
public class Main {
    public static void main(String[] args) {
        GameRole lxy = new GameRole();
        lxy.initState();
        lxy.displayState();
        System.out.println("遇到 Boss ，战斗！");
        lxy.Fight();
        lxy.displayState();

        System.out.println("存档……");
        RoleStateCaretaker caretaker = new RoleStateCaretaker();
        caretaker.setRoleStateMemento(lxy.createMemento());

        System.out.println("战斗！");
        lxy.Fight();
        System.out.println("战斗！");
        lxy.Fight();
        System.out.println("战斗！");
        lxy.Fight();
        lxy.displayState();

        System.out.println("回档……");
        lxy.setMemento(caretaker.getRoleStateMemento());
        lxy.displayState();
        System.out.println("战斗！");
        lxy.Fight();
    }
}
