package com.example.demo.controller;

import com.example.demo.dao.Rekening;
import com.example.demo.dto.RekeningDto;
import com.example.demo.service.RekeningService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("RekeningApi")
public class RekeningController {
    @Autowired
    RekeningService rekeningService;

    @Autowired
    ModelMapper modelMapper;


    @CacheEvict(value = "RekeningApi", allEntries = true)
    @PostMapping
    public ResponseEntity<RekeningDto> createRekening(@Valid @RequestBody RekeningDto rekening, BindingResult result)
    {
        if (result.hasErrors())
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        rekeningService.createRekening(rekening);

        return new ResponseEntity(HttpStatus.OK);
    }

    @Cacheable("RekeningApi")
    @GetMapping
    public ResponseEntity<Collection<RekeningDto>> getRekeningen()
    {
        var rekeningen = rekeningService.getRekeningen();
        return  new ResponseEntity(rekeningen, HttpStatus.OK);
    }
    @Cacheable("RekeningApi")
    @GetMapping("/{id}")
    public ResponseEntity<RekeningDto> getRekening(@PathVariable("id") Integer id){
        var rekening = rekeningService.getRekening(id);
        if (rekening == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        RekeningDto mappedrekening = modelMapper.map(rekening, RekeningDto.class);
        return new ResponseEntity(mappedrekening, HttpStatus.OK);
    }
    @CacheEvict(value = "RekeningApi", allEntries = true)
    @PutMapping("/{id}")
    public ResponseEntity updateRekening(@Valid @PathVariable("id") Integer id, @RequestBody Rekening rekening)
    {
        var rekening_oud = rekeningService.getRekening(id);
        if (rekening_oud == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        rekeningService.updateRekening(id, rekening);
        return new ResponseEntity(rekening, HttpStatus.OK);
    }
    @CacheEvict(value = "RekeningApi", allEntries = true)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRekening(@Valid @PathVariable("id") Integer id)
    {
        var rekening = rekeningService.getRekening(id);
        if (rekening == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        rekeningService.deleteRekening(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
