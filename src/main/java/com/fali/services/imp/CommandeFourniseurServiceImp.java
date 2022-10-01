package com.fali.services.imp;

import com.fali.Dto.CommandeFournisseurDto;
import com.fali.Dto.LigneCommandeFournisseurDto;
import com.fali.entites.Article;
import com.fali.entites.CommandeFournisseur;
import com.fali.entites.Fournisseur;
import com.fali.entites.LigneCommandeFournisseur;
import com.fali.exception.EntityNotFoundException;
import com.fali.exception.ErrorsCodes;
import com.fali.exception.InvalidEntityException;
import com.fali.repositories.ArticleRepository;
import com.fali.repositories.ComFournisseurRepository;
import com.fali.repositories.FournisseurRepository;
import com.fali.repositories.LigneComFournisseurRepository;
import com.fali.services.CommandeFournisseurService;
import com.fali.validator.CommandeClientValidator;
import com.fali.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFourniseurServiceImp  implements CommandeFournisseurService {

   private ComFournisseurRepository comFournisseurRepository;
   private LigneComFournisseurRepository ligneComFournisseurRepository;
   private FournisseurRepository fournisseurRepository;
   private ArticleRepository articleRepository ;

   @Autowired
   public CommandeFourniseurServiceImp(ComFournisseurRepository comFournisseurRepository,
                                       LigneComFournisseurRepository ligneComFournisseurRepository,
                                       FournisseurRepository fournisseurRepository,
                                       ArticleRepository articleRepository){
       this.comFournisseurRepository=comFournisseurRepository;
       this.ligneComFournisseurRepository=ligneComFournisseurRepository;
       this.fournisseurRepository=fournisseurRepository;
       this.articleRepository=articleRepository;

   }


    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Commande Fournissuer n'est pas valide");
            throw new InvalidEntityException("la commande Fournissuer n'est pa valide", ErrorsCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getIdFournisseur());
        List<String> articleErrors = new ArrayList<>();
        if(dto.getLigneCommandeFournisseurs() != null){
            dto.getLigneCommandeFournisseurs().forEach(ligComCli ->{
                if(ligComCli.getArticle() !=null){
                    Optional<Article> article = articleRepository.findById(ligComCli.getArticle().getIdArticle());
                    articleErrors.add("L'article avec l'id"+ligComCli.getArticle().getIdArticle()+"n'exist pas");
                }
            });
        }
        if(!articleErrors.isEmpty()){
            log.error("Commande Client n'est pas valide");
            throw new InvalidEntityException("article n'existe pas dans la bdd",ErrorsCodes.ARTICLE_NOT_FOUND,articleErrors);
        }
        CommandeFournisseur saveCmdFor = comFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));
        if (dto.getLigneCommandeFournisseurs() != null) {
        dto.getLigneCommandeFournisseurs().forEach(lifCmdFor ->{
            LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(lifCmdFor);
            ligneCommandeFournisseur.setCommandeFournisseur(saveCmdFor);
            ligneComFournisseurRepository.save(ligneCommandeFournisseur);
        });
        }
        return CommandeFournisseurDto.fromEntity(saveCmdFor);
    }

    @Override
    public CommandeFournisseurDto findById(Long idCommandeFournisseur) {
        return comFournisseurRepository.findById(idCommandeFournisseur)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune commande fournisseur n'a ete trouve avec l'id" + idCommandeFournisseur,ErrorsCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return comFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune commande fournisseur n'a ete trouve avec le code" + code,ErrorsCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return comFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long idCommandeFournisseur) {
       comFournisseurRepository.deleteById(idCommandeFournisseur);
    }
}
