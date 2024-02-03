package com.example.springsecurity.controller;

import com.example.springsecurity.domain.User;
import com.example.springsecurity.dto.request.UserRequestDto;
import com.example.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // view를 리턴한다는 의미의 annotation
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"", "/"})
    public @ResponseBody String index() {
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody String user() {
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    // 해당 메서드는 SecurityConfig 파일을 하면 동작.
    @GetMapping("/loginForm") // 로그인
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(UserRequestDto userRequestDto) {
        System.out.println(userRequestDto);
        userRequestDto.setPassword(bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
        User saved = userRepository.save(userRequestDto.toEntity());
        return "redirect:/loginForm";
    }

}
