
package com.Cantero.Pablo.security.Repository;

import com.Cantero.Pablo.security.Entity.Rol;
import com.Cantero.Pablo.security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);     
}
