//package com.example.cms.service;
//
//import com.example.cms.constants.MessageCode;
//import com.example.cms.dto.ApiResponse;
//import com.example.cms.dto.AuthorizationTokenDTO;
//import com.example.cms.dto.UserDTO;
//import com.example.cms.entity.Role;
//import com.example.cms.entity.User;
//import com.example.cms.enums.Roles;
//import com.example.cms.repository.UserRepository;
//import com.example.cms.security.JwtTokenProvider;
//import com.example.cms.utils.ResponseHandler;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @Mock
//    private RoleService roleService;
//
//    @Mock
//    private AuthenticationManager authenticationManager;
//
//    @Mock
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Mock
//    private ResponseHandler responseHandler;
//
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    void signUpUser_WhenUserNameExists_ShouldReturnUserAlreadyExistsResponse() {
//        // Arrange
//        String userName = "testuser";
//        UserDTO userDTO = new UserDTO();
//        when(userRepository.existsByUserName(userName)).thenReturn(true);
//        ApiResponse expectedResponse = new ApiResponse(MessageCode.USER_ALREADY_EXIST.getMessage(), HttpStatus.BAD_REQUEST);
//        when(responseHandler.generateResponse("", MessageCode.USER_ALREADY_EXIST, HttpStatus.BAD_REQUEST)).thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.BAD_REQUEST));
//
//        // Act
//        ResponseEntity<ApiResponse> result = userService.signUpUser(userDTO);
//
//        // Assert
//        verify(userRepository, times(1)).existsByUserName(userName);
//        verifyNoMoreInteractions(userRepository, passwordEncoder, roleService);
//        assertEquals(expectedResponse, result.getBody());
//    }
//
//    @Test
//    void signUpUser_WhenUserNameDoesNotExist_ShouldSignUpUserSuccessfully() {
//        // Arrange
//        String userName = "testuser";
//        String password = "password";
//        UserDTO userDTO = new UserDTO();
//        when(userRepository.existsByUserName(userName)).thenReturn(false);
//        when(passwordEncoder.encode(password)).thenReturn("encodedPassword");
//        Role userRole = new Role(Roles.USER);
//        when(roleService.findRole(Roles.USER)).thenReturn(userRole);
//        ApiResponse expectedResponse = new ApiResponse(MessageCode.SIGN_UP_SUCCESSFULLY.getMessage(), HttpStatus.OK);
//        when(responseHandler.generateResponse("", MessageCode.SIGN_UP_SUCCESSFULLY, HttpStatus.OK)).thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
//
//        // Act
//        ResponseEntity<ApiResponse> result = userService.signUpUser(userDTO);
//
//        // Assert
//        verify(userRepository, times(1)).existsByUserName(userName);
//        verify(passwordEncoder, times(1)).encode(password);
//        verify(roleService, times(1)).findRole(Roles.USER);
//        verify(userRepository, times(1)).save(any(User.class));
//        verifyNoMoreInteractions(userRepository, passwordEncoder, roleService);
//        assertEquals(expectedResponse, result.getBody());
//    }
//
//    @Test
//    void signInUser_WhenCredentialsAreValid_ShouldSignInUserSuccessfully() {
//        // Arrange
//        String userName = "testuser";
//        String password = "password";
//        UserDTO userDTO = new UserDTO();
//        String token = "generatedToken";
//        when(jwtTokenProvider.createAuthToken(userName)).thenReturn(token);
//        AuthorizationTokenDTO expectedAuthDTO = new AuthorizationTokenDTO(userName, token);
//        ApiResponse expectedResponse = new ApiResponse(expectedAuthDTO, MessageCode.SIGN_IN_SUCCESSFULLY.getMessage(), HttpStatus.OK);
//        when(responseHandler.generateResponse(expectedAuthDTO, MessageCode.SIGN_IN_SUCCESSFULLY, HttpStatus.OK)).thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
//
//        // Act
//        ResponseEntity<ApiResponse> result = userService.signInUser(userDTO);
//
//        // Assert
//        verify(authenticationManager, times(1)).authenticate(new UsernamePasswordAuthenticationToken(userName, password));
//        verify(jwtTokenProvider, times(1)).createAuthToken(userName);
//        verifyNoMoreInteractions(authenticationManager, jwtTokenProvider);
//        assertEquals(expectedResponse, result.getBody());
//    }
//
//    @Test
//    void signInUser_WhenCredentialsAreInvalid_ShouldReturnInvalidCredentialsResponse() {
//        // Arrange
//        String userName = "testuser";
//        String password = "wrongPassword";
//        UserDTO userDTO = new UserDTO();
//        when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password))).thenThrow(new RuntimeException());
//        ApiResponse expectedResponse = new ApiResponse(MessageCode.USERNAME_PAASWORD_INCORRECT.getMessage(), HttpStatus.BAD_REQUEST);
//        when(responseHandler.generateResponse("", MessageCode.USERNAME_PAASWORD_INCORRECT, HttpStatus.BAD_REQUEST)).thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.BAD_REQUEST));
//
//        // Act
//        ResponseEntity<ApiResponse> result = userService.signInUser(userDTO);
//
//        // Assert
//        verify(authenticationManager, times(1)).authenticate(new UsernamePasswordAuthenticationToken(userName, password));
//        verifyNoMoreInteractions(authenticationManager, jwtTokenProvider);
//        assertEquals(expectedResponse, result.getBody());
//    }
//
//    @Test
//    void checkUserNameExist_WhenUserNameExists_ShouldReturnTrue() {
//        // Arrange
//        String userName = "testuser";
//        when(userRepository.existsByUserName(userName)).thenReturn(true);
//
//        // Act
//        boolean result = userService.checkUserNameExist(userName);
//
//        // Assert
//        verify(userRepository, times(1)).existsByUserName(userName);
//        verifyNoMoreInteractions(userRepository);
//        assertTrue(result);
//    }
//
//    @Test
//    void checkUserNameExist_WhenUserNameDoesNotExist_ShouldReturnFalse() {
//        // Arrange
//        String userName = "testuser";
//        when(userRepository.existsByUserName(userName)).thenReturn(false);
//
//        // Act
//        boolean result = userService.checkUserNameExist(userName);
//
//        // Assert
//        verify(userRepository, times(1)).existsByUserName(userName);
//        verifyNoMoreInteractions(userRepository);
//        assertFalse(result);
//    }
//}