/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.ecomerce_v1.infrastructure.adapter;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ecomerce_v1.app.repository.ProductRepository;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ecomerce_v1.infrastructure.entity.UserEntity;

/**
 *
 * @author tpp
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private final ProductCrudRepository  productCrudRepository;

    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    @Override
    public Iterable<ProductEntity> getProducts() {
  return productCrudRepository.findAll();
    }

    @Override
    public Iterable<ProductEntity> getProductByUser(UserEntity userEntity) {
    return productCrudRepository.findByUserEntity(userEntity);
    }

    @Override
    public ProductEntity getProductById(Integer id) {
   
         return productCrudRepository.findById(id).get();
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
  return productCrudRepository.save(productEntity);
    
    }

    @Override
    @Transactional                       
    public boolean deleteProductById(Integer id) {
          productCrudRepository.deleteById(id);  
          return true;
    }
    
  
    
}
