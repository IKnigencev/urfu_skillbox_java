package org.example;

import org.example.task1.Dog1;
import org.example.task2.Dog2;
import org.example.task3.Dog3;
import org.example.task4.Dog4;
import org.example.task1.Person1;
import org.example.task2.Person2;
import org.example.task3.Person3;
import org.example.task4.Person4;
import org.example.task4.Pet4;

public class Main {
    public static void main(String[] args) {
        Dog1 dog1 = new Dog1();
        Dog2 dog2 = new Dog2();
        Dog3 dog3 = new Dog3();
        Dog4 dog4 = new Dog4();
        Person1 person1 = new Person1(dog1);
        Person2 person2 = new Person2(dog2);
        Person3 person3 = new Person3(dog3);
        Pet4 pet4 = new Pet4() {
            @Override
            public void say() { System.out.println("Звук"); }
        };
        Person4 person4 = new Person4(pet4);

        dog1.say();
        dog2.say();
        dog3.say();
        dog4.say();

        person1.sayHello();
        person2.sayHello();
        person3.sayHello();
        person4.sayHello();
    }
}