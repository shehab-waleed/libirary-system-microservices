package com.example.BookServiceApp.controller;


import com.example.BookServiceApp.models.Book;
import com.example.BookServiceApp.services.GetBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class GetBookController {
    @Autowired
    private GetBookServices getBookServices;
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return  getBookServices.getAllBooks();
    }

//    @GetMapping("/getBookById/{bookId}")
//    public Optional<Book> getBookById(@PathVariable int bookId){
//        return getBookServices.getBookById(bookId);
//    }



}
