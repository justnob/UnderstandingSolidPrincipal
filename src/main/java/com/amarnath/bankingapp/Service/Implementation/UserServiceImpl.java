package com.amarnath.bankingapp.Service.Implementation;

import com.amarnath.bankingapp.CustomeResponse.ApiResponse;
import com.amarnath.bankingapp.DTO.UserDTO;
import com.amarnath.bankingapp.Entity.Users;
import com.amarnath.bankingapp.Mapper.UsersMapper;
import com.amarnath.bankingapp.Repository.UserRepository;
import com.amarnath.bankingapp.Service.UserService;
import com.amarnath.bankingapp.Validations.UserCreationRequestValidation;
import com.amarnath.bankingapp.Validations.UserDeleteRequestValidation;
import com.amarnath.bankingapp.Validations.UserGetAllRequestValidation;
import com.amarnath.bankingapp.Validations.UserUpdateRequestValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersMapper usersMapper;
    private final UserRepository userRepository;
    private final UserCreationRequestValidation userCreationRequestValidation;
    private final UserUpdateRequestValidation userUpdateRequestValidation;
    private final UserDeleteRequestValidation userDeleteRequestValidation;
    private final UserGetAllRequestValidation userGetAllRequestValidation;

    @Override
    public ResponseEntity<Object> createUser(UserDTO userDTO) {

        ResponseEntity<Object> validate = userCreationRequestValidation.validate(userDTO);
        if (validate.getStatusCode().value() != 200){

            return validate;

        }

        Users users = usersMapper.mapToEntity(userDTO);

        Users savedUser = userRepository.save(users);

        return ApiResponse.generateResponse(
                "User has been created successfully",
                HttpStatus.CREATED,
                usersMapper.mapToDTO(savedUser)
        );

    }

    @Override
    public Object updateUser(long id, UserDTO userDTO) {

        ResponseEntity<Object> validate = userUpdateRequestValidation.validate(id, userDTO);
        if (validate.getStatusCode().value() != 200){

            return validate;

        }

        Users userById = userRepository.findById(id).get();
        userById.setUserName(userDTO.getUserName());
        userById.setPassword(userDTO.getPassword());
        Users saved = userRepository.save(userById);

        return ApiResponse.generateResponse(
                "User has been updated successfully",
                HttpStatus.OK,
                usersMapper.mapToDTO(saved)
        );

    }

    @Override
    public Object deleteUser(long id) {

        ResponseEntity<Object> validate = userDeleteRequestValidation.validate(id);
        if (validate.getStatusCode().value() != 200){

            return validate;

        }

        return ApiResponse.generateResponse(
                String.format("User hsa been deleted successfully with id: " + id + "!"),
                HttpStatus.OK,
                null
        );
    }

    public ResponseEntity<Object> getAllUsers() {

        ResponseEntity<Object> validate = userGetAllRequestValidation.validate();
        if (validate.getStatusCode().value() != 200){

            return  validate;

        }

        List<Users> allUsers = userRepository.findAll();
        long count = allUsers.stream().count();
        return  ApiResponse.generateResponse(
                String.format("Total number of users are " + count),
                HttpStatus.OK,
                allUsers
        );
    }
}
