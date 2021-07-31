package com.sda.z92.zad_31_7.abstrakcjazolniez;

public abstract class Osoba {
    protected String imie;
    protected String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public abstract void przedstawSie();
}
