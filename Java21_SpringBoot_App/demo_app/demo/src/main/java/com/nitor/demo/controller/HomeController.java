// package com.nitor.demo.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.nitor.demo.dto.UsersResponse;
// import com.nitor.demo.service.HomeService;

// import jakarta.validation.constraints.Min;
// import lombok.extern.slf4j.Slf4j;


// @RestController
// @RequestMapping("/home")
// @Slf4j
// @Validated
// public class HomeController {

//     private final HomeService homeService;

//     HomeController(HomeService homeService) {
//         this.homeService = homeService;
//     }

//     @GetMapping("/healthcheck")
//     public String healthCheck() {
//         return "OK...Application Running..!!!";
//     }


//     @GetMapping("/get-user-by-id")
//     public ResponseEntity<UsersResponse> getUserDetailsById(@RequestParam(value = "userId") @Min(1) Long userId) {
//         UsersResponse response = homeService.getUsersDetailsById(userId);
//         return ResponseEntity.ok(response);
//     }
    
//     @GetMapping("/getallusers")
//     public ResponseEntity<List<UsersResponse>> getUserAllUsers() {
//         List<UsersResponse> response = homeService.getUsersLists();
//         return ResponseEntity.ok(response);
//     }

// }
