package com.javaCDG.CDGp.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    @NotEmpty
    private String mdp;
    @NotEmpty
    private String email;
    private List<RoleDto> roles=new ArrayList<>();

}
