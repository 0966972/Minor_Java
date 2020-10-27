package com.example.demo.service;

import com.example.demo.dao.Klant;
import com.example.demo.dao.Rekening;
import com.example.demo.dto.KlantDto;
import com.example.demo.dto.RekeningDto;
import com.example.demo.repository.KlantRepository;
import com.example.demo.repository.RekeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import org.modelmapper.ModelMapper;


@Service
public class RekeningService {
    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    KlantRepository klantRepository;

    @Autowired
    ModelMapper modelMapper;


    @Transactional
    public void createRekening(RekeningDto rekening) {
        Rekening mappedRekening = modelMapper.map(rekening, Rekening.class);
        mappedRekening.setRekeningnummer(rekeningRepository.getMaxId() + 1);
        long start = System.currentTimeMillis();
        rekeningRepository.save(mappedRekening);
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println(timeTaken);
    }

    @Transactional
    public Rekening getRekening(Integer rekeningid)
    {
        long start = System.currentTimeMillis();
        Optional<Rekening> rekening = rekeningRepository.findById(rekeningid);
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println(timeTaken);
        return rekening.orElse(null);
    }

    @Transactional
    public Collection<Rekening> getRekeningen()
    {
        long start = System.currentTimeMillis();
        Collection<Rekening> rekeningen = rekeningRepository.findAll();
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println(timeTaken);
        return rekeningen;
    }

    @Transactional
    public void updateRekening(Integer id, Rekening rekening) {
        long start = System.currentTimeMillis();
        Optional<Rekening> rekening_oud = rekeningRepository.findById(id);
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("updateRekening took " + timeTaken + " ms");
        rekening_oud.ifPresent(Rekening -> Rekening.merge(rekening));
    }
    @Transactional
    public void deleteRekening(Integer id) {
        long start = System.currentTimeMillis();
        rekeningRepository.deleteById(id);
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("deleteRekening took " + timeTaken + " ms");
    }



}
