package com.javaCDG.CDGp.services;

import com.javaCDG.CDGp.dtos.UserDto;
import com.javaCDG.CDGp.dtos.VulDto;
import com.javaCDG.CDGp.entities.User;
import com.javaCDG.CDGp.entities.Vul;
import com.javaCDG.CDGp.repository.UserRepo;
import com.javaCDG.CDGp.repository.VulRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class VulService {

    private VulRepo vulRepo;
    private ModelMapper modelMapper;

    public VulDto saveVul(VulDto dto) {
        return modelMapper.map(vulRepo.save(modelMapper.map(dto, Vul.class)),VulDto.class);
    }

    public void deleteVul(Long id) {
        vulRepo.delete(vulRepo.findById(id).orElseThrow(() -> new RuntimeException("No Vulnerability exist")));
    }

    public List<VulDto> findAllVul() {
        return vulRepo.findAll().stream().map(bo->modelMapper.map(bo, VulDto.class)).toList();
    }

    public VulDto findVulById(Long id) {
        return modelMapper.map(vulRepo.findById(id).orElseThrow(()-> new RuntimeException("No Vul exist")), VulDto.class);
    }
}
