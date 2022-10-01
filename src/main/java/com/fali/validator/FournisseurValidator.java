package com.fali.validator;



import com.fali.Dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public  static List<String> validate(FournisseurDto dto) {
        List<String> errors = new ArrayList<>();
        if(dto==null){
            errors.add("Veuillez rendeigner le nom du client");
            errors.add("Veuillez rendeigner le prenom du client");
            errors.add("Veuillez rendeigner le email du client");
            errors.add("Veuillez rendeigner l'adresse du client");
        }

        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez rendeigner le nom du fournisseur");
        }
        if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez rendeigner le prenom du fournisseur");
        }
        if(!StringUtils.hasLength(dto.getMail())){
            errors.add("Veuillez rendeigner le email du fournisseur");
        }
        if(!StringUtils.hasLength(dto.getAdresse())){
            errors.add("Veuillez rendeigner l'adresse du fournisseur");
        }


        return errors;
    }
}
