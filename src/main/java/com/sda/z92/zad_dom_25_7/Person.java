package com.sda.z92.zad_dom_25_7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String imie;
    private String nazwisko;
    private int wiek;
    private boolean mezczyzna;
}
