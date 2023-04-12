package com.example.BTL.token;

import com.example.BTL.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date timeExpire;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
