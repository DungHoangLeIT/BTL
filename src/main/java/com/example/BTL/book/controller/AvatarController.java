package com.example.BTL.book.controller;

import com.example.BTL.book.dto.OderRequestAvatar;
import com.example.BTL.book.entity.Avatar;
import com.example.BTL.book.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    private AvatarRepository avatarRepository;

    @GetMapping("/getAvatars")
    public List<Avatar> getAllAvatar(){
        return avatarRepository.findAll();
    }

    @PostMapping("/saveAvatar")
    public Avatar creatAvatar(@RequestBody OderRequestAvatar oderRequestAvatar){
        return avatarRepository.save(oderRequestAvatar.getAvatar());
    }
}
