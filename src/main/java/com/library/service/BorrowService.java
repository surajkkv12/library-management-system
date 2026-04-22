package com.library.service;

import com.library.entity.Book;
import com.library.entity.Borrow;
import com.library.entity.User;
import com.library.repository.BookRepository;
import com.library.repository.BorrowRepository;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    public String borrowBook(Long userId, Long bookId, int days) {

        User user = userRepository.findById(userId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (user == null || book == null) {
            return "User or Book not found";
        }

        if (user.getMembershipMonths() <= 0) {
            return "Membership expired";
        }

        if (!"available".equals(book.getStatus())) {
            return "Book not available";
        }

        book.setStatus("taken");
        book.setTakenByUserId(userId);
        bookRepository.save(book);

        Borrow borrow = new Borrow();
        borrow.setUserId(userId);
        borrow.setBookId(bookId);
        borrow.setDays(days);

        borrowRepository.save(borrow);

        return "Book borrowed successfully";
    }

    public String returnBook(Long bookId) {

        Book book = bookRepository.findById(bookId).orElse(null);

        if (book == null) return "Book not found";

        book.setStatus("available");
        book.setTakenByUserId(null);

        bookRepository.save(book);

        return "Book returned successfully";
    }

    public List<Borrow> getUserHistory(Long userId) {
        return borrowRepository.findByUserId(userId);
    }
}