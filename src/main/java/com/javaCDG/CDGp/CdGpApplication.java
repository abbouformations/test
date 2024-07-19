package com.javaCDG.CDGp;

import com.javaCDG.CDGp.dtos.NiveauAlerteDto;
import com.javaCDG.CDGp.dtos.RoleDto;
import com.javaCDG.CDGp.dtos.UserDto;
import com.javaCDG.CDGp.dtos.VulDto;
import com.javaCDG.CDGp.services.NiveauAlerteService;
import com.javaCDG.CDGp.services.RoleService;
import com.javaCDG.CDGp.services.UserService;
import com.javaCDG.CDGp.services.VulService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CdGpApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdGpApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(UserService userService, RoleService roleService, NiveauAlerteService niveauAlerteService, VulService vulService) {
		return args -> {
			RoleDto role1 = roleService.saveRole(RoleDto.builder().role("ROLE_1").build());
			RoleDto role2 = roleService.saveRole(RoleDto.builder().role("ROLE_2").build());

			userService.saveUser(
					UserDto.builder().
							email("user1@gmail.com").
							mdp("1234").
							roles(List.of(role1)).
							build()
			);

			userService.saveUser(
					UserDto.builder().
							email("user2@gmail.com").
							mdp("1234").
							roles(List.of(role2)).
							build()
			);

			NiveauAlerteDto niveauAlerteDto1 = niveauAlerteService.saveNiveauAlerte(NiveauAlerteDto.builder().
					majeur("oui").
					mineur("non").
					modere("non").
					build());

			NiveauAlerteDto niveauAlerteDto2 = niveauAlerteService.saveNiveauAlerte(NiveauAlerteDto.builder().
					majeur("non").
					mineur("oui").
					modere("non").

					build());

			vulService.saveVul(VulDto.builder().
					date(new Date()).
					description("bbbbb").
					nivAlerte(niveauAlerteDto1).
					echeance(new Date()).
					responsable("ddd").
					vulname("PROBLEM 900").
					source("dddddd").
					activiteConcerne("ddzzzz").
					impact("Majeur").
					actionP("do jjj").
					actionM("do hggg").
					build());

			vulService.saveVul(VulDto.builder().
					date(new Date()).
					description("deeee").
					nivAlerte(niveauAlerteDto2).
					echeance(new Date()).
					responsable("ADMIN").
					vulname("PROBLEM 897").
					source("OUEGG").
					activiteConcerne("BLAL").
					impact("MINEUR").
					actionP("do dddsqcfv").
					actionM("do hgdghd de").
					build());
		};
	}

}
