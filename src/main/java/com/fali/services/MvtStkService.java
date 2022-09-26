package com.fali.services;


import com.fali.Dto.MvtStkDto;

import java.util.List;

public interface MvtStkService {

    public MvtStkDto save(MvtStkDto dto);

    public MvtStkDto findById(Long idMvtStk);

    public List<MvtStkDto> findAll();

    void deleteById(Long idMvtStk);
}
