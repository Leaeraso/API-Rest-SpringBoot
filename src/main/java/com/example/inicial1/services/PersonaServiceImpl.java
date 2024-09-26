package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

// Indica que la clase es responsable de llevar a cabo operaciones complejas relacionadas con los datos(reglas de negocio).
@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    @Autowired
    private PersonaRepository pr;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepo){
        super(baseRepo);
    }

    //@Override
    //public List<Persona> search(String filter) throws Exception {
    //    try {
    //        //List<Persona> personas = pr.findByNombreContainingOrApellidoContaining(filter, filter);
    //        //List<Persona> personas = pr.search(filter);
    //        //List<Persona> personas = pr.nativeSearch(filter);

            //return personas;
    //    } catch (Exception e) {
    //        throw new Exception(e.getMessage());
    //    }
    //}

    @Override
    public Page<Persona> search(String filter, Pageable p) throws Exception {
        try {
            //Page<Persona> personas = pr.findByNombreContainingOrApellidoContaining(filter, filter);
            //Page<Persona> personas = pr.search(filter);
            Page<Persona> personas = pr.nativeSearch(filter, p);


            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
