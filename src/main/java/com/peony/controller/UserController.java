package com.peony.controller;

import com.peony.database.UsersRepository;
import com.peony.model.Users;
import com.peony.util.ResponseConstant;
import com.peony.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UsersRepository usersRepository;

    public ResponseEntity<ResponseWrapper> signIn(String username, String password){
        Users user = usersRepository.findByUsernameAndPassword(username, password);
        ResponseWrapper responseWrapper = new ResponseWrapper();
        if(user != null){
            responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
            responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
            responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
        }else{
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseStatus(ResponseConstant.FAIL);
            responseWrapper.setResponseDesc("Incorrect username or password");
        }
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }

    public ResponseEntity<ResponseWrapper> signUp(String username, String password, String confirmPassword, String firstName, String lastName, String email){
        Users user = usersRepository.findByUsername(username);
        ResponseWrapper responseWrapper = new ResponseWrapper();
        if(user == null){
            if(password.equals(confirmPassword)){
                usersRepository.save(new Users(username, password, firstName, lastName, email));
                responseWrapper.setResponseCode(ResponseConstant.SUCCESS_CODE);
                responseWrapper.setResponseStatus(ResponseConstant.SUCCESS);
                responseWrapper.setResponseDesc(ResponseConstant.SUCCESS);
            }else {
                responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
                responseWrapper.setResponseStatus(ResponseConstant.FAIL);
                responseWrapper.setResponseDesc("Confirmed password is incorrect");
            }
        }else {
            responseWrapper.setResponseCode(ResponseConstant.FAIL_CODE);
            responseWrapper.setResponseStatus(ResponseConstant.FAIL);
            responseWrapper.setResponseDesc("This username has been taken");
        }
        ResponseEntity<ResponseWrapper> response = new ResponseEntity<>(responseWrapper, HttpStatus.OK);
        return response;
    }
}
