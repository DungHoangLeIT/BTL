package com.example.BTL.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Books {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private float price;
    private String author;
    private int numberPage;
    private String category;
    private Date releaseDate;

    @OneToMany(targetEntity = Avatar.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<Avatar> avatars;

    @OneToMany(targetEntity = userBook.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<userBook> userBooks;

    @OneToMany(targetEntity = BorrowBookUser.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<BorrowBookUser> borrowBookUsers;

    @OneToMany(targetEntity = CommentBook.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<CommentBook> commentBooks;

}
