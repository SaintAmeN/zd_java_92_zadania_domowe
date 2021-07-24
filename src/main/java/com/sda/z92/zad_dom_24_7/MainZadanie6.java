package com.sda.z92.zad_dom_24_7;

import com.sda.z92.zad_dom_24_7.zad2_klasy.Plec;
import com.sda.z92.zad_dom_24_7.zad5_klasy.Student;
import com.sda.z92.zad_dom_24_7.zad6_klasy.Posilek;
import com.sda.z92.zad_dom_24_7.zad6_klasy.RodzajPosilku;

import java.util.*;

public class MainZadanie6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jakies \"slowo\" w cudzyslowiu");
        List<Posilek> list = new ArrayList<>(Arrays.asList(
                new Posilek(642, "Sirloin", RodzajPosilku.STEAK, 23.0),
                new Posilek(123, "Margheritta", RodzajPosilku.PIZZA, 13.3),
                new Posilek(123, "Konczitta", RodzajPosilku.PIZZA, 13.3),
                new Posilek(132, "Hawajska", RodzajPosilku.PIZZA, 19.99),
                new Posilek(132, "Farmerska", RodzajPosilku.PIZZA, 19.99),
                new Posilek(132, "Wiejska", RodzajPosilku.PIZZA, 19.99),
                new Posilek(231, "Ribeye", RodzajPosilku.STEAK, 31.1),
                new Posilek(13, "Bleh", RodzajPosilku.SALATKA, 23.50),
                new Posilek(14, "Fu", RodzajPosilku.SALATKA, 29.50)
        ));

        System.out.println("Dostępne produkty to:");
        for (Posilek posilek : list) {
            System.out.println(posilek);
        }
        System.out.println(); // pusta linia oddzielająca dalszą część

        RodzajPosilku rodzajPosilku = pobierzRodzajPosilku(scanner);

        System.out.println("Podaj nazwę posiłku:");
        String nazwa = scanner.next();

        System.out.println("Pasujące produkty:");
        for (Posilek posilek : list) {
            // jeśli obiekt na liście ma nazwę i rodzaj
            // który odpowiada wpisanym wartości wpisanej przez użytkownika
            if (posilek.getNazwa().toUpperCase().contains(nazwa.toUpperCase()) &&
                    posilek.getRodzajPosilku() == rodzajPosilku){
                System.out.println(posilek);
            }
        }
    }

    private static RodzajPosilku pobierzRodzajPosilku(Scanner scanner) {
        RodzajPosilku rodzajPosilku = null;
        do {
            System.out.println("Podaj RodzajPosilku:");
            // (wypisujemy wszystkie dostepne opcje)
            System.out.println(Arrays.asList(RodzajPosilku.values()));
            String wybor = scanner.next();
            try {
                rodzajPosilku = RodzajPosilku.valueOf(wybor.toUpperCase());
            } catch (InputMismatchException ime) {
                System.out.println("Niepoprawny wybór, powtórz.");
            }
        } while (rodzajPosilku == null);
        return rodzajPosilku;
    }
}
