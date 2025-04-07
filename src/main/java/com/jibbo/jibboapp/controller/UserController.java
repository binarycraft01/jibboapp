package com.jibbo.jibboapp.controller;

import com.jibbo.jibboapp.domain.User;
import com.jibbo.jibboapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired  // 생성자 주입
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 전체 조회
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // 사용자 등록
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
