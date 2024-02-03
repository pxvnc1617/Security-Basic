package com.example.springsecurity.dto.request;

import com.example.springsecurity.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private String role;
    private Timestamp createdAt;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .role(role)
                .createdAt(createdAt)
                .build();
    }
}
