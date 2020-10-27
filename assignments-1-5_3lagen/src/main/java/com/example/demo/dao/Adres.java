package com.example.demo.dao;

import javax.persistence.Embeddable;

@Embeddable
public class Adres {
    private String straat;
    private String huisnummer;
    private String postcode;
    private String plaats;
    private String land;
}
