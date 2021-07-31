package com.sda.z92.zad_31_7.abstrakcjazolniez;

public class Żołnierz extends Osoba {
    private Ranga ranga;

    public Żołnierz(String imie, String nazwisko, Ranga ranga) {
        super(imie, nazwisko);
        this.ranga = ranga;
    }

    @Override
    public void przedstawSie() {
        System.out.println("Tu " + imie + " " + nazwisko + ", " + ranga.getNazwa() + " Polskich sił zbrojnych!");
    }
}
