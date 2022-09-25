package com.fali.Controller;

import com.fali.Controller.api.FournissuerApi;
import com.fali.Dto.FournisseurDto;
import com.fali.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FournisseurController implements FournissuerApi {
    private FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurServic){
        this.fournisseurService=fournisseurServic;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Long idFournisseur) {
        return fournisseurService.findById(idFournisseur);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void deleteById(Long idFournisseur) {
        fournisseurService.deleteById(idFournisseur);
    }
}
