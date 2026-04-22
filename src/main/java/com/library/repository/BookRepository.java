package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategory(String category);
    List<Book> findByAuthor(String author);
    List<Book> findByStatus(String status);
    List<Book> findByName(String name);

    @Query("SELECT b.category, COUNT(b) FROM Book b WHERE b.status='taken' GROUP BY b.category")
    List<Object[]> countBooksByCategory();
}