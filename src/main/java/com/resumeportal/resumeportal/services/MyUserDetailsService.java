package com.resumeportal.resumeportal.services;

import java.util.Optional;

import com.resumeportal.resumeportal.models.MyUserDetails;
import com.resumeportal.resumeportal.models.User;
import com.resumeportal.resumeportal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/* 
Here implementing userdetailsservice is actualy telling spring security 
how to load the user by username and give back Spring security's UserDetails
*/
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + username));

        /*
         * User is mapped to a UserDetails class which spring security understands
         */
        return user.map(MyUserDetails::new).get();

    }

}
