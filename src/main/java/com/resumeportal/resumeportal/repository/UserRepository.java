package com.resumeportal.resumeportal.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.resumeportal.resumeportal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Allows an interface to interact with the repo to get the data
*/
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    
    Optional<User> findByUserName(String username);
}
