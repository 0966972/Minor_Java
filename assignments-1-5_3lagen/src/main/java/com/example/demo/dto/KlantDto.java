package com.example.demo.dto;

import com.example.demo.dao.Adres;
import com.example.demo.dao.Geslacht;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class KlantDto {
    private String naam;
    private Geslacht geslacht;

    private AdresDto adres;
}
