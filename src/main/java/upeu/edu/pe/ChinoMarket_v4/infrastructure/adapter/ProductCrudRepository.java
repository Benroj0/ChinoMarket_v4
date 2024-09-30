
package upeu.edu.pe.ChinoMarket_v4.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.UserEntity;

public interface ProductCrudRepository extends  CrudRepository<ProductEntity, Integer>{
     Iterable<ProductEntity>findByUserEntity(UserEntity userEntity);
}
