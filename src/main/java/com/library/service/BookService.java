package com.library.service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        book.setStatus("available");
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    public List<Book> getByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getByStatus(String status) {
        return bookRepository.findByStatus(status);
    }

    public List<Book> getByName(String name) {
        return bookRepository.findByName(name);
    }

    // REPORT API
    public List<String> getCategoryReport() {

        List<Object[]> data = bookRepository.countBooksByCategory();

        long total = 0;
        for (Object[] row : data) {
            total += (long) row[1];
        }

        List<String> result = new ArrayList<>();

        for (Object[] row : data) {
            String category = (String) row[0];
            long count = (long) row[1];

            double percent = total == 0 ? 0 : (count * 100.0) / total;
            result.add(category + " : " + percent + "%");
        }

        return result;
    }
}