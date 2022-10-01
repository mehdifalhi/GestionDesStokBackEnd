package com.fali.services.imp;

import com.fali.Dto.CommandeClientDto;
import com.fali.Dto.LigneCommandeClientDto;
import com.fali.entites.Article;
import com.fali.entites.Client;
import com.fali.entites.CommandeClient;
import com.fali.entites.LigneCommandeClient;
import com.fali.exception.EntityNotFoundException;
import com.fali.exception.ErrorsCodes;
import com.fali.exception.InvalidEntityException;
import com.fali.repositories.ArticleRepository;
import com.fali.repositories.ClientRepository;
import com.fali.repositories.ComClientRepository;
import com.fali.repositories.LigneComClientRepository;
import com.fali.services.CommandeClientService;
import com.fali.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImp implements CommandeClientService {

    private ComClientRepository comClientRepository;
    private LigneComClientRepository ligneComClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    @Autowired
    public CommandeClientServiceImp(ComClientRepository comClientRepository,
                                    ClientRepository clientRepository,
                                    ArticleRepository articleRepository,
                                    LigneComClientRepository ligneComClientRepository){
        this.comClientRepository=comClientRepository;
        this.ligneComClientRepository=ligneComClientRepository;
        this.clientRepository=clientRepository;
        this.articleRepository=articleRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {

        List<String> errors = CommandeClientValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Commande Client n'est pas valide");
            throw new InvalidEntityException("la commande client n'est pa valide",ErrorsCodes.COMMANDE_CLIENT_NOT_VALID,errors);
        }
        Optional<Client> client = clientRepository.findById(dto.getClientDto().getIdClient());

     /*   if(!client.isPresent()){
            log.warn("id {} ma khdamch",dto.getClientDto().getIdClient());
            throw new EntityNotFoundException("makinch client", ErrorsCodes.CLIENT_NOT_FOUND);
        }*/

        List<String> articleErrors = new ArrayList<>();
        if(dto.getLigneCommandeClients() != null){
            dto.getLigneCommandeClients().forEach(ligComCli ->{
                if(ligComCli.getArticle() !=null){
                    Optional<Article> article = articleRepository.findById(ligComCli.getArticle().getIdArticle());
                    if (article.isPresent()){
                        articleErrors.add("L'article avec l'id"+ligComCli.getArticle().getIdArticle()+"n'exist pas");

                    }
                }
            });
        }
        if(!articleErrors.isEmpty()){
            log.error("Commande Client n'est pas valide");
            throw new InvalidEntityException("article n'existe pas dans la bdd",ErrorsCodes.ARTICLE_NOT_FOUND,articleErrors);
        }
        CommandeClient saveCmdClt = comClientRepository.save(CommandeClientDto.toEntity(dto));

        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommandeClient(saveCmdClt);
                ligneComClientRepository.save(ligneCommandeClient);
            });
        }
        return CommandeClientDto.fromEntity(saveCmdClt);
    }

    @Override
    public CommandeClientDto findById(Long id) {
        if (id == null){
            log.error("commande Client ID is Null");
            return null;
        }
        return comClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune commande n'a ete trouve avec l'id" + id,ErrorsCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return comClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune commande n'a ete trouve avec le code" + code,ErrorsCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return comClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long idCommandeClient) {
           comClientRepository.deleteById(idCommandeClient);
    }
}
