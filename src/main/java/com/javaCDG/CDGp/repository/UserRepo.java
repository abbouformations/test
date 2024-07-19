package com.javaCDG.CDGp.repository;

import com.javaCDG.CDGp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Autowired
    Optional<User> findByEmail(String email);

    }
