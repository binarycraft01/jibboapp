package com.jibbo.jibboapp.controller;

import com.jibbo.jibboapp.domain.User;
import com.jibbo.jibboapp.dto.UserSignupRequest;
import com.jibbo.jibboapp.service.UserService;
import com.jibbo.jibboapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    // ✅ 전체 유저 조회
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // ✅ 기존 유저 등록 (비추천, 테스트용)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // ✅ 회원가입 API (비밀번호 암호화 포함)
    @PostMapping("/signup")
    public User signup(@RequestBody UserSignupRequest request) {
        return userService.signup(request);
    }
}
