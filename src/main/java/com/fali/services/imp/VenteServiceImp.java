package com.fali.services.imp;

import com.fali.Dto.LigneVenteDto;
import com.fali.Dto.VenteDto;
import com.fali.entites.Article;
import com.fali.entites.LigneVente;
import com.fali.entites.Vente;
import com.fali.repositories.ArticleRepository;
import com.fali.repositories.LigneVenteRepository;
import com.fali.repositories.VenteRepository;
import com.fali.services.VenteService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImp implements VenteService {
    private VenteRepository venteRepository;
    private LigneVenteRepository ligneVenteRepository;
    private ArticleRepository articleRepository;

    public VenteServiceImp( VenteRepository venteRepository,LigneVenteRepository ligneVenteRepository,ArticleRepository articleRepository){
        this.venteRepository=venteRepository;
        this.ligneVenteRepository=ligneVenteRepository;
        this.articleRepository=articleRepository;
    }

    @Override
    public VenteDto save(VenteDto dto) {
      //  List<String> articleErrors =new ArrayList<>();
        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getIdArticle());
           /* if(article.isPresent()){
                articleErrors.add("aucun article avec l'id "+ligneVenteDto.getArticle().getIdArticle() +"n'a ete trouve dans la BD");
            }*/

        });
        Vente savedVentes = venteRepository.save(VenteDto.toEntity(dto));
        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVente(savedVentes);
            ligneVenteRepository.save(ligneVente);
        });


        return VenteDto.fromEntity(savedVentes);
    }

    @Override
    public VenteDto findById(Long idVente) {
        return venteRepository.findById(idVente)
                .map(VenteDto::fromEntity)
                .orElseThrow(()-> new RuntimeException(
                        "Aucun Vente n'a ete trouve dans DB "));
    }

    @Override
    public VenteDto findByCode(String code) {
        return venteRepository.findVenteByCode(code)
                .map(VenteDto::fromEntity)
                .orElseThrow(()-> new RuntimeException(
                        "Aucun Vente n'a ete trouve dans DB "));
    }

    @Override
    public List<VenteDto> findAll() {

        return venteRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idVente) {

        venteRepository.deleteById(idVente);
    }
}
