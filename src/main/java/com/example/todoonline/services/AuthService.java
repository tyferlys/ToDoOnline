package com.example.todoonline.services;

import com.example.todoonline.models.User;
import com.example.todoonline.repositories.UserRepository;
import com.example.todoonline.requests.AuthRequest;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        Argon2 argon = Argon2Factory.create();
        user.setPassword(argon.hash(12, 10240, 1, user.getPassword()));
        return userRepository.save(user);
    }

    public String checkAuth(AuthRequest authRequest){
        User user = userRepository.findUserByUsernameAndPassword(authRequest.getUsername(), authRequest.getPassword()).get();
        Argon2 argon = Argon2Factory.create();
        String authCode = argon.hash(12, 10240, 1, user.getUsername() + String.valueOf(System.currentTimeMillis()));
        user.setAuthCode(authCode);
        userRepository.save(user);
        return authCode;
    }
}
