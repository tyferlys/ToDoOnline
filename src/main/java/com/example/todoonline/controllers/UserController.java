package com.example.todoonline.controllers;

import com.example.todoonline.models.User;
import com.example.todoonline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET запросы-----------------------------------------------------------
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable Integer idUser){
        return ResponseEntity.ok().body(userService.getUserById(idUser));
    }
    //PUT запросы-----------------------------------------------------------
    @PutMapping("")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.updateUser(user));
    }
    //DELETE запросы-----------------------------------------------------------
    @DeleteMapping("/{idUser}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer idUser){
        userService.deleteUser(idUser);
        return ResponseEntity.ok().build();
    }
}
