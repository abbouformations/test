package com.javaCDG.CDGp.services;

import com.javaCDG.CDGp.dtos.UserDto;
import com.javaCDG.CDGp.entities.User;
import com.javaCDG.CDGp.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private UserRepo userRepository;
    private ModelMapper modelMapper;

    public UserDto findUserByEmail(String email) {
        return modelMapper.map(userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("No User exist")),UserDto.class);
    }

    public UserDto saveUser(UserDto user) {
        return modelMapper.map(userRepository.save(modelMapper.map(user, User.class)),UserDto.class);
    }

    public void deleteUser(Long id) {
       userRepository.delete(userRepository.findById(id).orElseThrow(() -> new RuntimeException("No User exist")));
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(bo->modelMapper.map(bo, UserDto.class)).toList();
    }

    public UserDto findUserById(Long id) {
        return modelMapper.map(userRepository.findById(id).orElseThrow(()-> new RuntimeException("No User exist")), UserDto.class);
    }
}
