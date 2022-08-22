
package com.Cantero.Pablo.controller;

import com.Cantero.Pablo.dto.dtoHys;
import com.Cantero.Pablo.entity.Hys;
import com.Cantero.Pablo.security.Controller.Mensaje;
import com.Cantero.Pablo.service.SHys;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hys")
@CrossOrigin (origins = "http://localhost:4200")
public class CHys {
    
    @Autowired
    SHys sHys;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list(){
        List<Hys> list = sHys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") int id){
        if(!sHys.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id de HyS no existe"), HttpStatus.BAD_REQUEST);
        }
        Hys person = sHys.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHys.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id de HyS no existe"), HttpStatus.NOT_FOUND);
        }
        sHys.delete(id);
        return new ResponseEntity(new Mensaje("HyS fue eliminado correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys){
        Hys hys = new Hys(dtohys.getResolucion(), dtohys.getGestion(), dtohys.getEquipo(), dtohys.getHabilidades(), dtohys.getIngles(), dtohys.getFullstack());   
        sHys.save(hys);
        return new ResponseEntity(new Mensaje("Hys creado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys){
        if(!sHys.existsById(id)){
            return new ResponseEntity(new Mensaje("El id de HyS no existe"), HttpStatus.NOT_FOUND);
        } 
        Hys hys = sHys.getOne(id).get();
        hys.setResolucion(dtohys.getResolucion());
        hys.setGestion(dtohys.getGestion());
        hys.setEquipo(dtohys.getEquipo());
        hys.setHabilidades(dtohys.getHabilidades());
        hys.setIngles(dtohys.getIngles());
        hys.setFullstack(dtohys.getFullstack());
        
        sHys.save(hys);
        return new ResponseEntity(new Mensaje("HyS actualizado correctamente"), HttpStatus.OK);
    }
    
    
    
    
}
