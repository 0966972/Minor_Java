package com.example.demo.model;



import java.util.ArrayList;
import java.util.List;

public class Rekeninghouder {

    private static Integer count = 0;
    private Integer id;
    private String Voornaam;
    private String Achternaam;
    private List<Rekening> Rekening = new ArrayList<Rekening>();

    public Rekeninghouder(String voornaam, String achternaam)
    {
        this.id = count;
        this.Voornaam = voornaam;
        this.Achternaam = achternaam;
        count++;
        System.out.println("id="+id+" voornaam="+Voornaam+" achternaam="+Achternaam);
    }


    public Integer getId() {
        return id;
    }

    public String getVoornaam() {
        return Voornaam;
    }

    public String getAchternaam() {
        return Achternaam;
    }

    public void addRekening(Rekening rekening)
    {
        Rekening.add(rekening);
    }

    public List<Rekening> getRekening() {return Rekening;}
}
