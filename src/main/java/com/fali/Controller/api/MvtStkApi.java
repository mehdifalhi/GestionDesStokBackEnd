package com.fali.Controller.api;

import com.fali.Dto.MvtStkDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/mvtstock")
public interface MvtStkApi {
    @PostMapping(value ="/mvtstock/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public MvtStkDto save(@RequestBody MvtStkDto dto);
    @GetMapping(value ="/mvtstock/{idMvtStk}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public MvtStkDto findById(@PathVariable("idMvtStk") Long idMvtStk);
    @GetMapping(value ="/mvtstock/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MvtStkDto> findAll();
    @DeleteMapping(value ="/mvtstock/delete/{idMvtStk}")
    void deleteById(@PathVariable("idMvtStk")Long idMvtStk);
}
