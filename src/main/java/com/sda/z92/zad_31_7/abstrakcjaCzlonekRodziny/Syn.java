package com.sda.z92.zad_31_7.abstrakcjaCzlonekRodziny;

public class Syn extends ICzłonekRodziny {
    public Syn(String imie) {
        super(imie);
    }

    @Override
    public void przedstawSie() {
        System.out.println("Who's asking? I'm " + imie);
    }

    @Override
    public boolean jestDorosly() {
        return false;
    }
}
