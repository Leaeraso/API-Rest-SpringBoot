package com.example.inicial1.controllers;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//  Indica que esta clase es un controlador en Spring que gestionará solicitudes HTTP y devolverá respuestas JSON.
@RestController
// Permite solicitudes desde cualquier origen.
@CrossOrigin(origins = "*")
// Define la ruta base para todas las solicitudes manejadas por este controlador.
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{
    //@GetMapping("/search")
    //public ResponseEntity<?> search(@RequestParam String filter) {
    //    try {
    //        return ResponseEntity.status(HttpStatus.OK).body(service.search(filter));
    //    } catch (Exception e) {
    //        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
    //    }
    //}

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filter, Pageable p) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filter, p));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
