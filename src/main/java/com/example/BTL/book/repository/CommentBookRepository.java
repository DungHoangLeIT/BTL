package com.example.BTL.book.repository;

import com.example.BTL.book.entity.CommentBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentBookRepository extends JpaRepository<CommentBook, Integer> {
}
