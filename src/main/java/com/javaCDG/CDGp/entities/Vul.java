package com.javaCDG.CDGp.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vul {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @Column(nullable = false)
    private String vulname;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String activiteConcerne;

    @Column(nullable = false)
    private String impact;

    @Column(nullable = false)
    private String actionP;

    @Column(nullable = false)
    private String actionM;

    @Column(nullable = false)
    private String responsable;

    @Column(nullable = false)
    private Date echeance;
    @ManyToOne
    @JoinColumn(name="niv_alerte")
    private NiveauAlerte nivAlerte;

}
