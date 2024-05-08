package com.example.BorrowingServiceApp.controller;



import com.example.BorrowingServiceApp.models.BorrowedBook;
import com.example.BorrowingServiceApp.services.BorrowedBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BorrowedBookController {


    @Autowired
    private BorrowedBookServices borrowedBookService;

    @PostMapping("/borrow-book")
    public ResponseEntity<String> borrowBook(
            @RequestParam int userId,
            @RequestParam int bookId
    ) {
        try {
            borrowedBookService.borrowBook(userId, bookId);
            return ResponseEntity.ok("Book borrowed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to borrow book: " + e.getMessage());
        }
    }



    //get all books ()
    @GetMapping("/getBorrowedBooks")
    public List<BorrowedBook> getBorrowedBooks(){

        return  borrowedBookService.getBorrowedBooks();
    }

    @PutMapping("/returnBorrowedBook/{userId}/{bookId}")
    public ResponseEntity<?>returnBorrowedBook(@PathVariable int userId,@PathVariable int bookId){
        try {
            borrowedBookService.returnBorrowedBook(userId, bookId);
            return ResponseEntity.ok("Book returned successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to return book: " + e.getMessage());
        }
    }



}


