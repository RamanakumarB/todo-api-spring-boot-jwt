package dev.code.io.HelloWorld.Service;

import dev.code.io.HelloWorld.models.User;
import dev.code.io.HelloWorld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    //Autowire
    @Autowired
    private UserRepository userRepository;

    //Create
    public User createUser(User user){
        return userRepository.save(user);
    }

    //Read
    public User getUserById(Integer id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

}
