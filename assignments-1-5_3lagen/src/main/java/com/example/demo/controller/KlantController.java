package com.example.demo.controller;


import com.example.demo.dao.Klant;
import com.example.demo.dao.Rekening;
import com.example.demo.dto.KlantDto;
import com.example.demo.dto.RekeningDto;
import com.example.demo.service.KlantService;
import com.example.demo.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("KlantApi")
public class KlantController {
    @Autowired
    KlantService klantService;


    @CacheEvict(value = "KlantApi", allEntries = true)
    @PostMapping
    public ResponseEntity createKlant(@Valid @RequestBody Klant klant, BindingResult result, @RequestHeader("X-Trace-Database-Time") Optional<String> header)
    {
        if (result.hasErrors())
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        klantService.createKlant(klant, header);

        return new ResponseEntity(HttpStatus.OK);
    }
    @Cacheable("KlantApi")
    @GetMapping
    public ResponseEntity<Collection<Klant>> getKlanten(@RequestHeader("X-Trace-Database-Time") Optional<String> header)
    {
        var klanten = klantService.getKlanten(header);
        return new ResponseEntity(klanten, HttpStatus.OK);
    }
    @Cacheable("KlantApi")
    @GetMapping("/{id}")
    public ResponseEntity<Rekening> getKlant(@PathVariable("id") Integer id,@RequestHeader("X-Trace-Database-Time") Optional<String> header){
        var klant = klantService.getKlant(id, header);
        if (klant == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(klant, HttpStatus.OK);
    }
    @CacheEvict(value = "KlantApi", allEntries = true)
    @PutMapping("/{id}")
    public ResponseEntity updateKlant(@Valid @PathVariable("id") Integer id, @RequestBody KlantDto klant, @RequestHeader("X-Trace-Database-Time") Optional<String> header)
    {
        var klant_oud = klantService.getKlant(id, header);
        if (klant_oud == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        klantService.updateKlant(id, klant);
        return new ResponseEntity(klant, HttpStatus.OK);
    }
    @CacheEvict(value = "KlantApi", allEntries = true)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteKlant(@Valid @PathVariable("id") Integer id, @RequestHeader("X-Trace-Database-Time") Optional<String> header)
    {
        var rekening = klantService.getKlant(id, header);
        if (rekening == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        klantService.deleteKlant(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
