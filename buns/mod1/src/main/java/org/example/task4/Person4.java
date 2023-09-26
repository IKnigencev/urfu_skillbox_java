package org.example.task4;

public class Person4 {

    private Pet4 pet;

    public Person4(Pet4 pet) {
        System.out.println("Bean для Person четвертый вариант");
        this.pet = pet;
    }

    public void sayHello() {
        System.out.println("Привет!");
        pet.say();
    }
}
