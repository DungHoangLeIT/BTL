package com.example.BTL.book.repository;

import com.example.BTL.book.entity.BorrowBookUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookUserRepository extends JpaRepository<BorrowBookUser, Integer> {
}
