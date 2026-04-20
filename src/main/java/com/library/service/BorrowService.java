package com.library.service;

import com.library.entity.*;
import com.library.repository.*;
import com.library.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public ApiResponse borrowBook(Long userId, Long bookId, int days) {

        User user = userRepository.findById(userId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (user == null || book == null) {
            return new ApiResponse("User or Book not found", false);
        }

        if (user.getMembershipMonths() <= 0) {
            return new ApiResponse("Membership expired", false);
        }

        if (!"available".equals(book.getStatus())) {
            return new ApiResponse("Book not available", false);
        }

        book.setStatus("taken");
        book.setTakenByUserId(userId);
        bookRepository.save(book);

        Borrow borrow = new Borrow();
        borrow.setUserId(userId);
        borrow.setBookId(bookId);
        borrow.setIssueDate(LocalDate.now());
        borrow.setReturnDate(LocalDate.now().plusDays(days));

        borrowRepository.save(borrow);

        return new ApiResponse("Book borrowed successfully", true);
    }
}