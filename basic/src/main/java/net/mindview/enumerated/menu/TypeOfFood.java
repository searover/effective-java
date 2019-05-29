package net.mindview.enumerated.menu;

public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.BURRITO;
        food = Food.MainCourse.MainCourse.MainCourse.BURRITO;
    }
}
