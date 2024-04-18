package com.onlineExamination.userService.service;

import com.onlineExamination.userService.model.UserModel;
import com.onlineExamination.userService.repository.UserRepository;
import com.onlineExamination.userService.util.JwtUtil;
import com.onlineExamination.userService.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel registerUser(UserModel user) {
        String password = user.getPassword();
        String hashedPassword = PasswordUtil.hashPassword(password);
        System.out.println("hashedPassowrd:" + hashedPassword);
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public UserModel loginUser(String username, String password, HttpServletResponse response) {
        Optional<UserModel> loggingUser = userRepository.findByUsername(username);
        System.out.println(loggingUser);
        if (loggingUser.isPresent()) {
            UserModel user = loggingUser.get();
            String storedPassword = user.getPassword();
            System.out.println("hi token");
            if (PasswordUtil.checkPassword(password, storedPassword)) {
                String token = JwtUtil.generateJwtToken(user);
                JwtUtil.setJwtTokenInCookie(response, token);
                return user;
            }
        }
        return null;
    }
}