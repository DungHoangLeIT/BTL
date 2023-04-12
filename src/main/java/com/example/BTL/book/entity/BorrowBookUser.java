package com.example.BTL.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class BorrowBookUser {
    @Id
    private int id;
    private int quantity;
    private String status;
    private Date borrowedDate;
    private Date payDay;
    private Date paidDate;
}
