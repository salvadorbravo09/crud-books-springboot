package com.salvadorbravo.crudbooks.services;

import com.salvadorbravo.crudbooks.model.UserInfo;
import com.salvadorbravo.crudbooks.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByUsername(username);

        return User.builder()
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .roles(userInfo.getRole())
                .build();
    }
}
