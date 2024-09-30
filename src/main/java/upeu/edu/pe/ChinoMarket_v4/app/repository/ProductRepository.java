
package upeu.edu.pe.ChinoMarket_v4.app.repository;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.UserEntity;

@Repository
public interface ProductRepository {
    Iterable<ProductEntity>getProducts();
    Iterable<ProductEntity>getProductByUser(UserEntity userEntity);
    ProductEntity getProductById(Integer id);
    ProductEntity saveProduct(ProductEntity productEntity);
    boolean deleteProductById(Integer id);
}
