package com.example.demo.model;
import java.util.ArrayList;
import java.util.List;

public class Rekening {
    private static long count = 0;
    private long id;
    private String IBAN;
    private long Saldo;
    private List<Rekeninghouder> Rekeninghouders = new ArrayList<Rekeninghouder>();

    public Rekening(String iban, long saldo)
    {
        this.id = count;
        this.IBAN = iban;
        this.Saldo = saldo;
        count++;
    }

    public long getId() {
        return id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public long getSaldo() {
        return Saldo;
    }

    public List<Rekeninghouder> getRekeninghouders() {
        return Rekeninghouders;
    }

    public void addRekeninghouder(Rekeninghouder rekeninghouder)
    {
        Rekeninghouders.add(rekeninghouder);
    }
}
