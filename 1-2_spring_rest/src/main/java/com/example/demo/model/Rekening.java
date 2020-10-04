package com.example.demo.model;
import java.util.ArrayList;
import java.util.List;
public class Rekening {
    private static long count = 0;
    private long id;
    private String IBAN;
    private long Saldo;
    private boolean Geblokkeerd;
    private List<Rekeninghouder> Rekeninghouders = new ArrayList<Rekeninghouder>();

    public Rekening(String iban, long saldo)
    {
        this.id = count;
        this.IBAN = iban;
        this.Saldo = saldo;
        this.Geblokkeerd = false;
        count++;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setSaldo(long saldo) {
        Saldo = saldo;
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

    public boolean isGeblokkeerd() {
        return Geblokkeerd;
    }

    public void setGeblokkeerd(boolean geblokkeerd) {
        Geblokkeerd = geblokkeerd;
    }

    public List<Rekeninghouder> getRekeninghouders() {
        return Rekeninghouders;
    }

    public void addRekeninghouder(Rekeninghouder rekeninghouder)
    {
        Rekeninghouders.add(rekeninghouder);
    }
}
