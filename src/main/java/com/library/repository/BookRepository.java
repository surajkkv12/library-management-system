package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b.category, COUNT(b) FROM Book b GROUP BY b.category")
	List<Object[]> countBooksByCategory();
    List<Book> findByCategory(String category);
    List<Book> findByAuthor(String author);
}