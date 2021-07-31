package com.sda.z92.zad_31_7.abstrakcjazolniez;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie:");
        String imie = scanner.nextLine();

        System.out.println("Podaj nazwisko:");
        String nazwisko = scanner.nextLine();

        System.out.println("Czy jesteś żołnierzem?");
        String odpowiedz = scanner.nextLine();

        Osoba osoba;
        if (odpowiedz.toUpperCase().contains("TAK") || odpowiedz.toUpperCase().contains("YES") ||
                "y".equalsIgnoreCase(odpowiedz) || "t".equalsIgnoreCase(odpowiedz)) {
            // jest żołnierzem

            Ranga ranga = null;
            do {
                try {
                    System.out.println("Podaj swoją rangę:");
                    String rangaString = scanner.nextLine();
                    ranga = Ranga.valueOf(rangaString);
                } catch (IllegalArgumentException iae) {
                    System.err.println("Błąd, wprowadź ponownie.");
                }
            }while (ranga == null);

            osoba = new Żołnierz(imie, nazwisko, ranga);
        } else {
            // nie jest żołnierzem
            osoba = new Cywil(imie, nazwisko);
        }

        osoba.przedstawSie();
    }
}
