package com.sda.z92.zad_dom_24_7.zad2_klasy;

import lombok.*;

// POJO - Plain Old Java Object
//  Wymagania takiego obiektu/klasy:
//      - prywatne pola
//      - gettery i settery do wszystkich pól (edytowalnych)
//      - pusty konstruktor
//
// @Setter @Getter @ToString @EqualsAndHashCode @RequiredArgsConstructor
@Data
@NoArgsConstructor      // konstruktor bez parametrów
@AllArgsConstructor     // konstruktor ze wszystkimi parametrami
public class Obywatel {
    private String imie;
    private String nazwisko;
    private Plec plec;
    // ALT + INSERT => generowanie konstruktorów, getterów, setterów
}
