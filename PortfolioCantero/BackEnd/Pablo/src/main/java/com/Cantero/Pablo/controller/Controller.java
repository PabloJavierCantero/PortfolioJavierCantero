
package com.Cantero.Pablo.controller;

import com.Cantero.Pablo.model.Persona;
import com.Cantero.Pablo.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    
    @Autowired
    private PersonaService persoServ;
    
    
    @PostMapping("/persona/crear")
    public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    
    @GetMapping ("/persona/ver")
    @ResponseBody
    public List<Persona> verPersonas(){
     return persoServ.verPersonas();
    
    }
    
    @DeleteMapping ("/persona/borrar/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    
    }
    
    @PutMapping ("/persona/editar/{id}")
    public void editarPersona(@PathVariable Long id,
                              @RequestParam ("nombre") String nuevoNombre,
                              @RequestParam ("apellido") String nuevoApellido){
     
        Persona persona = persoServ.buscarPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        
        persoServ.crearPersona(persona);
        
    }
    
}
