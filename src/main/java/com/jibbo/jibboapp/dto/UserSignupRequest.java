package com.jibbo.jibboapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequest {
    private String email;
    private String password;
    private String nickname;
}
