package com.example.BorrowingServiceApp.services;


import com.example.BorrowingServiceApp.models.BorrowedBook;
import com.example.BorrowingServiceApp.repository.BorrowBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowedBookServices {

    @Autowired
    private BorrowBookRepo borrowedBookRepository;

    private BorrowedBook borrowedBook;

    private int borrowBookId;

    // borrowBook
    public void borrowBook(int userId, int bookId) {

            // Create a new BorrowedBook entity
            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBook.setBookId(bookId);
            borrowedBook.setUserId(userId);
            borrowedBook.setBorrowDate(new Date());
            LocalDate currentDate = LocalDate.now();
            LocalDate returnDate = currentDate.plusWeeks(1);
            borrowedBook.setReturnDate(java.sql.Date.valueOf(returnDate));
            borrowedBook.setStatus("Borrowed");
            // Save the borrowing record to the database
            borrowedBookRepository.save(borrowedBook);

    }

    // get
    public List<BorrowedBook> getBorrowedBooks() {
        return borrowedBookRepository.findAll();
    }

    // return
    public void returnBorrowedBook(int userId, int bookId) {


        if(checkBorrowedBooksByBookId(bookId,userId) ){

                Optional<BorrowedBook> borrowedBook = borrowedBookRepository.findById(borrowBookId);

                if(borrowedBook.isPresent()){
                    borrowedBook.get().setStatus("returned");
                    borrowedBook.get().setReturnDate(new Date());

                    borrowedBookRepository.save(borrowedBook.get());
                }
            }
            else {
                throw new IllegalArgumentException("this user didn't borrow this book ");
            }
        }

    public Boolean checkBorrowedBooksByBookId(int bookId,int userId) {

        List<BorrowedBook> borrowedBookList = borrowedBookRepository.findAll();
        boolean hasBorrowedBooks = false;
        for (BorrowedBook borrowedBook : borrowedBookList) {
            if (borrowedBook.getBookId()== bookId && borrowedBook.getUserId()==userId && !borrowedBook.getStatus().equals("returned")) {
                hasBorrowedBooks = true;
                // id
                borrowBookId = borrowedBook.getId();
                return hasBorrowedBooks ;
            }
        }
        return hasBorrowedBooks;
    }


}

