package org.example.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("beanPerson2")
public class Person2 {

    @Autowired
    private Pet2 pet;

    public Person2(@Qualifier("dogBean2") Pet2 pet) {
        System.out.println("Bean для Person второй вариант");
        this.pet = pet;
    }

    public void sayHello() {
        System.out.println("Привет");
        pet.say();
    }
}
