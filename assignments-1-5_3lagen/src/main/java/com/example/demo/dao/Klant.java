package com.example.demo.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Klant extends BaseEntity{

    private String naam;
    private Geslacht geslacht;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "huisnummer", column = @Column(name = "HUISNUMMER"))
    })
    private Adres adres;
    public Klant merge(Klant klantnieuw)
    {
        this.naam = klantnieuw.naam;
        this.geslacht = klantnieuw.geslacht;
        this.adres = klantnieuw.adres;
        return this;
    }
}
