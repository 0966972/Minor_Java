package com.example.assignments._3lagen.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Rekening extends BaseEntity {
    private String rekeningnummer;
    private double saldo;
    private Boolean geblokkeerd;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "rekening_klanten",
            joinColumns = @JoinColumn(name = "rekening_id"),
            inverseJoinColumns = @JoinColumn(name = "klant_id"))
    Set<Klant> klanten;
}