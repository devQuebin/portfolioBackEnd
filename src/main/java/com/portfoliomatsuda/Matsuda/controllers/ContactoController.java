package com.portfoliomatsuda.Matsuda.controllers;

import com.portfoliomatsuda.Matsuda.models.Contacto;
import com.portfoliomatsuda.Matsuda.services.ContactoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacto")
public class ContactoController {

    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService=contactoService;
    }
    @PutMapping("/update")
    public ResponseEntity<Contacto> editarContacto (@RequestBody Contacto contacto){
        Contacto updateContacto=contactoService.editarContacto(contacto);
        return new ResponseEntity<>(updateContacto, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Contacto>> obtenerContacto(){
        List<Contacto> contactos=contactoService.buscarContacto();
        return new ResponseEntity<>(contactos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Contacto> crearContacto(@RequestBody Contacto contacto){
        Contacto nuevoContacto=contactoService.addContacto(contacto);
        return new ResponseEntity<>(nuevoContacto, HttpStatus.CREATED);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarContacto (@PathVariable("id") Long id){
    contactoService.borrarContacto(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}
