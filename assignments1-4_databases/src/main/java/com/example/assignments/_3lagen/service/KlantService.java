package com.example.assignments._3lagen.service;
import com.example.assignments._3lagen.dao.Klant;
import com.example.assignments._3lagen.dto.KlantDto;
import com.example.assignments._3lagen.repository.KlantRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class KlantService {

    @Autowired
    KlantRepository klantRepository;

    @Autowired
    ModelMapper modelMapper;

    public Collection<Klant> getALL()
    {
        return klantRepository.findAll();
    }

    public Klant create(KlantDto klant){
        Klant klant1 = modelMapper.map(klant, Klant.class);
        return klantRepository.save(klant1);
    }

}
