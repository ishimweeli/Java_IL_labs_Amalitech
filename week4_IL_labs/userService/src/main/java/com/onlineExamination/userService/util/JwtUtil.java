package com.onlineExamination.userService.util;

import com.onlineExamination.userService.model.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "your_secret_key";
    private static final long TOKEN_EXPIRATION_TIME = 3600000; // 1 hour

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String generateJwtToken(UserModel user) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + TOKEN_EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static void setJwtTokenInCookie(HttpServletResponse response, String token) {
        System.out.println(token+"hi token");
        Cookie cookie = new Cookie("jwt_token", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge((int) TOKEN_EXPIRATION_TIME / 1000); // Token expiration time (in seconds)
        response.addCookie(cookie);

    }


}