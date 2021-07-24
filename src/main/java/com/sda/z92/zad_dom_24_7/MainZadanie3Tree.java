package com.sda.z92.zad_dom_24_7;

import com.sda.z92.zad_dom_24_7.zad3_klasy.Student;

import java.util.*;

public class MainZadanie3Tree {
    public static void main(String[] args) {
        Student s10 = new Student(100200, "Jan", "Kowalski");
        Student s11 = new Student(100201, "Marian", "Kowalski");
        Student s12 = new Student(100202, "Lukasz", "Podkladka");
        Student s13 = new Student(100203, "Asia", "Rosol");
        Student s14 = new Student(100204, "Basia", "Kubek");
        Student s15 = new Student(100205, "Tosia", "Lyzka");
        Student s16 = new Student(100206, "Zosia", "Myszka");
        Student s17 = new Student(100207, "Piotr", "Dlugopis");
        Student s20 = new Student(100400, "Jan", "Nowak");

        Map<Long, Student> mapa = new TreeMap<>(Comparator.reverseOrder());
        mapa.put(s10.getNumerIndeksu(), s10);
        mapa.put(s11.getNumerIndeksu(), s11);
        mapa.put(s15.getNumerIndeksu(), s15);
        mapa.put(s12.getNumerIndeksu(), s12);
        mapa.put(s14.getNumerIndeksu(), s14);
        mapa.put(s16.getNumerIndeksu(), s16);
        mapa.put(s13.getNumerIndeksu(), s13);
        mapa.put(s17.getNumerIndeksu(), s17);
        mapa.put(s20.getNumerIndeksu(), s20);

        // sprawdzenie czy zawiera studenta
        // dopasowanie typów (dopisujemy Long, ponieważ kluczem jest Long)
        if (mapa.containsKey(100200L)) {
            System.out.println("Zawiera studenta o indeksie 100200");
        } else {
            System.out.println("Nie zawiera studenta o indeksie 100200");
        }

        // wypisz studenta o indeksie 100400
        System.out.println("Student o indeksie 100400: " + mapa.get(100400L));

        System.out.println("");
        for (Student wartoscStudentZMapy : mapa.values()) {
            System.out.println(wartoscStudentZMapy);
        }

        System.out.println("");
        for (Long wartoscKluczZMapy : mapa.keySet()) {
            System.out.println(wartoscKluczZMapy);
        }
    }
}
