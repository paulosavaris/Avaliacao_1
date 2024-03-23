package pos.pdwm.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pos.pdwm.entidades.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository <LoginUser, Long> {

    boolean existsByEmail(String email);
    
}
