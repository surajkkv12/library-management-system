package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b.category, COUNT(b) FROM Book b WHERE b.status='taken' GROUP BY b.category")
	List<Object[]> countBooksByCategory();
    List<Book> findByCategory(String category);
    List<Book> findByAuthor(String author);
    List<Book> findByStatus(String status);
}