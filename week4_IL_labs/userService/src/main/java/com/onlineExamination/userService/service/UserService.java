package com.onlineExamination.userService.service;


import com.onlineExamination.userService.model.UserModel;
import com.onlineExamination.userService.util.JwtUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public interface UserService {
    UserModel registerUser(UserModel user);
    UserModel loginUser(String username, String password, HttpServletResponse response);

}
