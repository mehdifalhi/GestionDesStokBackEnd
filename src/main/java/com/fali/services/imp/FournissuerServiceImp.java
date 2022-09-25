package com.fali.services.imp;

import com.fali.Dto.FournisseurDto;
import com.fali.entites.Fournisseur;
import com.fali.repositories.FournisseurRepository;
import com.fali.services.FournisseurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournissuerServiceImp implements FournisseurService {
    private FournisseurRepository fournisseurRepository;
    @Autowired
    public FournissuerServiceImp (FournisseurRepository fournisseurRepository){
        this.fournisseurRepository=fournisseurRepository;
    }
    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return FournisseurDto.fromEntity(FournisseurDto.toEntity(dto));
    }

    @Override
    public FournisseurDto findById(Long idFournisseur) {
        Optional<Fournisseur> fournisseur=fournisseurRepository.findById(idFournisseur);
        return Optional.of(FournisseurDto.fromEntity(fournisseur.get()))
                .orElseThrow(() ->
                        new RuntimeException("id not found" + idFournisseur));
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idFournisseur) {
        fournisseurRepository.deleteById(idFournisseur);

    }
}
