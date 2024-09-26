package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long> {

    //List<Persona> search(String filter) throws Exception;
    Page<Persona> search(String filter, Pageable p) throws Exception;

}
