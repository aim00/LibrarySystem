package com.example.library.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountRepository repository;
    
    @Autowired
    public UserDetailsServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        if(username.isEmpty()) {
            throw new UsernameNotFoundException("Username is empty");
        }
        
        Account account = repository.findByUsername(username);
        
        if(account == null) {
            throw new UsernameNotFoundException("Not found username : " + username);
        }
        
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getRole()));
        
        User user = new User(account.getUsername(), account.getPassword(), authorities);
        return user;
    }

}
