package com.example.demo.controller;



import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Stock;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserRepository userRepo;
    public User createUser(User user){
        return userRepo.save(user);
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @GetMapping("/user/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userid){

        User user=userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("User not exists with id: "+userid));
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{userid}")
    public ResponseEntity<Map<String,Boolean>>deleteUser(@PathVariable Integer userid){
        User user=userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("Stock not exists with id: "+userid));
        userRepo.delete(user);
        Map<String,Boolean>response=new HashMap<>();
        response.put("deleted!",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



//    public User fetchUserByEmailId(String email){
//        return repo.findByEmailId(email);
//    }
//
//    public User fetchUserByEmailIdAndPassword (String email, String password){
//        return repo.findByEmailIdAndPassword(email, password);
   // }
}
