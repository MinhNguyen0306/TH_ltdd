package com.example.KTCK_Lan3_THLTDD.Services;

import com.example.KTCK_Lan3_THLTDD.Entities.User;

import java.util.List;

public interface UserService {

    List<String> checkUserEmail(String email);

    String checkPasswordByEmail(String email);

    User getUserDetailsByEmail(String email);
}
