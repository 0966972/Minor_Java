package com.example.assignments._3lagen.service;

import com.example.assignments._3lagen.dao.Klant;
import com.example.assignments._3lagen.dao.Rekening;
import com.example.assignments._3lagen.dto.KlantDto;
import com.example.assignments._3lagen.dto.RekeningDto;
import com.example.assignments._3lagen.repository.KlantRepository;
import com.example.assignments._3lagen.repository.RekeningRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class RekeningService {
    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    ModelMapper modelMapper;

    public Collection<Rekening> getALL() {
        return rekeningRepository.findAll();
    }

    public Rekening create(RekeningDto rekening) {
        Rekening rekening1 = modelMapper.map(rekening, Rekening.class);
        return rekeningRepository.save(rekening1);
    }
}
