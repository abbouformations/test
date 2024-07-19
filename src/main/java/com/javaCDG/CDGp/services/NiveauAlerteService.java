package com.javaCDG.CDGp.services;

import com.javaCDG.CDGp.dtos.NiveauAlerteDto;
import com.javaCDG.CDGp.dtos.VulDto;
import com.javaCDG.CDGp.entities.NiveauAlerte;
import com.javaCDG.CDGp.entities.Vul;
import com.javaCDG.CDGp.repository.NiveauAlerteRepo;
import com.javaCDG.CDGp.repository.VulRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class NiveauAlerteService {

    private NiveauAlerteRepo niveauAlerteRepo;
    private ModelMapper modelMapper;

    public NiveauAlerteDto saveNiveauAlerte(NiveauAlerteDto dto) {
        return modelMapper.map(niveauAlerteRepo.save(modelMapper.map(dto, NiveauAlerte.class)),NiveauAlerteDto.class);
    }

    public void deleteNiveauAlerte(Long id) {
        niveauAlerteRepo.delete(niveauAlerteRepo.findById(id).orElseThrow(() -> new RuntimeException("No NA exist")));
    }

    public List<NiveauAlerteDto> findAllNiveauAlerts() {
        return niveauAlerteRepo.findAll().stream().map(bo->modelMapper.map(bo, NiveauAlerteDto.class)).toList();
    }

    public NiveauAlerteDto findNiveaiAlerteById(Long id) {
        return modelMapper.map(niveauAlerteRepo.findById(id).orElseThrow(()-> new RuntimeException("No NA exist")), NiveauAlerteDto.class);
    }
}
