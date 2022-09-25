package com.fali.services.imp;

import com.fali.Dto.VenteDto;
import com.fali.entites.Vente;
import com.fali.repositories.VenteRepository;
import com.fali.services.VenteService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImp implements VenteService {
    private VenteRepository venteRepository;

    public VenteServiceImp( VenteRepository venteRepository){
        this.venteRepository=venteRepository;
    }

    @Override
    public VenteDto save(VenteDto dto) {
        return VenteDto.fromEntity(venteRepository.save(VenteDto.toEntity(dto)));
    }

    @Override
    public VenteDto findById(Long idVente) {
        Optional<Vente> vente= venteRepository.findById(idVente);
        return Optional.of(VenteDto.fromEntity(vente.get()))
                .orElseThrow(()->
                        new RuntimeException("id not FOUND" +idVente));
    }

    @Override
    public List<VenteDto> findAll() {

        return venteRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idVente) {

        venteRepository.deleteById(idVente);
    }
}
