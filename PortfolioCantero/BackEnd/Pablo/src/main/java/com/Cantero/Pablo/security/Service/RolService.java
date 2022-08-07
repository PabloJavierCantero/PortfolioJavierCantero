
package com.Cantero.Pablo.security.Service;

import com.Cantero.Pablo.security.Entity.Rol;
import com.Cantero.Pablo.security.Enums.RolNombre;
import com.Cantero.Pablo.security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    
    }
    
    public void save(Rol rol){
        
        irolRepository.save(rol);    
    }  
}
