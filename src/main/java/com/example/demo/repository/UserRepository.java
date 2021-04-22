package com.example.demo.repository;


import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    public User findByEmailId(String emailId);
//    public User findByEmailIdAndPassword(String emailI, String password);
}
