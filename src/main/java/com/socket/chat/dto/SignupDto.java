package com.socket.chat.dto;

import com.socket.chat.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupDto {
    private String email;
    private String name;
    private String password;

    public Member toEntity(String password){
        return Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();
    }
}
