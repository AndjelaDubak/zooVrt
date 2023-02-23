package com.example.pki;

public class Obavestenje {

    private String opis;
    private String datum;
    private String vreme;

    public Obavestenje(String opis, String datum, String vreme) {
        this.opis = opis;
        this.datum = datum;
        this.vreme = vreme;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }
}
