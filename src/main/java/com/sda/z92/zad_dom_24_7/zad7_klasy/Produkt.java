package com.sda.z92.zad_dom_24_7.zad7_klasy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produkt {
    private String nazwa;
    private double cenaNetto;
    private PodatekProduktu podatek;

    public double obliczCeneBrutto() {
        return cenaNetto * (1 + podatek.getPodatek());
    }
}
