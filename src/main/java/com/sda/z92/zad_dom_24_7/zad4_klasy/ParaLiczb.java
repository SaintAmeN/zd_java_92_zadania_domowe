package com.sda.z92.zad_dom_24_7.zad4_klasy;

import java.util.Objects;

public class ParaLiczb {
    private int liczbaA;
    private int liczbaB;

    public ParaLiczb(int liczbaA, int liczbaB) {
        this.liczbaA = liczbaA;
        this.liczbaB = liczbaB;
    }

    @Override
    public String toString() {
        return "ParaLiczb{" +
                "liczbaA=" + liczbaA +
                ", liczbaB=" + liczbaB +
                '}';
    }
}
