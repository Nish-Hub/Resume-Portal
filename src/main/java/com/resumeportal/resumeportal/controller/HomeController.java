package com.resumeportal.resumeportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
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

    /*
    userId is the path variable ex: /view/foo
    */
    @GetMapping("/view/{userId}")
    public String view(@PathVariable("userId") String userId,Model model){
    	
    	model.addAttribute("userId",userId);
        return "profile";
    }
}
