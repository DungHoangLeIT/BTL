package com.example.BTL.book.service;

import com.example.BTL.book.entity.Books;
import com.example.BTL.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public String deleteBook(int id){
        bookRepository.deleteById(id);
        return "delete done";
    }

}
