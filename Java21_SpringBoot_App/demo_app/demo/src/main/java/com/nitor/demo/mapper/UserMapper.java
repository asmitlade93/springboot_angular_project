// package com.nitor.demo.mapper;

// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

// import com.nitor.demo.dto.UsersDTO;
// import com.nitor.demo.model.Users;

// @Mapper(componentModel = "spring")
// public interface UserMapper {

//     @Mapping(source = "userName", target = "username")
//     @Mapping(target = "createdDate", ignore = true)
//     @Mapping(target = "modifiedDate", ignore = true)
//     Users toEntity(UsersDTO userDTO);

//     // @Mapping(source = "username", target = "userName")
//     UsersDTO toDTO(Users user);
// }
