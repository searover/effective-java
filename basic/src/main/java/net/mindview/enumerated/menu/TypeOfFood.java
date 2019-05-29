package net.mindview.enumerated.menu;

import net.mindview.enumerated.menu.Food;

public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.BURRITO;
        food = Food.MainCourse.MainCourse.MainCourse.BURRITO;
    }
}
