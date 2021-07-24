package com.sda.z92.zad_dom_24_7.zad6_klasy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posilek {
    private int kcal;
    private String nazwa;
    private RodzajPosilku rodzajPosilku;
    private double cena;

}
