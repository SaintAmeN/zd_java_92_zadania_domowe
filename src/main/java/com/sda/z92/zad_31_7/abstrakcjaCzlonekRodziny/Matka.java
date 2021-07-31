package com.sda.z92.zad_31_7.abstrakcjaCzlonekRodziny;

public class Matka extends ICzłonekRodziny {
    public Matka(String imie) {
        super(imie);
    }

    @Override
    public void przedstawSie() {
        System.out.println("I am Your mother, " + imie + " !");
    }

    @Override
    public boolean jestDorosly() {
        return true;
    }
}
