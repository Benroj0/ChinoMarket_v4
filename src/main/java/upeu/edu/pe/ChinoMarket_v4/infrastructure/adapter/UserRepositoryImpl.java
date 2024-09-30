
package upeu.edu.pe.ChinoMarket_v4.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.ChinoMarket_v4.app.repository.UserRepository;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.UserEntity;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private UserCrudRepository userCrudRepository;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public UserEntity created(UserEntity userEntity) {
       return  userCrudRepository.save(userEntity); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserEntity findByEmail(String email) {
       return userCrudRepository.findByEmail(email).get(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserEntity finById(Integer id) {
        return userCrudRepository.findById(id).get(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
