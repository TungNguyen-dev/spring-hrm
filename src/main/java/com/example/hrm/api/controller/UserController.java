package com.example.hrm.api.controller;

import com.example.hrm.api.dto.UserRequestDTO;
import com.example.hrm.api.dto.UserDTO;
import com.example.hrm.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(this.userService.create(userRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> detail(@PathVariable Long id) {
        UserDTO userDto = this.userService.getById(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(this.userService.update(id, userRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        Boolean result = this.userService.delete(id);
        Map<String, Boolean> res = new HashMap<>();
        res.put("Success", result);
        return ResponseEntity.ok(res);
    }
}
