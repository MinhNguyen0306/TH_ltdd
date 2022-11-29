package com.example.KTCK_Lan3_THLTDD.Controllers;

import com.example.KTCK_Lan3_THLTDD.Entities.User;
import com.example.KTCK_Lan3_THLTDD.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity authenticateUser(@RequestBody User user) {
        //Get User Email
        List<String> userEmail = this.userService.checkUserEmail(user.getEmail());
        if(userEmail.isEmpty() || userEmail == null) {
            return new ResponseEntity<>("Email does not exits", HttpStatus.BAD_REQUEST);
        }

        //Get User Password
        String userPassword = this.userService.checkPasswordByEmail(user.getEmail());
        if(!user.getPassword().equalsIgnoreCase(userPassword)) {
            return new ResponseEntity<>("Incorrect Username Or Password", HttpStatus.BAD_REQUEST);
        }

        User detailUser = this.userService.getUserDetailsByEmail(user.getEmail());
        return new ResponseEntity<>(detailUser, HttpStatus.OK);
    }
}
