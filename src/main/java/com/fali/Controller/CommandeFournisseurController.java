package com.fali.Controller;

import com.fali.Controller.api.CommandeFournisseurApi;
import com.fali.Dto.CommandeFournisseurDto;
import com.fali.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    private CommandeFournisseurService commandeFournisseurService;
    @Autowired
    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService){
        this.commandeFournisseurService=commandeFournisseurService;
    }
    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        return commandeFournisseurService.save(dto);
    }

    @Override
    public CommandeFournisseurDto findById(Long idCommandeFournisseur) {
        return commandeFournisseurService.findById(idCommandeFournisseur);
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCode(code);
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();
    }

    @Override
    public void delete(Long idCommandeFournisseur) {
       commandeFournisseurService.delete(idCommandeFournisseur);
    }
}
