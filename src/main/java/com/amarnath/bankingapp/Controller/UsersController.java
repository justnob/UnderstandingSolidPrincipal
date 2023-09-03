package com.amarnath.bankingapp.Controller;

import com.amarnath.bankingapp.DTO.UserDTO;
import com.amarnath.bankingapp.Service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    private Object createUser(@RequestBody UserDTO userDTO){

        return userService.createUser(userDTO);

    }

    @PutMapping("/api/v1/user/{id}")
    private Object updateUser(@PathVariable long id, @RequestBody UserDTO userDTO){

        return userService.updateUser(id, userDTO);

    }

    @DeleteMapping("/api/v1/user/{id}")
    private Object updateUser(@PathVariable long id){

        return userService.deleteUser(id);

    }

    @GetMapping("/api/v1/users")
    private ResponseEntity<Object> getAllUsers(){

        return userService.getAllUsers();

    }

}
