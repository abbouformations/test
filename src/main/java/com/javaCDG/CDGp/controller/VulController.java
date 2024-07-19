package com.javaCDG.CDGp.controller;

import com.javaCDG.CDGp.dtos.VulDto;
import com.javaCDG.CDGp.entities.Vul;
import com.javaCDG.CDGp.services.VulService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vul")
public class VulController {
    private VulService vulService;

    @GetMapping("/all")
    public List<VulDto> getAllVuls() {
        return vulService.findAllVul();
    }
    @PostMapping
    public ResponseEntity<VulDto> createUser(@RequestBody @Valid VulDto dto) {
        return new ResponseEntity<>(vulService.saveVul(dto), HttpStatus.CREATED);
    }

    // Logique pour mettre à jour une vul existante
    @PutMapping("/{id}")
    public ResponseEntity<VulDto> updateVul(@PathVariable Long id, @RequestBody @Valid VulDto dto) {
    dto.setId(id);
        return new ResponseEntity<>(vulService.saveVul(dto), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVul(@PathVariable Long id) {
        vulService.deleteVul(id);
        return new ResponseEntity<>(String.format("Vul with id = %s is removed",id), HttpStatus.CREATED);
    }
}
