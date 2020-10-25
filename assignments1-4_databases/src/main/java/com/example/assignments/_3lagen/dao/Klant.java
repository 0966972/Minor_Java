package com.example.assignments._3lagen.dao;
import com.example.assignments._3lagen.dao.Rekening;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Klant extends BaseEntity{
    private String naam;
    private Gender gender;
    private LocalDate geboortedatum;
    @ManyToMany(mappedBy = "klanten", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    Set<Rekening> rekeningen;
}

