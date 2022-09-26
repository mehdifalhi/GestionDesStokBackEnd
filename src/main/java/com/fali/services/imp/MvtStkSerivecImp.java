package com.fali.services.imp;

import com.fali.Dto.MvtStkDto;
import com.fali.entites.MvtStk;
import com.fali.repositories.MvtStkRepository;
import com.fali.services.MvtStkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MvtStkSerivecImp implements MvtStkService {

    private MvtStkRepository mvtStkRepository;
    @Autowired
    public MvtStkSerivecImp(MvtStkRepository mvtStkRepository){
        this.mvtStkRepository=mvtStkRepository;
    }
    @Override
    public MvtStkDto save(MvtStkDto dto) {
        return MvtStkDto.fromEntity(mvtStkRepository.save(MvtStkDto.toEntity(dto)));
    }

    @Override
    public MvtStkDto findById(Long idMvtStk) {
        Optional<MvtStk> mvtStk = mvtStkRepository.findById(idMvtStk);
        return Optional.of(MvtStkDto.fromEntity(mvtStk.get()))
                .orElseThrow(()-> new RuntimeException( "id not found" + idMvtStk));
    }

    @Override
    public List<MvtStkDto> findAll() {
        return mvtStkRepository.findAll().stream()
                .map(MvtStkDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idMvtStk) {
      mvtStkRepository.deleteById(idMvtStk);
    }
}
