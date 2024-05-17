package com.amalitechRMS.repository;


import com.amalitechRMS.model.AuthenticationToken;
import com.amalitechRMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}