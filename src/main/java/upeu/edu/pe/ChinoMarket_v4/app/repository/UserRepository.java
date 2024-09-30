
package upeu.edu.pe.ChinoMarket_v4.app.repository;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.UserEntity;

@Repository
public interface UserRepository {
    //crea un nuevo usuario
    public abstract UserEntity created(UserEntity userEntity);
    public UserEntity findByEmail(String email);
    public UserEntity finById(Integer id);
}
