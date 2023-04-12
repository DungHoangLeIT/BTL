package com.example.BTL.book.repository;

import com.example.BTL.book.entity.userBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookRepository extends JpaRepository<userBook, Integer> {
}
