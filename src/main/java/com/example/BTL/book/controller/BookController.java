package com.example.BTL.book.controller;

import com.example.BTL.book.dto.*;
import com.example.BTL.book.entity.Books;
import com.example.BTL.book.repository.BookRepository;
import com.example.BTL.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;
    @PostMapping("/saveBook")
    public Books createBook(@RequestBody OderRequest request){
        return bookRepository.save(request.getBooks());
    }

    @GetMapping("/getBooks")
    public List<Books> findBooks(){
        return bookRepository.findAll();
    }


    @PutMapping("/{id}")
    public Books updatePerson(@PathVariable Integer id, @RequestBody Books books) {
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

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        return bookService.deleteBook(id);
    }

    @GetMapping("/getBookAvatar")
    public List<OderResponse> getJoinBookAvatar(){
        return bookRepository.getJoinBookAvatar();
    }

    @GetMapping("/getBookUserBook")
    public List<OderResponseBookvsUserBook> getJoinBookUserBook(){
        return bookRepository.getJoinBookUserBook();
    }

    @GetMapping("/getBookBorrowBookUser")
    public List<OderResponseBookvsBorrowBookUser> getJoinBookBorrowBookUser(){
        return bookRepository.getJoinBookBorrowBookUser();
    }

    @GetMapping("/getBookCommentBook")
    public List<OderResponseBookvsCommentBook> getJoinBookCommentBook(){
        return bookRepository.getJoinBookBookCommentBook();
    }

}
