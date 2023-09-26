package org.example.task2;

import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog2 implements Pet2 {

    public Dog2() {
        System.out.println("Bean для Dog второй вариант");
    }

    @Override
    public void say() {
        System.out.println("Звуки собаки второй вариант");
    }
}
