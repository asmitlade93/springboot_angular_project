package com.nitor.demo.service.impl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.nitor.demo.dto.UsersDTO;
// import com.nitor.demo.mapper.UserMapper;
import com.nitor.demo.model.Users;
import com.nitor.demo.repository.UserRepository;
import com.nitor.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    // private final UserMapper userMapper;

    AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        // this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public void registerNewUser(UsersDTO userDTO) {
        Users user = new Users();
        user.setUsername(userDTO.userName());
        user.setContactNo(userDTO.contactNo());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        
        Optional<Users> existingUserName = userRepository.findByUserName(userDTO.userName());
        existingUserName.ifPresent(u -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Already Exist. Please Login.");
        });

        Optional<Users> existingUserEmail = userRepository.findByEmail(userDTO.email());
        existingUserEmail.ifPresent(u -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email id Already Exist. Please Login.");
        });
        userRepository.save(user);
    }

}
