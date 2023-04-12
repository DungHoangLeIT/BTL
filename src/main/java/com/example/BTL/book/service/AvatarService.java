package com.example.BTL.book.service;

import com.example.BTL.book.entity.Avatar;
import com.example.BTL.book.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarService {
    @Autowired
    private AvatarRepository avatarRepository;

    public String deleteAvatar(int id){
        avatarRepository.deleteById(id);
        return "Delete done";
    }

    public Avatar updateAvatar(int id, Avatar avatar){
        Avatar avatarExisting = avatarRepository.findById(id).orElseThrow();
        avatarExisting.setAvatar(avatar.getAvatar());
        return avatarRepository.save(avatarExisting);
    }

}
