package org.example.task1;

public class Person1 {
    public Pet1 pet;

    public String surname;

    public int age;

    public Person1(Pet1 pet) {
        System.out.println("Bean для Person создан");
        this.pet = pet;
    }

    public void setPet(Pet1 pet) {
        System.out.println("Получен Pet");
        this.pet = pet;
    }

    public void sayHello() {
        System.out.println("Привет");
        pet.say();
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
