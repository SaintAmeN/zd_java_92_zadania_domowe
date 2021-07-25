package com.sda.z92.zad_dom_24_7.zad7_klasy;

public enum PodatekProduktu {
    VAT_8(0.08),
    VAT_23(0.23),
    VAT_5(0.05),
    NO_VAT(0.00);

    private final double podatek;

    PodatekProduktu(double podatek) {
        this.podatek = podatek;
    }

    public double getPodatek() {
        return podatek;
    }
}
