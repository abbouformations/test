package com.javaCDG.CDGp.services;
import com.javaCDG.CDGp.dtos.RoleDto;
import com.javaCDG.CDGp.entities.Role;
import com.javaCDG.CDGp.repository.RoleRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepo roleRepository;
    private ModelMapper modelMapper;

    public RoleDto saveRole(RoleDto role) {
        return modelMapper.map(roleRepository.save(modelMapper.map(role, Role.class)),RoleDto.class);
    }

    public void deleteRole(Long id) {
        roleRepository.delete(roleRepository.findById(id).orElseThrow(() -> new RuntimeException("No Role exist")));
    }

    public RoleDto getRoleByName(String role) {
        return modelMapper.map(roleRepository.findByRole(role).orElseThrow(()->new RuntimeException("No role exist")), RoleDto.class);
    }

}
