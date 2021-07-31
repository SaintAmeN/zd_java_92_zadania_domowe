package com.sda.z92.zad_31_7;

import java.util.Optional;
import java.util.Scanner;

public class ZadanieObywatel {
    public static void main(String[] args) {
        //Stwórz klasę Obywatel, która posiada:
        //pesel, imie, nazwisko,

        //Stwórz klasę RejestrObywateli która posiada wewnątrz (jako pole) mapę obywateli. Dodaj do Rejestru Obywateli metody:
        //- dodajObywatela(String pesel, String imie, String nazwisko):void
        //- znajdźObywateliUrodzonychPrzed(int rok):List<Obywatel>
        //- znajdźObywateliZRokuZImieniem(int rok, String imie):List<Obywatel>
        //- znajdźObywatelaPoNazwisku(String nazwisko):List<Obywatel>
        //- znajdźObywatelaPoPeselu(String pesel):Obywatel

        RejestrObywateli rejestrObywateli = new RejestrObywateli();

        Scanner scanner = new Scanner(System.in);
        String komenda;
        boolean uruchomiony = true;
        do {
            komenda = scanner.nextLine();
            System.out.println(komenda);
            // podział komendy na słowa
            String[] slowa = komenda.split(" ");
            String akcja = slowa[0];

            if (akcja.equalsIgnoreCase("dodaj")) {
                // dodaj pawel gawel 12301230
                rejestrObywateli.dodajObywatela(slowa[1], slowa[2], slowa[3]);
            } else if (akcja.equalsIgnoreCase("znajdz_pesel")) {
                // znajdz_pesel 12301230
                Optional<Obywatel> optionalOb = rejestrObywateli.znajdźObywatelaPoPeselu(slowa[1]);
                System.out.println(optionalOb);
            } else if (akcja.equalsIgnoreCase("quit")) {
                System.out.println("Zamykam program.");
                uruchomiony = false;
            }
        } while (uruchomiony);

        System.out.println("Opuszczam pętlę.");
    }
}
