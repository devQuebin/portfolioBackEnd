package com.portfoliomatsuda.Matsuda.controllers;

import com.portfoliomatsuda.Matsuda.models.InfoUs;
import com.portfoliomatsuda.Matsuda.services.InfoUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/infous")
@CrossOrigin(origins = "http://localhost:4200")
public class InfoUsController {
    @Autowired
    private final InfoUsService infoUsService;

    public InfoUsController(InfoUsService infoUsService) {
        this.infoUsService = infoUsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoUs> obtenerInfoId(@PathVariable("id") Long id){
        InfoUs infoUs = infoUsService.buscarUserId(id);
        return new ResponseEntity<>(infoUs, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<InfoUs> editarUser(@RequestBody InfoUs infoUs){
        InfoUs updateInfoUs = infoUsService.editarUser(infoUs);
        return new ResponseEntity<>(updateInfoUs, HttpStatus.OK);
    }
}
