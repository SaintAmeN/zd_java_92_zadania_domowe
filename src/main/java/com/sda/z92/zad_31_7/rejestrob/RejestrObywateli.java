package com.sda.z92.zad_31_7.rejestrob;

import java.util.*;
import java.util.stream.Collectors;

public class RejestrObywateli {
    private Map<String, Obywatel> obywatelMap;

    public RejestrObywateli() {
        this.obywatelMap = new HashMap<>();
    }

    //- dodajObywatela(String pesel, String imie, String nazwisko):void
    public void dodajObywatela(String imie , String nazwisko, String pesel) {
        Obywatel o = new Obywatel(imie, nazwisko, pesel);
        obywatelMap.put(pesel, o);
    }

    //- znajdźObywateliUrodzonychPrzed(int rok):List<Obywatel>
    public List<Obywatel> znajdzObywateliUrodzonychPrzed(int rok) {
        return obywatelMap.values().stream()
                .filter(obywatel -> {
                    String pesel = obywatel.getPesel();
                    int rokUrodzenia = Integer.parseInt(pesel.substring(0, 2));
                    return rokUrodzenia < rok;
                })
                .collect(Collectors.toList());
    }

    //- znajdźObywateliZRokuZImieniem(int rok, String imie):List<Obywatel>
    public List<Obywatel> znajdźObywateliZRokuZImieniem(int rok, String imie) {
        return obywatelMap.values().stream()
                .filter(obywatel -> {
                    String pesel = obywatel.getPesel();
                    int rokUrodzenia = Integer.parseInt(pesel.substring(0, 2));
                    return rokUrodzenia < rok;
                })
                .filter(obywatel -> obywatel.getImie().equalsIgnoreCase(imie))
                .collect(Collectors.toList());
    }

    //- znajdźObywatelaPoNazwisku(String nazwisko):List<Obywatel>
    public List<Obywatel> znajdźObywatelaPoNazwisku(String nazwisko) {
        return obywatelMap.values().stream()
                .filter(obywatel -> obywatel.getNazwisko().equalsIgnoreCase(nazwisko))
                .collect(Collectors.toList());
    }

    //- znajdźObywatelaPoPeselu(String pesel):Obywatel
    public Optional<Obywatel> znajdźObywatelaPoPeselu(String pesel) {
        return obywatelMap.values().stream()
                .filter(obywatel -> obywatel.getPesel().equalsIgnoreCase(pesel))
                .findFirst();
    }

}
