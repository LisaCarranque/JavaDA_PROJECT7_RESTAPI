package com.nnk.springboot.config;

import lombok.*;

/**
 * This class is used to return user token, username, and role
 * after authentication with username and password
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private String token;
    private String username;
    private String role;

}
