package com.ginfin.test.jwt;

import lombok.Data;

@Data
public class AuthRequest {
    String login;
    String password;

}
