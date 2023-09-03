package com.amarnath.bankingapp.Validations;

import com.amarnath.bankingapp.CustomeResponse.ApiResponse;
import com.amarnath.bankingapp.DTO.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserCreationRequestValidation {


    public ResponseEntity<Object> validate(UserDTO userDTO){

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
                    userDTO
            );

    }

}
