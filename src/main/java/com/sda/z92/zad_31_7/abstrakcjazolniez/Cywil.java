package com.sda.z92.zad_31_7.abstrakcjazolniez;

public class Cywil extends Osoba {

    public Cywil(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void przedstawSie() {
        System.out.println("Tu " + imie + " " + nazwisko + ", jestem obywatelem Polskim!");
    }
}
