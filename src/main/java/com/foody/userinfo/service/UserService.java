package com.foody.userinfo.service;

import com.foody.userinfo.dto.UserDTO;
import com.foody.userinfo.entity.User;
import com.foody.userinfo.mapper.UserMapper;
import com.foody.userinfo.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public UserDTO addUser(UserDTO userDTO) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);

    }

    public ResponseEntity<UserDTO> fetchUserById(Integer id) {

        Optional<User> fetchedUser = userRepo.findById(id);
        return fetchedUser.map(user -> new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user), HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
