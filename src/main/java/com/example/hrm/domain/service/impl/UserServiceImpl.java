package com.example.hrm.domain.service.impl;

import com.example.hrm.api.dto.UserDTO;
import com.example.hrm.api.dto.UserRequestDTO;
import com.example.hrm.domain.entity.User;
import com.example.hrm.domain.repository.UserRepository;
import com.example.hrm.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> userDtoList = new ArrayList<>();

        List<User> userList = this.userRepository.findAll();
        userList.forEach(user -> {
            UserDTO userDto = new UserDTO(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getCreatedAt(),
                    user.getUpdatedAt()
            );
            userDtoList.add(userDto);
        });

        return userDtoList;
    }

    @Override
    public UserDTO getById(Long id) {
        User user = this.findById(id);

        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    @Override
    public UserDTO create(UserRequestDTO userRequestDTO) {
        LocalDateTime now = LocalDateTime.now();
        User user = new User(null, userRequestDTO.getFirstName(), userRequestDTO.getLastName(), now, now);
        user = this.userRepository.save(user);

        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    @Override
    public UserDTO update(Long id, UserRequestDTO userRequestDTO) {
        User user = this.findById(id);

        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setUpdatedAt(LocalDateTime.now());

        user = this.userRepository.save(user);

        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    @Override
    public Boolean delete(Long id) {
        User user = this.findById(id);
        this.userRepository.delete(user);
        return true;
    }

    private User findById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }
}
