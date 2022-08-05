
package com.Cantero.Pablo.security.Repository;

import com.Cantero.Pablo.security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByEmail(String email);
    boolean existsByNombreUsuario(String nombreUsuario);
    
    
    
}
