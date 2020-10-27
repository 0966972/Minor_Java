package com.example.demo.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Rekening extends BaseEntity{
    @NotNull
    private Long rekeningnummer;
    @NotNull
    private String iban;
    @NotNull
    @Min(value = 0)
    private float saldo;
    @NotNull
    private boolean geblokkeerd;
    public Rekening merge(Rekening rekeningnieuw)
    {
        this.rekeningnummer = rekeningnieuw.rekeningnummer;
        this.iban = rekeningnieuw.iban;
        this.saldo = rekeningnieuw.saldo;
        this.geblokkeerd = rekeningnieuw.geblokkeerd;
        return this;
    }

    public void setRekeningnummer(Long rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }
}


