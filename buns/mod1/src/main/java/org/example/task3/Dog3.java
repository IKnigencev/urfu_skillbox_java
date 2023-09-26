package org.example.task3;

import org.springframework.stereotype.Component;

@Component
public class Dog3 implements Pet3 {

    public Dog3() {
        System.out.println("Bean для dog создан третий вариант");
    }

    @Override
    public void say() { System.out.println("Звуки собаки третий вариант"); }
}
