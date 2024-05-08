package com.example.BorrowingServiceApp.repository;

import com.example.BorrowingServiceApp.models.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowBookRepo extends JpaRepository<BorrowedBook,Integer> {

    List<BorrowedBook> findByUserId(int userId);
    Optional<BorrowedBook> findByUserIdAndBookId(int userId, int bookId);

}
