package com.example.expenses_manage.service;

import com.example.expenses_manage.model.UserRegisterDto;

import java.util.List;

public interface UserService {
    void register(UserRegisterDto userRegisterDto);

    List<String> validateRegister(UserRegisterDto userRegisterDto);
}
