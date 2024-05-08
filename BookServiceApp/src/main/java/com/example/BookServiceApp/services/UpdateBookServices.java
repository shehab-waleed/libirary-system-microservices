package com.example.BookServiceApp.services;


import com.example.BookServiceApp.models.Book;
import com.example.BookServiceApp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateBookServices {
    @Autowired
    private BookRepo bookRepo;
    public Optional<?> updateBook(int id, Book bookDetails) {
        Optional<Book> existingBook = bookRepo.findById(id);
        if(bookDetails.getTitle().trim().isEmpty()){
            return Optional.of("book title is empty.");
        }if(bookDetails.getAuthor().trim().isEmpty()){
            return Optional.of("book author is empty.");
        }if(bookDetails.getISBN().trim().isEmpty()){
            return Optional.of("book ISBN is empty.");
        }
        if (existingBook.isPresent()) {
            existingBook.get().setTitle(bookDetails.getTitle());
            existingBook.get().setAuthor(bookDetails.getAuthor());
            existingBook.get().setISBN(bookDetails.getISBN());
            existingBook.get().setRackNumber(bookDetails.getRackNumber());
            existingBook.get().setAvailableCopies(bookDetails.getAvailableCopies());
            existingBook.get().setTotalCopies(bookDetails.getTotalCopies());
            existingBook.get().setImageLink(bookDetails.getImageLink());
            return Optional.of(bookRepo.save(existingBook.get()));
        }
        return Optional.of(("Book with id " + id + " not found"));
    }

    public boolean bookIsExist(int id) {
        return bookRepo.findById(id).isPresent();
    }
}





