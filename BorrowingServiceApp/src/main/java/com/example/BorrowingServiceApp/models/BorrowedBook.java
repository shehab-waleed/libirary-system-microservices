package com.example.BorrowingServiceApp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "borrowed_books")
@Data
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "user_id")
    private int userId;


    @Column(name = "book_id")
    private int bookId;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_date")
    private Date borrowDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "status")
    private String status; // Status of the borrowing relationship (e.g., "Approve", "reject")

    // Getters and setters
}
