package com.sda.z92.zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // deklaracja listy
//        List<String> list = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // deklarujemy scanner / random
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // pętla która wykonuje się 5 razy
        for (int i = 0; i < 5; i++) {
            // w pętli odczytujemy wartość int ze scannera
            int wartosc = scanner.nextInt();

            // dodajemy wartość do listy
            list.add(wartosc);
        }
        // wypisanie listy
        System.out.println("Lista, pierwsze wypisanie: " + list);

        // pętla która wykonuje się 5 razy
        for (int i = 0; i < 5; i++) {
            // w pętli odczytujemy wartość int ze scannera
            int wartosc = random.nextInt(500);

            // dodajemy wartość do listy
            list.add(wartosc);
        }
        // wypisanie listy
        System.out.println("Lista, drugie wypisanie: " + list);

    }
}
