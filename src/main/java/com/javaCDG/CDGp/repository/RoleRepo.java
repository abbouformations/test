package com.javaCDG.CDGp.repository;

import com.javaCDG.CDGp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository <Role, Long> {

    Optional<Role> findByUsers_Email(String email);
    Optional<Role> findByRole(String role);


}
