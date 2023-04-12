package com.example.BTL.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
