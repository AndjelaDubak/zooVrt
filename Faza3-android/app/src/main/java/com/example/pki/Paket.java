package com.example.pki;

public class Paket {
    String naziv;
    String opis;
    String cena;
    int slika;

    public Paket(String naziv, String opis, String cena, int slika) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.slika = slika;
    }

    public Paket() {}

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

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }
}
