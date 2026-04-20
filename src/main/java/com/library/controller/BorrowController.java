package com.library.controller;

import com.library.entity.Borrow;
import com.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public String borrow(@RequestParam Long userId,
                         @RequestParam Long bookId,
                         @RequestParam int days) {

        return borrowService.borrowBook(userId, bookId, days);
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Long bookId) {
        return borrowService.returnBook(bookId);
    }

    @GetMapping("/history/{userId}")
    public List<Borrow> history(@PathVariable Long userId) {
        return borrowService.getUserHistory(userId);
    }
}