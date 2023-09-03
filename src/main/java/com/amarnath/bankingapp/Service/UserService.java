package com.amarnath.bankingapp.Service;

import com.amarnath.bankingapp.CustomeResponse.ApiResponse;
import com.amarnath.bankingapp.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    Object createUser(UserDTO userDTO);
    Object updateUser(long id, UserDTO userDTO);
    Object deleteUser(long id);

    ResponseEntity<Object>  getAllUsers();

}
