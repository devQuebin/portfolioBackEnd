package com.portfoliomatsuda.Matsuda.controllers;

import com.portfoliomatsuda.Matsuda.models.User;
import com.portfoliomatsuda.Matsuda.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> obtenerUsuario(@PathVariable("id") Long id){
        User user=userService.buscarUserId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<User> editarUser(@RequestBody User user){
        User updateUser=userService.editarUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
}
