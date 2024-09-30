
package upeu.edu.pe.ChinoMarket_v4.app.service;

import upeu.edu.pe.ChinoMarket_v4.app.repository.UserRepository;
import upeu.edu.pe.ChinoMarket_v4.infrastructure.entity.UserEntity;

public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity createdUser(UserEntity userEntity){
        return  userRepository.created(userEntity);
    }
    public UserEntity findByEmail(String email){
        return  userRepository.findByEmail(email);
    }
    public UserEntity findById(Integer id){
        return  userRepository.finById(id);
    }
 
}
