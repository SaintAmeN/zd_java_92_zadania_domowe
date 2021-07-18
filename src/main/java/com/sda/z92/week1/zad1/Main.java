package com.sda.z92.week1.zad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // deklaracja listy
        // dodanie elementów do listy
        List<String> list = new ArrayList<>(Arrays.asList(
                "10030",
                "3004",
                "4000",
                "12355",
                "12222",
                "67888",
                "111200",
                "225355",
                "2222",
                "1111",
                "3546",
                "138751",
                "235912"
        ));

        int index = znajdzElementNaIndeksie(list, "138751");

        // sprawdzenie metodą contains
        //     -- wypisanie wyniku sprawdzenia na ekran
        boolean contains = sprawdzCzyZawieraElement(list, "67888");

        // sprawdzenie metodą contains
        //     -- wypisanie wyniku sprawdzenia na ekran
        contains = sprawdzCzyZawieraElement(list, "67889");

        // usuniecie elementu
        list.remove("67888");
        list.remove("67889");

        // sprawdzenie metodą indexof
        //     -- wypisanie wyniku sprawdzenia na ekran
        index = znajdzElementNaIndeksie(list, "138751");

        // sprawdzenie metodą contains
        //     -- wypisanie wyniku sprawdzenia na ekran
        contains = sprawdzCzyZawieraElement(list, "67888");

        // sprawdzenie metodą contains
        //     -- wypisanie wyniku sprawdzenia na ekran

        contains = sprawdzCzyZawieraElement(list, "67889");
        // wypisanie pętlą forEach
        for (String element : list) {
            System.out.println(element);
        }

        // wypisanie pętlą forEach (w jednej linii)
        System.out.println();
        for (String element : list) {
            System.out.print(element + " ");
        }
    }

    public static boolean sprawdzCzyZawieraElement(List<String> list, String wartoscSzukana) {
        boolean contains = list.contains(wartoscSzukana);
        System.out.println("Czy udało się znaleźć wartość " + wartoscSzukana + ": " + contains);
        return contains;
    }

    public static int znajdzElementNaIndeksie(List<String> list, String wartoscSzukana) {
        // sprawdzenie metodą indexof
        //     -- wypisanie wyniku sprawdzenia na ekran
        int index = list.indexOf(wartoscSzukana);
        if (index != -1) {
            System.out.println("Indeks wartości to : " + index);
        } else {
            System.out.println("Nie znaleziono wartości " + wartoscSzukana);
        }
        return index;
    }
}
