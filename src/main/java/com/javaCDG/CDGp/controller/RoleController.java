package com.javaCDG.CDGp.controller;


import com.javaCDG.CDGp.dtos.RoleDto;
import com.javaCDG.CDGp.entities.Role;
import com.javaCDG.CDGp.services.RoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {
    private RoleService roleService;
    @GetMapping("/{role}")
    public ResponseEntity<RoleDto> getRole(String role) {
        return new ResponseEntity<>(roleService.getRoleByName(role), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String>  createRole(@RequestBody @Valid  RoleDto role) {
        roleService.saveRole(role);
        return new ResponseEntity<>(String.format("Role %s was created with success",role.getRole()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>  updateRole(@PathVariable Long id,@RequestBody RoleDto role) {
        role.setId(id);
        roleService.saveRole(role);
        return new ResponseEntity<>(String.format("Role %s was created with success",role.getRole()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>   deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>(String.format("Role %s was removed with success",id), HttpStatus.OK);
    }
}


