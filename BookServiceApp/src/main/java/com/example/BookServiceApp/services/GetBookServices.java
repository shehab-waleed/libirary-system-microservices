package com.example.BookServiceApp.services;


import com.example.BookServiceApp.models.Book;
import com.example.BookServiceApp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetBookServices {
    @Autowired
    private BookRepo bookRepo;
    public List<Book> getAllBooks(){

        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(int bookId){
        return bookRepo.findById(bookId);
    }



}
