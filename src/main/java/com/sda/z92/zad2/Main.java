package com.sda.z92.zad2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Deklaracja listy
        List<Integer> integerList = new ArrayList<>();
        // Deklaracja random'a
        Random random = new Random();

        // pętla for i - 10 iteracji
        for (int i = 0; i < 10; i++) {
            // wewnątrz pętli losujemy wartości / liczby i dodajemy do listy
            int wartosc = random.nextInt(500);
            integerList.add(wartosc);
        }
        // wypisanie całej listy
        System.out.println("Lista, pierwsze wypisanie: " + integerList);

        // ## Obliczanie sumy
        // deklaracja zmiennej suma
        int suma = 0;
//        double suma = 0;

        // pętla ma wykonać się tyle iteracji ile jest elementów
        for (int i = 0; i < integerList.size(); i++) {
            // sumujemy elementy w pętli
            // wskazówka: int wartosc = list.get(i);
            int wartosc = integerList.get(i);

            suma += wartosc;
        }
        // poza pętlą wypisujemy sumę i średnią
        System.out.println("Lista, drugie wypisanie: " + integerList);
        System.out.println("Suma: " + suma);
        double srednia = suma / (double) integerList.size();
        //               ^int    ^double

        System.out.println("Srednia: " + srednia);

        // ## Stworzenie kopii
        // należy pamiętać że kolekcje posiadają konstruktor kopiujący
        // List<Integer> lista_orginalna = new ArrayList<>();
        // ... dodajemy jakieś elementy.. coś się dzieje
        // List<Integer> lista_kopia = new ArrayList<>(lista_orginalna);
        List<Integer> integerList_Copy = new ArrayList<>(integerList);

        // sortowanie i wypisanie
        // lista_kopia.sort()
        // Collections.sort(lista_kopia);
        Collections.sort(integerList_Copy);

        // ############# Część druga
        // mediana to środkowy element (jeśli taki jest)
        // mediana to średnia dwóch środkowych elementów (jeśli ilość jest parzysta)
        // lista.size() - rozmiar
        // lista.size()%2 - parzystość
        //
        // Przypadek gdy ilość elementów jest parzysta
        // lista.size() = 10
        // 0 1 2 3 (4 5) 6 7 8 9
        double mediana;
        if (integerList_Copy.size() % 2 == 0) {
            // (lista.size() / 2 - 1)
            // lista.get( (lista.size() / 2) - 1 )

            int element1 = integerList_Copy.get((integerList_Copy.size() / 2) - 1);
            int element2 = integerList_Copy.get((integerList_Copy.size() / 2));
            mediana = (element1 + element2) / 2.0;
        } else {
            // Przypadek gdy ilość elementów jest nieparzysta
            // 0 1 2 3 4 5 6 7 8 9
            // lista.get(?)
            // (lista.size() / 2) = 5 index = 6 element
            // lista.get( (lista.size() / 2) )

            mediana = integerList_Copy.get(integerList_Copy.size() / 2);
        }
        System.out.println("Mediana: " + mediana);

        // Pamiętajcie w tym miejscu pracować na liście pierwszej (orginalnej)
        // zadeklarowanie zmiennej minimum / maximum
        int min = integerList.get(0);
        int max = integerList.get(0);

        // pętla która szuka min/max
        for (int i = 1; i < integerList.size(); i++) {
            // jeśli trafiliśmy na liczbę mniejszą to zapisujemy nowe minimum
            if (min > integerList.get(i)) {
                min = integerList.get(i);
            }

            // jeśli trafiliśmy na liczbę większą to zapisujemy nowe maksimum
            if (max < integerList.get(i)) {
                max = integerList.get(i);
            }
        }
        System.out.println("Max: " + max + " Min: " + min);

        //     - po znalezieniu elementu znajdź index elementu maksymalnego używając kolejnej pętli for
        int minIndex = 0;
        int maxIndex = 0;

        // pętla która szuka indeksów min/max
        for (int i = 0; i < integerList.size(); i++) {
            // jeśli trafiliśmy na liczbę mniejszą to zapisujemy nowe minimum
            if (min == integerList.get(i)) {
                minIndex = i;
            }

            // jeśli trafiliśmy na liczbę większą to zapisujemy nowe maksimum
            if (max == integerList.get(i)) {
                maxIndex = i;
            }
        }
        System.out.println("Max index: " + maxIndex + " Min index: " + minIndex);
        // - po znalezieniu elementów (największy i najmniejszy) znajdź index posługując się metodą indexof
        System.out.println("Max index: " + integerList.indexOf(max) + " Min index: " + integerList.indexOf(min));
    }
}
