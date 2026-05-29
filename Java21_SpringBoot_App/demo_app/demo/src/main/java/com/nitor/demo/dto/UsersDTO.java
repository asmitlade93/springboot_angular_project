package com.nitor.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record UsersDTO(Long userId, @NotNull String userName, @NotNull String password, 
    @Email String email, @Min(10) String contactNo, String status) {

}
