package com.fali.validator;

import com.fali.Dto.ArticleDto;
import com.fali.Dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public  static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        if(articleDto==null){
            errors.add("Veuillez rendeigner le code de l'article");
            errors.add("Veuillez rendeigner le designation de l'article");
            errors.add("Veuillez rendeigner le prix unitaire HT de l'article");
            errors.add("Veuillez rendeigner le taux de l'article");
            errors.add("Veuillez rendeigner le prix unitaire TTC de l'article");
            errors.add("Veuillez rendeigner le category de l'article");

        }

        if(!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("Veuillez rendeigner le code de l'article");
        }
        if(!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("Veuillez rendeigner le designation de l'article");
        }
        if(articleDto.getPrixUnitaireHT()==null){
            errors.add("Veuillez rendeigner le prix unitaire HT de l'article");
        }
        if(articleDto.getTauxTva()==null){
            errors.add("Veuillez rendeigner le taux de l'article");
        }
        if(articleDto.getPrixUnitaireTTC()==null){
            errors.add("Veuillez rendeigner le prix unitaire TTC de l'article");
        }
        if(articleDto.getCategory()==null){
            errors.add("Veuillez rendeigner le category de l'article");
        }

        return errors;
    }
}
