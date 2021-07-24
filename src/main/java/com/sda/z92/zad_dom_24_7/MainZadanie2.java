package com.sda.z92.zad_dom_24_7;

import com.sda.z92.zad_dom_24_7.zad2_klasy.Obywatel;
import com.sda.z92.zad_dom_24_7.zad2_klasy.Plec;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainZadanie2 {
    public static void main(String[] args) {
// Stwórz enum Płeć, dodaj do niego dwie możliwe wartości
// stwórz klasę Obywatel z wymaganymi polami
// stwórz konstruktor, metodę toString, gettery i settery
// stwórz klasę main z metodą main
// zadeklaruj scanner
        Scanner scanner = new Scanner(System.in);

        // pobierz od użytkownika imie
        System.out.println("Podaj imie:");
        String imie = scanner.next();

        // pobierz od użytkownika nazwisko
        System.out.println("Podaj nazwisko:");
        String nazwisko = scanner.next();

        // pobierz od użytkownika płeć
        // SPOSÓB 1
        Plec plec = pobierzPlecOdUzytkownika(scanner);

        Obywatel obywatel = new Obywatel(imie, nazwisko, plec);
        System.out.println(obywatel);
        // co należy zaimplementować - toString

        // Jeśli masz wszystkie wymagane informacje to stwórz obiekt Obywatel używając konstruktora
        // użyj sout by wypisać obiekt
    }

    private static Plec pobierzPlecOdUzytkownika(Scanner scanner) {
        // case 4 bez obsługi błędu
        System.out.println("Podaj plec: [KOBIETA, MEZCZYZNA]");
        String plecTekst = scanner.next();
        //  dokonaj konwersji String -> Plec
        // do powyższego użyj valueOf
        Plec plec = Plec.valueOf(plecTekst);
        return plec;
    }

    private static Plec pobierzPlecOdUzytkownika2(Scanner scanner) {
        Plec plec = null;
        do {
            System.out.println("Podaj plec:");
            System.out.println(" 1 = KOBIETA");
            System.out.println(" 2 = MEZCZYZNA");
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    plec = Plec.KOBIETA;
                    break;
                case 2:
                    plec = Plec.MEZCZYZNA;
                    break;
                default:
                    System.out.println("Niepoprawny wybór, powtórz.");
            }

        } while (plec == null);
        return plec;
    }

    private static Plec pobierzPlecOdUzytkownika3(Scanner scanner) {
        Plec plec = null;
        do {
            System.out.println("Podaj plec:");
            System.out.println(" 1 = KOBIETA");
            System.out.println(" 2 = MEZCZYZNA");
            String wybor = scanner.next();

            if (wybor.equalsIgnoreCase("KOBIETA")) {
                plec = Plec.KOBIETA;
            } else if (wybor.equalsIgnoreCase("MEZCZYZNA")) {
                plec = Plec.MEZCZYZNA;
            } else {
                System.out.println("Niepoprawny wybór, powtórz.");
            }

        } while (plec == null);
        return plec;
    }

    private static Plec pobierzPlecOdUzytkownika4(Scanner scanner) {
        Plec plec = null;
        do {
            System.out.println("Podaj plec:");
            // (wypisujemy wszystkie dostepne opcje)
            System.out.println(Arrays.asList(Plec.values()));
            String wybor = scanner.next();
            try {
                plec = Plec.valueOf(wybor.toUpperCase());
            } catch (InputMismatchException ime) {
                System.out.println("Niepoprawny wybór, powtórz.");
            }
        } while (plec == null);
        return plec;
    }
}
