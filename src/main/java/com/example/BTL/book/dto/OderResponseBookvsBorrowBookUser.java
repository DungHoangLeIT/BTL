package com.example.BTL.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OderResponseBookvsBorrowBookUser {
    private String title;
    private int quantity;
    private String status;
}
