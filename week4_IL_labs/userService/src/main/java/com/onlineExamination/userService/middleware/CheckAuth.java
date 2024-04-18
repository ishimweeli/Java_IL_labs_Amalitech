package com.onlineExamination.userService.middleware;

import com.onlineExamination.userService.model.UserModel;
import com.onlineExamination.userService.service.UserService;
import com.onlineExamination.userService.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class CheckAuth implements HandlerInterceptor {
    @Autowired
    private UserService userService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // Check if the request is for the login or registration endpoint
//        if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/register")) {
//            return true;
//        }
//
//        // Check if the JWT token is present in the request
//        String token = getTokenFromCookie(request);
//        if (token == null) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//
//        // Verify the JWT token
//        Optional<UserModel> userOptional = userService.getUserByToken(token);
//        if (userOptional.isPresent() && JwtUtil.isTokenValid(token, userOptional.get())) {
//            request.setAttribute("user", userOptional.get());
//            return true;
//        } else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//    }

    private String getTokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwt_token")) {
                    String token=cookie.getValue();
                    return token;
                }
            }
        }
        return null;
    }
}