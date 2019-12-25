package com.ppmtool.services;

import com.ppmtool.domain.User;
import com.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser){
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

        //username has to be unique

            //password and confirmPassword must match
        return userRepository.save(newUser);
    }
}
