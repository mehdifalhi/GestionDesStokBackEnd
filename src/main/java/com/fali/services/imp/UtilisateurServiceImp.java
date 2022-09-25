package com.fali.services.imp;

import com.fali.Dto.UtilisateurDto;
import com.fali.entites.Utilisateur;
import com.fali.repositories.UtilisateurRepository;
import com.fali.services.UtilisateurService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
public class UtilisateurServiceImp implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurServiceImp( UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
    }

    @Override
    public UtilisateurDto findById(Long idUtilisateur) {

        Optional<Utilisateur> utilisateur =utilisateurRepository.findById(idUtilisateur);

        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get()))
                .orElseThrow(()->
                        new RuntimeException("id is not found" + idUtilisateur));
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idUtilisateur) {
     utilisateurRepository.deleteById(idUtilisateur);
    }
}
