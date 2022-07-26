package com.portfoliomatsuda.Matsuda.controllers;

import com.portfoliomatsuda.Matsuda.models.Info;
import com.portfoliomatsuda.Matsuda.services.InfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/info")
@CrossOrigin(origins = "http://localhost:4200")
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Info> obtenerInfo(@PathVariable("id") Long id){
        Info info = infoService.buscarInfoId(id);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Info> editarInfo(@RequestBody Info info){
        Info updateInfo = infoService.editarInfo(info);
        return new ResponseEntity<>(updateInfo, HttpStatus.OK);
    }


}
