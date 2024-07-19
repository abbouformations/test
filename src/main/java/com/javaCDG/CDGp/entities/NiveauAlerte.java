package com.javaCDG.CDGp.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NiveauAlerte {
    @Id
    @GeneratedValue
    private Long id;
    private String mineur;
    @Column(nullable=false)
    private String modere;

    @Column(nullable=false)
    private String majeur;
}
