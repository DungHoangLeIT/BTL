package com.example.BTL.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
@ToString
public class CommentBook {
    @Id
    private int id;
    private String comment;
}
