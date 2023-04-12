package com.example.BTL.book.dto;

import com.example.BTL.book.entity.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OderRequest {
    private Books books;
}
