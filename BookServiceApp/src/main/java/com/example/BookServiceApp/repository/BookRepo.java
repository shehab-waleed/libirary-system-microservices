package com.example.BookServiceApp.repository;

import com.example.BookServiceApp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
    Book findByTitle(String title);
    Book findByISBN(String ISBN);
}
