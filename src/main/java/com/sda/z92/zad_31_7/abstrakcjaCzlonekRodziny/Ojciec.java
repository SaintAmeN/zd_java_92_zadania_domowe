package com.sda.z92.zad_31_7.abstrakcjaCzlonekRodziny;

public class Ojciec extends ICzłonekRodziny {
    public Ojciec(String imie) {
        super(imie);
    }

    @Override
    public void przedstawSie() {
        System.out.println("I am " + imie + " Your father!");
    }

    @Override
    public boolean jestDorosly() {
        return true;
    }
}
