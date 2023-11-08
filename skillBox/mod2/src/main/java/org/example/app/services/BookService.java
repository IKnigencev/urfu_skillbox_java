package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    private final ProjectRepository<Book> bookRepo;
    private final Logger logger = Logger.getLogger(BookService.class);

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    public void defaultInit() {
        logger.info("default INIT in book service");
    }

    public void defaultDestroy() {
        logger.info("default DESTROY in book service");
    }

    /**
     * Метод удаления по регулярному выражению
     */
    public void removeBookByRegex(String queryRegex, Errors errors) {
        if (queryRegex.isBlank()) {
            errors.rejectValue("queryRegex", "Пустое регулярное выражение");
            return;
        }

        List<Book> books = getAllBooks();
        for (Book book : books) {
            if (!needDeleteBook(book, queryRegex)) { continue; }

            removeBookById(book.getId());
        }
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
