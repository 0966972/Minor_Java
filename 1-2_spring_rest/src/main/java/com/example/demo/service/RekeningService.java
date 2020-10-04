package com.example.demo.service;
import com.example.demo.data.DataRepository;
import com.example.demo.model.Rekening;
import com.example.demo.model.Rekeninghouder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Service
public class RekeningService {
    @Autowired
    DataRepository _dataRepository;

    public void saveRekeninghouder(Rekeninghouder rekeninghouder){
        Integer id = rekeninghouder.getId();
        _dataRepository._rekeninghouder.put(id ,rekeninghouder);
    }

    public Rekeninghouder Getrekeninghouder(Integer id)
    {
        return _dataRepository._rekeninghouder.get(id);
    }

    public void AddRekening(Integer id, Rekening Rekening)
    {
        _dataRepository._rekeninghouder.get(id).addRekening(Rekening);
    }
    public List<Rekening> GetRekeningenKlant(Integer id)
    {
        var a = _dataRepository._rekeninghouder.get(id).getRekening();
        System.out.println(a);
        return a;
    }
    public ResponseEntity updateRekening(Integer id, Integer rekeningid, Rekening update)
    {
        var a = _dataRepository._rekeninghouder.get(id).getRekening();
        var c = a.stream().filter(r -> r.getId() == rekeningid).findFirst().orElse(null);
        if (c == null)
        {
            throw new NotFound();
        }
        else {
            c.setSaldo(update.getSaldo());
            c.setIBAN(update.getIBAN());
            c.setGeblokkeerd(update.isGeblokkeerd());
            return ResponseEntity.ok(HttpStatus.OK);
        }
    }

    public ResponseEntity verwijderRekening(Integer id, Integer rekeningid, Rekening update)
    {
        var a = _dataRepository._rekeninghouder.get(id).getRekening();
        var c = a.stream().filter(r -> r.getId() == rekeningid).findFirst().orElse(null);
        if (c == null)
        {
            throw new NotFound();
        }
        else {
            _dataRepository._rekeninghouder.get(id).getRekening().remove(c);
            return ResponseEntity.ok(HttpStatus.OK);
        }
    }

}

