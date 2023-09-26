package org.example.task1;

public class Dog1 implements Pet1 {

    public Dog1() {
        System.out.println("Бин Dog1 первый вариант");
    }

    @Override
    public void say() {
        System.out.println("Звуки лая первый вариант");
    }
}
