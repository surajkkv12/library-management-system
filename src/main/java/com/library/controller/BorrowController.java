package com.library.controller;

import com.library.dto.ApiResponse;
import com.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public ApiResponse borrow(@RequestParam Long userId,
                              @RequestParam Long bookId,
                              @RequestParam int days) {

        return borrowService.borrowBook(userId, bookId, days);
    }
}