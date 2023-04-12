package com.example.BTL.book.dto;

import com.example.BTL.book.entity.Avatar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OderRequestAvatar {
    private Avatar avatar;
}
