package com.example.pki;

import java.util.ArrayList;

public class Dogadjaj {

    String naziv;
    String opis;
    int brLajkova;
    int slika;
    ArrayList<String> lajkovali;

    public Dogadjaj(String naziv, String opis, int brLajkova, int slika, ArrayList<String> lajkovali) {
        this.naziv = naziv;
        this.opis = opis;
        this.brLajkova = brLajkova;
        this.slika = slika;
        this.lajkovali = lajkovali;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getBrLajkova() {
        return brLajkova;
    }

    public void setBrLajkova(int brLajkova) {
        this.brLajkova = brLajkova;
    }

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }

    public ArrayList<String> getLajkovali() {
        return lajkovali;
    }

    public void setLajkovali(ArrayList<String> lajkovali) {
        this.lajkovali = lajkovali;
    }
}
