package org.example.app.services;

import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        if (book.getAuthor().isBlank() &&
                (book.getSize() == null || book.getSize() == 0)&&
                    book.getTitle().isBlank()) { return; }

        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    /**
     * Метод удаления по регулярному выражению
     */
    public Integer removeBookByRegex(String queryRegex) {
        if (queryRegex.isBlank()) { return 0; }

        Integer counter = 0;
        List<Book> books = getAllBooks();
        for (Book book : books) {
            if (!needDeleteBook(book, queryRegex)) { continue; }

            counter++;
            removeBookById(book.getId());
        }
        return counter;
    }

    /**
     * Определяем подходит ли регулярка к полям Book
     */
    private boolean needDeleteBook(Book book, String queryRegex) {
        List<String> valuesBook = Arrays.asList(book.getAuthor(), book.getTitle(), String.valueOf(book.getSize()));

        for (String value : valuesBook) {
            if (value.equals(queryRegex) || value.matches(queryRegex)) { return true; }
        }
        return false;
    }
}
