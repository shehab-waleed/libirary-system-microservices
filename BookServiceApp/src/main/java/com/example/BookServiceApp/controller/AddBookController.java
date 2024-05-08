package com.example.BookServiceApp.controller;


import com.example.BookServiceApp.models.Book;
import com.example.BookServiceApp.services.AddBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AddBookController {

    @Autowired
    private AddBookServices addBookServices;



    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(
            @RequestBody Book book
    ) {
        if(book.getTitle().trim().isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("book title is empty.");
        }if(book.getAuthor().trim().isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("book author is empty.");
        }if(book.getISBN().trim().isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("book ISBN is empty.");
        }
        if (!addBookServices.isTitleAvailable(book.getTitle())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("book title already exists.");
        }
        if (!addBookServices.isISBNAvailable(book.getISBN())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("isbn already exists.");
        }
        addBookServices.addBook(book);
        return ResponseEntity.ok(book);
    }

}
