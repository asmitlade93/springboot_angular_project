// package com.nitor.demo.service;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.stereotype.Service;

// import com.nitor.demo.dto.UsersResponse;
// import com.nitor.demo.repository.UserRepository;

// import lombok.extern.slf4j.Slf4j;

// @Service
// @Slf4j
// public class HomeService {

//     private final UserRepository userRepository;

//     HomeService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     public UsersResponse getUsersDetailsById(Long userId) {
//         log.info("User id {} :", userId);
//         return userRepository.findById(userId)
//                 .map(user -> {
//                     log.info("User details :: {}", user);
//                     return new UsersResponse(user.getUserId(), user.getUsername(), user.getPassword(),
//                             user.getIsActive());
//                 })
//                 .orElseThrow(() -> {
//                     log.error("UserId {} not found.", userId);
//                     return new RuntimeException("UserId Not Found");
//                 });

//     }

//     public List<UsersResponse> getUsersLists() {
//         return userRepository.findAll().stream().map(
//                 user -> new UsersResponse(user.getUserId(), user.getUsername(), user.getPassword(), user.getIsActive()))
//                 .collect(Collectors.toList());
//     }

// }
