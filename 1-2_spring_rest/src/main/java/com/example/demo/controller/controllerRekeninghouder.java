package com.example.demo.controller;

import com.example.demo.model.Rekening;
import com.example.demo.model.Rekeninghouder;
import com.example.demo.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")

public class controllerRekeninghouder {

    @Autowired
    RekeningService _rekeningService;

    @PostMapping
    public ResponseEntity createRekeningHouder(@RequestBody Rekeninghouder rekeninghouder) {
        _rekeningService.saveRekeninghouder(rekeninghouder);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity addRekening(@PathVariable("id") Integer id, @RequestBody Rekening rekening) {
        _rekeningService.AddRekening(id,rekening);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rekeninghouder> getKlant(@PathVariable("id") Integer id)
    {
        Rekeninghouder a = _rekeningService.Getrekeninghouder(id);
        return ResponseEntity.ok().body(a);
    }
    @GetMapping("/{id}/rekening")
    public ResponseEntity<List<Rekening>> getRekening(@PathVariable("id") Integer id)
    {
        List<Rekening> a = _rekeningService.GetRekeningenKlant(id);
        return ResponseEntity.ok().body(a);
    }
    @PutMapping("/{id}/rekening/{rekeningid}")
    public ResponseEntity blokkeerrekening(@PathVariable("id") Integer id, @PathVariable("rekeningid") Integer rekeningid, @RequestBody Rekening rekening){
        return _rekeningService.updateRekening(id,rekeningid,rekening);

    }
    @DeleteMapping("/{id}/rekening/{rekeningid}")
    public ResponseEntity verwijderdrekening(@PathVariable("id") Integer id, @PathVariable("rekeningid") Integer rekeningid, @RequestBody Rekening rekening){
        return _rekeningService.verwijderRekening(id, rekeningid, rekening);
    }





}
