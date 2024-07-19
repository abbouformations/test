package com.javaCDG.CDGp.repository;


import com.javaCDG.CDGp.entities.User;
import com.javaCDG.CDGp.entities.Vul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VulRepo extends JpaRepository<Vul, Long> {

}
