package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/category/{category}")
    public List<Book> byCategory(@PathVariable String category) {
        return bookService.getByCategory(category);
    }

    @GetMapping("/author/{author}")
    public List<Book> byAuthor(@PathVariable String author) {
        return bookService.getByAuthor(author);
    }

    @GetMapping("/status/{status}")
    public List<Book> byStatus(@PathVariable String status) {
        return bookService.getByStatus(status);
    }

    @GetMapping("/name/{name}")
    public List<Book> byName(@PathVariable String name) {
        return bookService.getByName(name);
    }

    @GetMapping("/report")
    public List<String> report() {
        return bookService.getCategoryReport();
    }
}