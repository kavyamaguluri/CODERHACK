package com.crio.coderhack.exchanges;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String username;
    private String userId;
}