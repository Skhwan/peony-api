package com.peony.service;

import com.peony.controller.UserController;
import com.peony.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserService {

    @Autowired
    UserController userController;

    @PostMapping("/signin")
    public ResponseEntity<ResponseWrapper> signIn(@RequestBody Map<String, String> body){
        String username = body.get("username");
        String password = body.get("password");
        return userController.signIn(username, password);
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseWrapper> signUp(@RequestBody Map<String, String> body){
        String username = body.get("username");
        String password = body.get("password");
        String confirmedPassword = body.get("confirmedPassword");
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String email = body.get("email");
        return userController.signUp(username, password, confirmedPassword, firstName, lastName, email);
    }
}
