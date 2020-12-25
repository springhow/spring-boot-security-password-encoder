package com.springhow.examples.springboot.security.passwordencoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootSecurityPasswordEncoderDemoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityPasswordEncoderDemoServiceApplication.class, args);
    }


//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("MD5", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
        return new DelegatingPasswordEncoder("bcrypt", encoders);
    }

}
