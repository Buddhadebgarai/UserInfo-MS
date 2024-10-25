package com.foody.userinfo.controller;

import com.foody.userinfo.dto.UserDTO;
import com.foody.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO)
    {
        UserDTO addedUserDTO = userService.addUser(userDTO);
        return new ResponseEntity<>(addedUserDTO, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{id}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable Integer id)
    {
        return userService.fetchUserById(id);
    }

}
