package com.sda.z92.zad_31_7.abstrakcjaCzlonekRodziny;

public class Córka extends ICzłonekRodziny {
    public Córka(String imie) {
        super(imie);
    }

    @Override
    public void przedstawSie() {
        System.out.println("I am Your daughter! I am " + imie);
    }

    @Override
    public boolean jestDorosly() {
        return false;
    }
}
