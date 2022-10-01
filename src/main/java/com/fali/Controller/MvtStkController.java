package com.fali.Controller;

import com.fali.Controller.api.MvtStkApi;
import com.fali.Dto.MvtStkDto;
import com.fali.services.MvtStkService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MvtStkController implements MvtStkApi {

    private MvtStkService mvtStkService;

    public  MvtStkController(MvtStkService mvtStkService){
        this.mvtStkService=mvtStkService;
    }
    @Override
    public MvtStkDto save(MvtStkDto dto) {
        return mvtStkService.save(dto);
    }

    @Override
    public MvtStkDto findById(Long idMvtStk) {
        return mvtStkService.findById(idMvtStk);
    }

    @Override
    public List<MvtStkDto> findAll() {
        return mvtStkService.findAll();
    }

    @Override
    public void deleteById(Long idMvtStk) {
      mvtStkService.deleteById(idMvtStk);
    }
}
