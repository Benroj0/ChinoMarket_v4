
package upeu.edu.pe.ChinoMarket_v4.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.ChinoMarket_v4.app.repository.ProductRepository;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.UserEntity;

public class ProductService {
    private final UploadFile uploadFile;
         private final ProductRepository productRepository;

    public ProductService(UploadFile uploadFile, ProductRepository productRepository) {
        this.uploadFile = uploadFile;
        this.productRepository = productRepository;
    }
  
    //metodos
    public Iterable<ProductEntity> getProducts(){
        return  productRepository.getProducts();
    }
    public Iterable<ProductEntity> getProductsByUser(UserEntity user){
        return  productRepository.getProductByUser(user);
    }
    public ProductEntity getProductById(Integer id){
        return  productRepository.getProductById(id);
    }
    public ProductEntity saveProduct(ProductEntity productEntity, MultipartFile multipartFile) throws IOException{
        if (productEntity.getId()==null) {
           UserEntity user =new UserEntity();
           user.setId(1);
           productEntity.setDateCreated(LocalDateTime.now());
           productEntity.setDateUpdated(LocalDateTime.now());
           productEntity.setUserEntity(user);
           productEntity.setImage(uploadFile.upload(multipartFile));
           return productRepository.saveProduct(productEntity);
        }
        else{ 
        ProductEntity productDB =productRepository.getProductById(productEntity.getId());
            if (multipartFile.isEmpty()) {
                productEntity.setImage(productDB.getImage());
            } else {
                if (!productDB.getImage().equals("default.jpg")) {
                    uploadFile.delete(productDB.getImage());                     
                }
       productEntity.setImage(uploadFile.upload(multipartFile));
            }
        productEntity.setCode(productDB.getCode());
        productEntity.setDateCreated(productDB.getDateCreated());
        productEntity.setDateUpdated(LocalDateTime.now());
        return productRepository.saveProduct(productEntity);
    }
    
    }
    public boolean deleteProductById(Integer id){
        return productRepository.deleteProductById(id);
  
    }
}
