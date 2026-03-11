package com.authentication.simple_authetication.service;

import com.authentication.simple_authetication.model.entity.Users;
import com.authentication.simple_authetication.model.projection.UserView;
import com.authentication.simple_authetication.model.request.UserLoginRequest;
import com.authentication.simple_authetication.model.response.UserLoginResponse;
import com.authentication.simple_authetication.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UsersRepository usersRepository;
    private final JwtService jwtService;

    public UserLoginResponse execute(UserLoginRequest input) {
        log.info("Login request : {}", input.getUsername());
        Optional<Users> userLogin = usersRepository.findByUsername(input.getUsername());
        if (userLogin.isPresent()) {
            UserView user = usersRepository.getUserDataByUsernameAndPassword(input.getUsername(), input.getPassword());
            if (ObjectUtils.isEmpty(user)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
            }
            String token = jwtService.generateToken(user);
            return UserLoginResponse.builder()
                    .username(user.getUsername())
                    .roleName(user.getRoleName())
                    .token(token)
                    .build();
        }
        log.info("End Of Login");
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
    }
}
