package com.example.assignments._3lagen.dto;


import com.example.assignments._3lagen.dao.Klant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class RekeningDto extends BaseEntityDto {
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
