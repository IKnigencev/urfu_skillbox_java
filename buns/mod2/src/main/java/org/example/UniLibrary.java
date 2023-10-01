package org.example;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    @Override
    public void getBook(Book book) {
        System.out.println("Мы берем книгу из UniLibrary: " + book.getName());
        System.out.println("----------------------------");
    }

    public Book returnBook(Book book) {
        System.out.println("Мы возвращаем книгу в UniLibrary" + book);
        return book;
    }

    public void returnBookWithException() throws Exception {
        System.out.println("Мы возвращаем книгу в UniLibrary");
        throw new Exception("Ошибка!");
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary");
        System.out.println("----------------------------");
    }

    public void returnMagazine() {
        System.out.println("Мы возвращаем журнал в UniLibrary");
        System.out.println("----------------------------");
    }

    public Book addBook(String person_name, Book book) {
        System.out.println("Пользователь: " + person_name
                + " добавляет книгу в UniLibrary - " + book.getName());
        System.out.println("----------------------------");
        return book;
    }
}
