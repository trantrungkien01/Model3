package com.ra.controller.auth;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.JwtResponse;

import com.ra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> handleLogin(@RequestBody UserLogin userLogin) {
        return new ResponseEntity<>(iUserService.handleLogin(userLogin), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> handleRegister(@RequestBody UserRegister userRegister) {
        return new ResponseEntity<>(iUserService.handleRegister(userRegister), HttpStatus.CREATED);
    }
}