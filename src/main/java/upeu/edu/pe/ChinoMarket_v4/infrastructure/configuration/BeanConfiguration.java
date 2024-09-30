
package upeu.edu.pe.ChinoMarket_v4.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.ChinoMarket_v4.app.repository.ProductRepository;
import upeu.edu.pe.ChinoMarket_v4.app.repository.UserRepository;
import upeu.edu.pe.ChinoMarket_v4.app.service.ProductService;
import upeu.edu.pe.ChinoMarket_v4.app.service.UploadFile;
import upeu.edu.pe.ChinoMarket_v4.app.service.UserService;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
    @Bean
    public ProductService productService(UploadFile uploadFile,ProductRepository productRepository){
        return new ProductService(uploadFile,productRepository);
    }
     @Bean
      public UploadFile uploadFile(){
        return new UploadFile();
    }
}
