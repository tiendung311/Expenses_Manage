package com.example.expenses_manage.controller;

import com.example.expenses_manage.model.UserRegisterDto;
import com.example.expenses_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDto userRegisterDto) {
        List<String> errors = userService.validateRegister(userRegisterDto);
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }
        userService.register(userRegisterDto);
        return ResponseEntity.ok("User registered successfully");
    }
}
