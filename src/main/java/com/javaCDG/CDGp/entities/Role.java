package com.javaCDG.CDGp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String role;
    @ManyToMany(mappedBy = "roles")
    private List<User> users=new ArrayList<>();
}
