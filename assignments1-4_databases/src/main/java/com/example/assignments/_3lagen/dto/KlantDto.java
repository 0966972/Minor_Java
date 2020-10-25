package com.example.assignments._3lagen.dto;

import com.example.assignments._3lagen.dao.Gender;
import com.example.assignments._3lagen.dao.Rekening;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class KlantDto extends BaseEntityDto {
    private String naam;
    private Gender gender;
    private LocalDate geboortedatum;
    @ManyToMany(mappedBy = "klanten", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    Set<Rekening> rekeningen;
}
