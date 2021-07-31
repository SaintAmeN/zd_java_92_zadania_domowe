package com.sda.z92.zad_31_7.abstrakcjaCzlonekRodziny;

public abstract class ICzłonekRodziny {
    protected String imie;

    public ICzłonekRodziny(String imie) {
        this.imie = imie;
    }

    public void przedstawSie(){
        System.out.println("I am just a simple family member");
    }

    public abstract boolean jestDorosly();
}
