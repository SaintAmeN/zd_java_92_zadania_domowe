package com.sda.z92.zad_dom_24_7;

import com.sda.z92.zad_dom_24_7.zad7_klasy.Komendy;
import com.sda.z92.zad_dom_24_7.zad7_klasy.KoszykProduktów;
import com.sda.z92.zad_dom_24_7.zad7_klasy.PodatekProduktu;
import com.sda.z92.zad_dom_24_7.zad7_klasy.Produkt;

import java.util.Optional;
import java.util.Scanner;

public class MainZadanie7Cmd {
    // main do testowania działania
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KoszykProduktów koszykProduktów = new KoszykProduktów();

        String komenda;
        boolean uruchomiony = true;
        do {
            // użytkownik może wpisać więcej niż jedno słowo które my przetworzymy
            System.out.println("Podaj kolejną komendę:");
            komenda = scanner.nextLine();

            String[] elementyKomendy = komenda.split(" ");
            String akcja = elementyKomendy[0];

            if (akcja.equalsIgnoreCase(Komendy.CENA_BRUTTO)) {
                System.out.println("Cena brutto: " + koszykProduktów.podsumujRachunekBrutto());


            } else if (akcja.equalsIgnoreCase(Komendy.CENA_NETTO)) {
                System.out.println("Cena netto: " + koszykProduktów.podsumujRachunekNetto());


            } else if (akcja.equalsIgnoreCase(Komendy.PODATEK)) {
                System.out.println("Wartosc podatku: " + koszykProduktów.zwrocWartoscPodatku());


            } else if (akcja.equalsIgnoreCase(Komendy.PRODUKTY)) {
                koszykProduktów.wypiszRachunek();

            } else if (akcja.equalsIgnoreCase(Komendy.DODAJ_PRODUKT)) {
                Optional<Produkt> optionalProdukt = obsługaDodajProdukt(elementyKomendy);
                if (optionalProdukt.isPresent()) {
                    System.out.println("Dodano produkt");
                    koszykProduktów.dodajProdukt(optionalProdukt.get());
                } else {
                    System.out.println("Nie dodano produktu");
                }
            } else if (komenda.equalsIgnoreCase(Komendy.QUIT)) {
                System.out.println("Zamykam program.");
                uruchomiony = false;
            }
        } while (uruchomiony);

        System.out.println("Opuszczam pętlę.");
    }

    private static Optional<Produkt> obsługaDodajProdukt(String[] elementyKomendy) {
        // dodaj / maslo / 2.3 / VAT8
        if (elementyKomendy.length != 4) {
            // nie zwracamy produktu jeżeli nie mamy dostatecznej ilości parametrów
            System.err.println("Niedostateczna ilosc parametrow!");
            return Optional.empty();
        }
        String nazwa = elementyKomendy[1];

        Optional<Double> cenaOptional = przetworzTekstNaCene(elementyKomendy[2]);
        if (!cenaOptional.isPresent()) {
            return Optional.empty();
        }

        Optional<PodatekProduktu> podatekProduktu = przetworzTekstNaPodatek(elementyKomendy[3]);
        if (!podatekProduktu.isPresent()) {
            return Optional.empty();
        }

        Produkt produkt = new Produkt(nazwa,
                cenaOptional.get(),
                podatekProduktu.get());

        return Optional.of(produkt);
    }

    public static Optional<PodatekProduktu> przetworzTekstNaPodatek(String komenda) {
        PodatekProduktu podatekProduktu;
        try {
            // przetwarzanie tekstu na podatek
            podatekProduktu = PodatekProduktu.valueOf(komenda.toUpperCase());
        } catch (IllegalArgumentException iae) {
            System.err.println("Niepoprawna wartość podatku produktu!");
            return Optional.empty();
        }
        return Optional.of(podatekProduktu);
    }

    public static Optional<Double> przetworzTekstNaCene(String komenda) {
        Double cena;
        try {
            // przetworzenie tekstu na double
            cena = Double.parseDouble(komenda);
        } catch (NumberFormatException nfe) {
            System.err.println("Niepoprawna wartość ceny!");
            return Optional.empty();
        }
        return Optional.of(cena);
    }
}
