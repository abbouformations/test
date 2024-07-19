package com.javaCDG.CDGp.dtos;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NiveauAlerteDto {
    private Long id;
    private String mineur;
    private String modere;
    private String majeur;
}
