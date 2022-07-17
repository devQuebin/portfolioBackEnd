package com.portfoliomatsuda.Matsuda.services;

import com.portfoliomatsuda.Matsuda.exception.UserNotFoundException;
import com.portfoliomatsuda.Matsuda.models.InfoUs;
import com.portfoliomatsuda.Matsuda.repository.InfoUsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final InfoUsRepo userRepo;

    @Autowired
    public UserService(InfoUsRepo userRepo) {
        this.userRepo = userRepo;
    }
    public InfoUs addUser(InfoUs infoUs){
        return userRepo.save(infoUs);
    }
    public List<InfoUs> buscarUser(){
        return userRepo.findAll();
    }
    public InfoUs editarUser(InfoUs infoUs){
        return userRepo.save(infoUs);
    }
    public void borrarUser(Long id){
        userRepo.deleteById(id);
    }
    public InfoUs buscarUserId(Long id){
        return userRepo.findById(id).orElseThrow(()->new UserNotFoundException("Usuario no encontrado"));
    }
}
