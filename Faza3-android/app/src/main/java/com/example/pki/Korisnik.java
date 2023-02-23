package com.example.pki;

import java.util.List;

public class Korisnik {

    private String ime;
    private String prezime;
    private String korIme;
    private String lozinka;
    private String telefon;
    private String adresa;
    private String email;
    private String tip;
    private List<Obavestenje> obavestenja;

    public Korisnik() {

    }

    public Korisnik(String ime, String prezime, String korIme, String lozinka, String telefon, String adresa, String email, String tip, List<Obavestenje> obavestenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.korIme = korIme;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.adresa = adresa;
        this.email = email;
        this.tip = tip;
        this.obavestenja = obavestenja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public List<Obavestenje> getObavestenja() {
        return obavestenja;
    }

    public void setObavestenja(List<Obavestenje> obavestenja) {
        this.obavestenja = obavestenja;
    }
}
