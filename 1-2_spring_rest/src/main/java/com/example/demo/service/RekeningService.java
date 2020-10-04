package com.example.demo.service;
import com.example.demo.data.DataRepository;
import com.example.demo.model.Rekening;
import com.example.demo.model.Rekeninghouder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
