package com.amarnath.bankingapp.Validations;

import com.amarnath.bankingapp.CustomeResponse.ApiResponse;
import com.amarnath.bankingapp.Entity.Users;
import com.amarnath.bankingapp.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDeleteRequestValidation {

    private final UserRepository userRepository;

    public ResponseEntity<Object> validate(long id){

        Optional<Users> userById = userRepository.findById(id);

        if (userById.isEmpty()){

            return ApiResponse.generateResponse(
                    "User does not exist !",
                    HttpStatus.NOT_FOUND,
                    id
            );

        }

        return ApiResponse.generateResponse(
                "",
                HttpStatus.OK,
                id
        );

    }

}
