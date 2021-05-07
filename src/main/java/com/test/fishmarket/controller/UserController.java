package com.test.fishmarket.controller;

import com.test.fishmarket.dto.User;
import com.test.fishmarket.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // 결과값을 JSON으로 출력합니다.
@RequestMapping(value = "/v1")
public class UserController {
    private final UserJpaRepo userJpaRepo;

    @GetMapping(value = "/user")
    public List<User> findAllUser() {
        return userJpaRepo.findAll();
    }

    @PostMapping(value = "/user")
    public User save() {
        User user = User.builder()
                .msrl("aflkjaskf")
                .uid("test@naer.com")
                .name("테스")
                .build();
        return userJpaRepo.save(user);
    }
}