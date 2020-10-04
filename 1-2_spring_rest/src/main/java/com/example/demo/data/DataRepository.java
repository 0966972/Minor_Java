package com.example.demo.data;

import com.example.demo.model.Rekening;
import com.example.demo.model.Rekeninghouder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DataRepository {
    public final Map<Integer, Rekening> _rekeningen;
    public final Map<Integer, Rekeninghouder> _rekeninghouder;

    public DataRepository()
    {
        _rekeningen = new HashMap<>();
        _rekeninghouder = new HashMap<>();
    }

    public Map<Integer, Rekening> get_rekeningen() {
        return _rekeningen;
    }

    public Map<Integer, Rekeninghouder> get_rekeninghouder() {
        return _rekeninghouder;
    }

    public void saveRekening(Rekening rekening){
        _rekeningen.put(null,rekening);
    }


}
