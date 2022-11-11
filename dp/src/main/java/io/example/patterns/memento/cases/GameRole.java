package io.example.patterns.memento.cases;

/**
 * @author luxz
 * @date 2022/11/12-06:50
 */
public class GameRole {
    private int vitality;
    private int attack;
    private int defense;

    public GameRole() {
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void displayState() {
        System.out.println("角色当前状态：");
        System.out.printf("体力：%s%n", vitality);
        System.out.printf("攻击力：%s%n", attack);
        System.out.printf("防御力：%s%n%n", defense);
    }

    public void initState() {
        this.vitality = 100;
        this.attack = 30;
        this.defense = 50;
    }

    public void Fight() {
        this.vitality -= 10;
        this.attack -= 3;
        this.defense -= 5;
    }

    public RoleStateMemento createMemento() {
        return new RoleStateMemento(vitality, attack, defense);
    }

    public void setMemento(RoleStateMemento memento) {
        this.vitality = memento.getVitality();
        this.attack = memento.getAttack();
        this.defense = memento.getDefense();
    }
}
