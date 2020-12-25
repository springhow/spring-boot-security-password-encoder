package com.springhow.examples.springboot.security.passwordencoder.controllers;

import com.springhow.examples.springboot.security.passwordencoder.domain.entities.UserAccount;
import com.springhow.examples.springboot.security.passwordencoder.domain.repositories.UserAccountRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {

    private UserAccountRepository userAccountRepository;

    public HelloController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @RequestMapping("/hello")
    public String hello(Principal principal) {
        UserAccount userAccount = userAccountRepository.findByUsername(principal.getName());
        return "Hello <b>" + userAccount.getFirstName() + " " + userAccount.getLastName() + "</b> !";
    }
}
