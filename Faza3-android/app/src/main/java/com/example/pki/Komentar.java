package com.example.pki;

public class Komentar {

    String tekst;
    String korIme;

    public Komentar(String tekst, String korIme) {
        this.tekst = tekst;
        this.korIme = korIme;
    }

    public Komentar() {

    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }
}
