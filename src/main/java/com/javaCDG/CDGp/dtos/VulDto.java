package com.javaCDG.CDGp.dtos;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VulDto {
    private Long id;
    private Date date;
    private String vulname;
    private String description;
    private String source;
    private String activiteConcerne;
    private String impact;
    private String actionP;
    private String actionM;
    private String responsable;
    private Date echeance;
    private NiveauAlerteDto nivAlerte;

}
