package com.springhow.examples.springboot.security.passwordencoder.security;

import com.springhow.examples.springboot.security.passwordencoder.domain.entities.UserAccount;
import com.springhow.examples.springboot.security.passwordencoder.domain.repositories.UserAccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUserDetailsService implements UserDetailsService {
    private final
    UserAccountRepository userAccountRepository;

    public DatabaseUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByUsername(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found in the system");
        }
        return new CustomUserDetails(userAccount);
    }
}
