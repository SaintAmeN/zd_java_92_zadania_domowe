package com.sda.z92.zad_dom_24_7;

import com.sda.z92.zad_dom_24_7.zad8_klasy.BrakOcenStudentaException;
import com.sda.z92.zad_dom_24_7.zad8_klasy.Dziennik;
import com.sda.z92.zad_dom_24_7.zad8_klasy.Student;

import java.util.ArrayList;

public class MainZadanie8 {
    public static void main(String[] args) {
        Dziennik dziennik = new Dziennik();

        dziennik.dodajStudenta(new Student("Marian", "Nowak", "1234", new ArrayList<>()));
        dziennik.dodajStudenta(new Student("Marian", "Kowalski", "1239", new ArrayList<>()));
        dziennik.dodajStudenta(new Student("Marian", "Skalski", "1034", new ArrayList<>()));

        dziennik.dodajOcene("1235", 3.0);

        System.out.println(dziennik.sortujPoIndeksie());

        dziennik.dodajOcene("1234", 3.0);
        dziennik.dodajOcene("1234", 4.0);
        dziennik.dodajOcene("1239", 2.0);

        try {
            System.out.println(dziennik.podajSredniaStudenta("1234"));
            System.out.println(dziennik.podajSredniaStudenta("1239"));
            System.out.println(dziennik.podajSredniaStudenta("1034"));
        } catch (BrakOcenStudentaException e) {
            System.out.println("Mieliśmy błąd, 1034 nie ma ocen");
        }

        System.out.println(dziennik.podajStudentowZagrozonych());
    }
}
