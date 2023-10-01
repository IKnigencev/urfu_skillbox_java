package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUniLibrary {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(MyConfig.class);

    public static void main(String[] args) {
        System.out.println("Main starts");

        // Тест на получение книги @Before
        TestGetBook();
        // Тест на добавление новой книги @Before
        TestAddBook();
        // Тест на возвращение книги @Around
        TestReturnBookWithoutException();
        // Тест на возвращение книги с ошибкой @Around
        TestReturnBookWithException();

        context.close();
        System.out.println("Main ends");
    }

    public static void TestGetBook() {
        System.out.println("\n\n TestGetBook \n\n");
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        library.getBook(book);
        System.out.println("В библиотеку вернули книгу");
    }

    public static void TestAddBook() {
        System.out.println("\n\n TestAddBook \n\n");
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        Book addedBook = library.addBook("Иван", book);
        System.out.println("В библиотеку добавили книгу" + addedBook.getName());
    }

    public static void TestReturnBookWithoutException() {
        System.out.println("\n\n TestReturnBookWithoutException \n\n");
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        Book returnedBook = library.returnBook(book);
        System.out.println("В библиотеку вернули книгу " + returnedBook.getName());
    }

    public static void TestReturnBookWithException() {
        System.out.println("\n\n TestReturnBookWithException \n\n");
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        try {
            library.returnBookWithException();
        }
        catch (Exception e) {
            System.out.println("Тест завершен в библиотеку не вышло вернуть книгу, ошибка: " + e);
        }
    }
}
