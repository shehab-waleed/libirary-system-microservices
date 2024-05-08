package com.example.BookServiceApp.controller;


import com.example.BookServiceApp.models.Book;
import com.example.BookServiceApp.services.UpdateBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class UpdateBookController {
    @Autowired
    UpdateBookServices updateBookServices;
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<?>updateBook(@PathVariable int id, @RequestBody Book bookDetails){
        Optional<?> updatedBook =updateBookServices.updateBook(id,bookDetails);
        return ResponseEntity.ok(updatedBook);

    }

}
