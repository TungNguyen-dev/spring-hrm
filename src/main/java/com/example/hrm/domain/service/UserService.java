package com.example.hrm.domain.service;

import com.example.hrm.api.dto.UserDTO;
import com.example.hrm.api.dto.UserRequestDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();

    UserDTO getById(Long id);

    UserDTO create(UserRequestDTO userDto);

    UserDTO update(Long id, UserRequestDTO userDto);

    Boolean delete(Long id);
}
