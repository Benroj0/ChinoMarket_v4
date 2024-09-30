
package upeu.edu.pe.ChinoMarket_v4.infrastructure.adapter;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.UserEntity;

@Repository
public interface UserCrudRepository extends CrudRepository<UserEntity, Integer>{

    public Optional<UserEntity> findByEmail(String email);
}
