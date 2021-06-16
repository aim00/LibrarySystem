package com.example.library.security;

import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {
    Account findByUsername(String username);
}
