package com.amarnath.bankingapp.Validations;

import com.amarnath.bankingapp.CustomeResponse.ApiResponse;
import com.amarnath.bankingapp.Entity.Users;
import com.amarnath.bankingapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGetAllRequestValidation {

    private final UserRepository userRepository;

    public ResponseEntity<Object> validate(){

        List<Users> allUsers = userRepository.findAll();

        if (allUsers.isEmpty()){

            return ApiResponse.generateResponse(
                    "No users in repository !",
                    HttpStatus.NO_CONTENT,
                    null
            );

        }

        return ApiResponse.generateResponse(
                "",
                HttpStatus.OK,
                null
        );

    }

}
