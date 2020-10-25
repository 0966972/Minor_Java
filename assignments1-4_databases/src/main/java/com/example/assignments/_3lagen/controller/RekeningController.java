package com.example.assignments._3lagen.controller;

import com.example.assignments._3lagen.dao.Klant;
import com.example.assignments._3lagen.dao.Rekening;
import com.example.assignments._3lagen.dto.KlantDto;
import com.example.assignments._3lagen.dto.RekeningDto;
import com.example.assignments._3lagen.service.KlantService;
import com.example.assignments._3lagen.service.RekeningService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("RekeningApi")
@RequiredArgsConstructor
public class RekeningController {
    @Autowired
    RekeningService rekeningService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<Collection<RekeningDto>> getRekeningen(){
        Collection<Rekening> rekeningen = rekeningService.getALL();
        return new ResponseEntity(rekeningen, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<RekeningDto> createRekening(@Valid @RequestBody RekeningDto rekening, BindingResult result)
    {
        if(result.hasErrors()) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Rekening maakrekening = rekeningService.create(rekening);
        RekeningDto mappedRekening = modelMapper.map(maakrekening, RekeningDto.class);
        return new ResponseEntity<>(mappedRekening, HttpStatus.CREATED);
    }

}
