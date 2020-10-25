package com.example.assignments._3lagen.controller;

import com.example.assignments._3lagen.dao.Klant;
import com.example.assignments._3lagen.dto.KlantDto;
import com.example.assignments._3lagen.service.KlantService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequestMapping("KlantApi")
@RequiredArgsConstructor

public class KlantController {

    @Autowired
    KlantService klantService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<List<KlantDto>> getKlanten(){
        Collection<Klant> klanten = klantService.getALL();
        return new ResponseEntity(klanten, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<KlantDto> createKlant(@Valid @RequestBody KlantDto klant, BindingResult result)
    {
        if(result.hasErrors()) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Klant maakklant = klantService.create(klant);
        KlantDto mappedKlant = modelMapper.map(maakklant, KlantDto.class);
        return new ResponseEntity<>(mappedKlant, HttpStatus.CREATED);
    }

}
