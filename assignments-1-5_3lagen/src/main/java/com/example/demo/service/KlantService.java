package com.example.demo.service;

import com.example.demo.dao.Klant;
import com.example.demo.dto.KlantDto;
import com.example.demo.repository.KlantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class KlantService {
    @Autowired
    KlantRepository klantRepository;

    @Autowired
    ModelMapper modelMapper;


    @Transactional
    public void createKlant(Klant klant, Optional<String> header) {
        if(header.get().equals("X-Trace-Database-Time"))
        {
            long start = System.currentTimeMillis();
            klantRepository.save(klant);
            long timeTaken = System.currentTimeMillis() - start;
            System.out.println(timeTaken);
        }
        klantRepository.save(klant);

    }

    @Transactional
    public Klant getKlant(Integer klantid, Optional<String> header)
    {
        if(header.get().equals("X-Trace-Database-Time")) {
            long start = System.currentTimeMillis();
            Optional<Klant> klant = klantRepository.findById(klantid);
            long timeTaken = System.currentTimeMillis() - start;
            System.out.println("getKlant took " + timeTaken + " ms");
            return klant.orElse(null);
        }
        Optional<Klant> klant = klantRepository.findById(klantid);
        return klant.orElse(null);
    }

    @Transactional
    public Collection<Klant> getKlanten(Optional<String> header)
    {
        if(header.get().equals("X-Trace-Database-Time")) {
            long start = System.currentTimeMillis();
            Collection<Klant> klanten = klantRepository.findAll();
            long timeTaken = System.currentTimeMillis() - start;
            System.out.println(timeTaken);
            return klanten;
        }
        Collection<Klant> klanten = klantRepository.findAll();
        return klanten;
    }
    @Transactional
    public void updateKlant(Integer id, KlantDto klant) {
        long start = System.currentTimeMillis();
        Klant mappedklant = modelMapper.map(klant, Klant.class);
        klantRepository.save(mappedklant);
        Optional<Klant> klant_oud = klantRepository.findById(id);
        klant_oud.ifPresent(Klant -> Klant.merge(mappedklant));
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println(timeTaken);
    }
    @Transactional
    public void deleteKlant(Integer id) {
        long start = System.currentTimeMillis();
        klantRepository.deleteById(id);
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println(timeTaken);
    }
}
