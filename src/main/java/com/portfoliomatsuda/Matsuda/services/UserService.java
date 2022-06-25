package com.portfoliomatsuda.Matsuda.services;

import com.portfoliomatsuda.Matsuda.exception.UserNotFoundException;
import com.portfoliomatsuda.Matsuda.models.User;
import com.portfoliomatsuda.Matsuda.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final  UsuarioRepo userRepo;

    @Autowired
    public UserService(UsuarioRepo userRepo) {
        this.userRepo = userRepo;
    }
    public User addUser(User user){
        return userRepo.save(user);
    }
    public List<User> buscarUser(){
        return userRepo.findAll();
    }
    public User editarUser(User user){
        return userRepo.save(user);
    }
    public void borrarUser(Long id){
        userRepo.deleteById(id);
    }
    public User buscarUserId(Long id){
        return userRepo.findById(id).orElseThrow(()->new UserNotFoundException("Usuario no encontrado"));
    }
}
