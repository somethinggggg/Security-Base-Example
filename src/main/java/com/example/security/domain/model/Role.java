package com.example.security.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Role {

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_MOD = "ROLE_MOD";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    private String authority;

}
