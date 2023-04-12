package com.example.BTL.book.service;

import com.example.BTL.book.entity.Avatar;
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

    public Books updateBook(int id, Books books){
        Books existingBook = bookRepository.findById(id).orElseThrow();
        existingBook.setTitle(books.getTitle());
        existingBook.setAuthor(books.getAuthor());
        existingBook.setCategory(books.getCategory());
        existingBook.setDescription(books.getDescription());
        existingBook.setNumberPage(books.getNumberPage());
        existingBook.setPrice(books.getPrice());
        existingBook.setReleaseDate(books.getReleaseDate());
        return bookRepository.save(existingBook);
    }
}
