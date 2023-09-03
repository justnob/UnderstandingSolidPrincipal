package com.amarnath.bankingapp.Validations;

import com.amarnath.bankingapp.CustomeResponse.ApiResponse;
import com.amarnath.bankingapp.DTO.UserDTO;
import com.amarnath.bankingapp.Entity.Users;
import com.amarnath.bankingapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserUpdateRequestValidation {

    private final UserRepository userRepository;

    public ResponseEntity<Object> validate(long id, UserDTO userDTO){

        Optional<Users> userById = userRepository.findById(id);

        if (userById.isEmpty()){

            return ApiResponse.generateResponse(
                    "User does not exist !",
                    HttpStatus.NOT_FOUND,
                    id
            );

        }

        if (userDTO.getUserName() == null){

            return ApiResponse.generateResponse(
                    "Username must not be blank !",
                    HttpStatus.BAD_REQUEST,
                    userDTO
            );

        }

        if (userDTO.getUserName().isEmpty()){

            return ApiResponse.generateResponse(
                    "Username must not be empty !",
                    HttpStatus.BAD_REQUEST,
                    userDTO
            );

        }

        if (userDTO.getPassword() == null){

            return ApiResponse.generateResponse(
                    "Password must not be blank !",
                    HttpStatus.BAD_REQUEST,
                    userDTO
            );

        }

        if (userDTO.getPassword().isEmpty()){

            return ApiResponse.generateResponse(
                    "Password must not be empty !",
                    HttpStatus.BAD_REQUEST,
                    userDTO
            );

        }

        return ApiResponse.generateResponse(
                "",
                HttpStatus.OK,
                id
        );

    }

}
