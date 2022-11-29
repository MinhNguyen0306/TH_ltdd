package com.example.KTCK_Lan3_THLTDD.Services.Impl;

import com.example.KTCK_Lan3_THLTDD.Entities.User;
import com.example.KTCK_Lan3_THLTDD.Repositories.UserRepository;
import com.example.KTCK_Lan3_THLTDD.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<String> checkUserEmail(String email) {
        return this.userRepository.checkUserByEmail(email);
    }

    @Override
    public String checkPasswordByEmail(String email) {
        return this.userRepository.checkUserPasswordByEmail(email);
    }

    @Override
    public User getUserDetailsByEmail(String email) {
        return this.userRepository.getUserByEmail(email);
    }
}
