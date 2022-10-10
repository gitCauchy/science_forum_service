package com.science.service;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationServiceImpl {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String password = passwordEncoder.encode("password");
        System.out.println(password);
        boolean password1 = passwordEncoder.matches("password", "{bcrypt}$2a$10$ScB1YX5GAWoP.nerkIvNReW/1imJMGkfy0.PiWmqQQqK3HjRl2H76");
        System.out.println(password1);

    }
}
