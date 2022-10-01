package com.fali.Controller;

import com.fali.Controller.api.UtilisateurApi;
import com.fali.Dto.UtilisateurDto;
import com.fali.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UtilisateurController implements UtilisateurApi {
   private UtilisateurService utilisateurService;
   @Autowired
   public UtilisateurController(UtilisateurService utilisateurService){
       this.utilisateurService=utilisateurService;
   }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto findById(Long idUtilisateur) {

       return utilisateurService.findById(idUtilisateur);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void deleteById(Long idUtilisateur) {
         utilisateurService.deleteById(idUtilisateur);
    }
}
