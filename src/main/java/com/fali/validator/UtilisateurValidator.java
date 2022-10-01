package com.fali.validator;

import com.fali.Dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public  static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();

        if(utilisateurDto==null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
            errors.add("Veuillez renseigner le mode pass de l'utilisateur");

        }
        if(utilisateurDto==null||!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }
        if(utilisateurDto==null||!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
        }
        if(utilisateurDto==null||!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Veuillez renseigner le mode pass de l'utilisateur");
        }



        return errors;
    }
}
