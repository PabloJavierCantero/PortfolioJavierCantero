
package com.Cantero.Pablo.security.Service;

import com.Cantero.Pablo.security.Entity.Usuario;
import com.Cantero.Pablo.security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    IUsuarioRepository iusuariorepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuariorepository.findByNombreUsuario(nombreUsuario);       
        
    
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        
        return iusuariorepository.existsByNombreUsuario(nombreUsuario);    
    
    }
    
    public boolean existsByEmail(String email){
        
        return iusuariorepository.existsByEmail(email);    
    
    }
    
    public void save(Usuario usuario){
        
        iusuariorepository.save(usuario);
    
    }
    
    
    
}
