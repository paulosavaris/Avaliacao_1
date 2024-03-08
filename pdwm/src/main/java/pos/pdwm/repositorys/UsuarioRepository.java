package pos.pdwm.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pos.pdwm.entidades.Usuarios;

@Repository
public interface UsuarioRepository  extends JpaRepository <Usuarios, Long>{
    
    boolean existsByEmail(String email);
}
