package com.example.pki;

import java.util.ArrayList;

public class Zivotinja {
    String naziv;
    String opis;
    int slika;
    ArrayList<Komentar> komentari;

    public Zivotinja(String naziv, String opis, int slika,  ArrayList<Komentar> komentari) {
        this.naziv = naziv;
        this.opis = opis;
        this.slika = slika;
        this.komentari = komentari;
    }

    public Zivotinja(){}

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

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }

    public  ArrayList<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(ArrayList<Komentar> komentari) {
        this.komentari = komentari;
    }
}
