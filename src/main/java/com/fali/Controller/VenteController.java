package com.fali.Controller;

import com.fali.Controller.api.VenteApi;
import com.fali.Dto.VenteDto;
import com.fali.repositories.VenteRepository;
import com.fali.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class VenteController implements VenteApi {

    private VenteService venteService;

    @Autowired
    public VenteController(VenteService venteService)    {
        this.venteService=venteService;
    }
    @Override
    public VenteDto save(VenteDto dto) {
        return venteService.save(dto);
    }

    @Override
    public VenteDto findById(Long idVente) {
        return venteService.findById(idVente);
    }

    @Override
    public List<VenteDto> findAll() {
        return venteService.findAll();
    }

    @Override
    public void deleteById(Long idVente) {
        venteService.deleteById(idVente);
    }
}
