package com.fali.services.imp;

import com.fali.Dto.CommandeClientDto;
import com.fali.Dto.LigneCommandeClientDto;
import com.fali.entites.Article;
import com.fali.entites.Client;
import com.fali.entites.CommandeClient;
import com.fali.entites.LigneCommandeClient;
import com.fali.repositories.ArticleRepository;
import com.fali.repositories.ClientRepository;
import com.fali.repositories.ComClientRepository;
import com.fali.repositories.LigneComClientRepository;
import com.fali.services.CommandeClientService;
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
        Optional<Client> client = clientRepository.findById(dto.getClientDto().getIdClient());
/*
        if(client.isEmpty()){
            log.warn("");
        }*/
        List<String> ArticleErrors = new ArrayList<>();
        if(dto.getLigneCommandeClients() != null){
            dto.getLigneCommandeClients().forEach(ligComCli ->{
                if(ligComCli.getArticle() !=null){
                    Optional<Article> article = articleRepository.findById(ligComCli.getArticle().getIdArticle());
                }
            });
        }
        CommandeClient saveCmdClt = comClientRepository.save(CommandeClientDto.toEntity(dto));

        dto.getLigneCommandeClients().forEach(ligCmdClt ->{
            LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
            ligneCommandeClient.setCommandeClient(saveCmdClt);
            ligneComClientRepository.save(ligneCommandeClient);
        });
        return CommandeClientDto.fromEntity(saveCmdClt);
    }

    @Override
    public CommandeClientDto findById(Long idCommandeClient) {
        return comClientRepository.findById(idCommandeClient)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new RuntimeException("Aucune commande client trouve")
                );
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return comClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new RuntimeException("Aucune commande client trouve")
                );
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
