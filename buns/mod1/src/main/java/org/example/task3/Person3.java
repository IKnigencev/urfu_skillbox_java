package org.example.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class Person3 {

    @Autowired
    public Pet3 pet;

    @Value("${person.surname}")
    public String surname;

    @Value("${person.age}")
    public int age;

    public Person3(Pet3 pet) {
        System.out.println("Bean для Person третий вариант");
        this.pet = pet;
    }

    public void sayHello() {
        System.out.printf("Привет! %s, у тебя возварст %s\n", surname, age);
        pet.say();
    }
}
