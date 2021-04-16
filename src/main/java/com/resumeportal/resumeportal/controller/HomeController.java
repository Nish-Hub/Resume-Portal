package com.resumeportal.resumeportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
   /*  @Autowired
    UserDetailsService userDetailsService; */

    @GetMapping("/")
    public String home(){

        //TODO: Need to use the password also

        //Spring security invokes UserDetailsService internally hence no need to call it 
        // explicitly
        //return userDetailsService.loadUserByUsername(username).getUsername();
        return "Hello there !";
    }

    @GetMapping("/edit")
    public String edit(String username,String password){

        return "Edit Page";
    }

}
