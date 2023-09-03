package com.amarnath.bankingapp.Mapper;

import com.amarnath.bankingapp.DTO.UserDTO;
import com.amarnath.bankingapp.Entity.Users;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersMapper {

    private final ModelMapper mapper;

    public Users mapToEntity(UserDTO userDTO){

        return mapper.map(userDTO, Users.class);

    }

    public UserDTO mapToDTO(Users users){

        return mapper.map(users, UserDTO.class);

    }

}
