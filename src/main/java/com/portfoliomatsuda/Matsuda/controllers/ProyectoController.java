package com.portfoliomatsuda.Matsuda.controllers;

import com.portfoliomatsuda.Matsuda.models.Proyecto;
import com.portfoliomatsuda.Matsuda.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {

    @Autowired
    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }


    @PutMapping
    public ResponseEntity<Proyecto> editarProyecto(@RequestBody Proyecto proyecto){
        Proyecto updateProyecto=proyectoService.editarProyecto(proyecto);
        return new ResponseEntity<>(updateProyecto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Proyecto>> obtenerProyecto(){
        List<Proyecto> proyectos=proyectoService.buscarProyecto();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto){
        Proyecto nuevoProyecto=proyectoService.addProyecto(proyecto);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable("id")Long id){
        proyectoService.borrarProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
