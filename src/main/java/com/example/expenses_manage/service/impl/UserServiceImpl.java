package com.example.expenses_manage.service.impl;

import com.example.expenses_manage.database.entity.User;
import com.example.expenses_manage.database.repository.UserRepository;
import com.example.expenses_manage.model.UserLoginDto;
import com.example.expenses_manage.model.UserRegisterDto;
import com.example.expenses_manage.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRegisterDto userRegisterDto) {
        User newUser = new User();
        newUser.setFullName(userRegisterDto.getFullName());
        newUser.setUsername(userRegisterDto.getUsername());
        newUser.setEmail(userRegisterDto.getEmail());

        // Encode the password before saving it
        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        newUser.setDob(userRegisterDto.getDob());
        newUser.setTotal(userRegisterDto.getTotal());
        newUser.setCreatedAt(LocalDateTime.now());
        userRepository.save(newUser);
    }

    @Override
    public List<String> validateRegister(UserRegisterDto userRegisterDto) {
        List<String> errors = new ArrayList<>();
        if (userRepository.existsByEmail(userRegisterDto.getEmail())) {
            errors.add("Email already exists");
        }
        if (userRepository.existsByUsername(userRegisterDto.getUsername())) {
            errors.add("Username already exists");
        }
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            errors.add("Passwords do not match");
        }
        return errors;
    }

    @Override
    public String login(UserLoginDto userLoginDto, HttpSession session) {
        Optional<User> userOptional = userRepository.findByEmail(userLoginDto.getEmail());
        if (userOptional.isEmpty()) {
            return "Email is incorrect";
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
            return "Password is incorrect";
        }

        session.setAttribute("user", user);
        return "Login successful";
    }
}
