package org.example.task4;

public class Dog4 implements Pet4 {
    public Dog4() {
        System.out.println("Bean для Dog четвертый вариант");
    }

    @Override
    public void say() {
        System.out.println("Звуки собаки четвертый вариант");
    }
}
