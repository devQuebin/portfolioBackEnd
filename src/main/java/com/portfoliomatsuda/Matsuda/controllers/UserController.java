package com.portfoliomatsuda.Matsuda.controllers;

import com.portfoliomatsuda.Matsuda.models.InfoUs;
import com.portfoliomatsuda.Matsuda.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<InfoUs> obtenerUsuario(@PathVariable("id") Long id){
        InfoUs infoUs =userService.buscarUserId(id);
        return new ResponseEntity<>(infoUs, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<InfoUs> editarUser(@RequestBody InfoUs infoUs){
        InfoUs updateInfoUs =userService.editarUser(infoUs);
        return new ResponseEntity<>(updateInfoUs, HttpStatus.OK);
    }
}
