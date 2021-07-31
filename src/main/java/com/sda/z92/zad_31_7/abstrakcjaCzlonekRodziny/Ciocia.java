package com.sda.z92.zad_31_7.abstrakcjaCzlonekRodziny;

public class Ciocia extends ICzłonekRodziny{
    public Ciocia(String imie) {
        super(imie);
    }

    @Override
    public boolean jestDorosly() {
        return true;
    }
}
