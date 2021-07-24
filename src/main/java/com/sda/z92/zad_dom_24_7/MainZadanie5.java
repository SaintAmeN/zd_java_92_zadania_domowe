package com.sda.z92.zad_dom_24_7;

import com.sda.z92.zad_dom_24_7.zad2_klasy.Plec;
import com.sda.z92.zad_dom_24_7.zad4_klasy.ParaLiczb;
import com.sda.z92.zad_dom_24_7.zad5_klasy.Student;

import java.util.*;

public class MainZadanie5 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(Arrays.asList(
                new Student("100200", "Jan", "Kowalski", Plec.MEZCZYZNA),
                new Student("100201", "Marian", "Kowalski", Plec.MEZCZYZNA),
                new Student("100202", "Lukasz", "Podkladka", Plec.MEZCZYZNA),
                new Student("100203", "Asia", "Rosol", Plec.KOBIETA),
                new Student("100204", "Basia", "Kubek", Plec.KOBIETA),
                new Student("100205", "Tosia", "Lyzka", Plec.KOBIETA),
                new Student("100206", "Zosia", "Myszka", Plec.KOBIETA),
                new Student("100207", "Piotr", "Dlugopis", Plec.MEZCZYZNA),
                new Student("100400", "Jan", "Nowak", Plec.MEZCZYZNA)
        ));

        // zad A
        System.out.println("Sout na obiekcie list: " + list);

        // zad B
        for (Student student : list) {
            System.out.println(student);
        }

        // zad C
        System.out.println("Kobiety:");
        for (Student student : list) {
            if (student.getPlec() == Plec.KOBIETA) {
                System.out.println(student);
            }
        }

        // zad D
        System.out.println("Mezczyzni:");
        for (Student student : list) {
            if (student.getPlec() == Plec.MEZCZYZNA) {
                System.out.println(student);
            }
        }

        // zad E
        System.out.println("Indeksy:");
        for (Student student : list) {
            System.out.println(student.getNrIndeksu());
        }

    }
}
