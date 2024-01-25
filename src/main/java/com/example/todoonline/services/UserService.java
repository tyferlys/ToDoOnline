package com.example.todoonline.services;

import com.example.todoonline.models.User;
import com.example.todoonline.repositories.UserRepository;
import com.example.todoonline.requests.AuthRequest;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Integer idUser){
        return userRepository.findById(idUser).get();
    }
    public User updateUser(User user){
        if (userRepository.existsById(user.getId()))
            return userRepository.save(user);
        else
            throw new RuntimeException("ID not found");
    }
    public void deleteUser(Integer idUser){
        if (userRepository.existsById(idUser))
            userRepository.deleteById(idUser);
        else
            throw new RuntimeException("ID not found");
    }
}
