package com.sda.z92.zad_dom_31_7.zad_4;

import com.sda.z92.zad_dom_31_7.zad_5.Gender;
import com.sda.z92.zad_dom_31_7.zad_5.WypelnionyFormularz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        long iloscLinii = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("Zadanie5.txt"))) {
//            String linia;
//            while ((linia = reader.readLine()) != null) {
//                iloscLinii++;
//            }
            iloscLinii = reader.lines().count();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // zadanie 5
        System.out.println("Ilość linii = " + iloscLinii);

        // zadanie 6
        int iloscFormularzy = (int) (iloscLinii / 5);
        Set<WypelnionyFormularz> formularzList = new HashSet<>();

        Map<String, Map<String, Integer>> mapaPytanieNaOdpowiedzNaIlosc = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Zadanie5.txt"))) {
            for (int i = 0; i < iloscFormularzy; i++) {
                String data = reader.readLine().replace("dataUrodzenia=", "");
                umiescWMapie(mapaPytanieNaOdpowiedzNaIlosc, "dataUrodzenia=", data);

                String gender = reader.readLine().replace("gender=", "");
                umiescWMapie(mapaPytanieNaOdpowiedzNaIlosc, "gender=", gender);

                String pali = reader.readLine().replace("pali=", "");
                umiescWMapie(mapaPytanieNaOdpowiedzNaIlosc, "pali=", pali);

                String chodziZestresowany = reader.readLine().replace("chodziZestresowany=", "");
                umiescWMapie(mapaPytanieNaOdpowiedzNaIlosc, "chodziZestresowany=", chodziZestresowany);

                reader.readLine();
                formularzList.add(new WypelnionyFormularz(
                        LocalDate.parse(data),
                        Gender.valueOf(gender),
                        Boolean.parseBoolean(pali),
                        Boolean.parseBoolean(chodziZestresowany)
                ));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (WypelnionyFormularz wypelnionyFormularz : formularzList) {
            System.out.println(wypelnionyFormularz);
        }

        OptionalDouble sredniWiekKobiety = formularzList.stream()
                .filter(wypelnionyFormularz -> wypelnionyFormularz.getGender() == Gender.FEMALE)
                .mapToDouble(form -> Period.between(form.getDataUrodzenia(), LocalDate.now()).getYears())
                .average();

        OptionalDouble sredniWiekMezczyzni = formularzList.stream()
                .filter(wypelnionyFormularz -> wypelnionyFormularz.getGender() == Gender.MALE)
                .mapToDouble(form -> Period.between(form.getDataUrodzenia(), LocalDate.now()).getYears())
                .average();

        Long iloscKobiet = formularzList.stream()
                .filter(wypelnionyFormularz -> wypelnionyFormularz.getGender() == Gender.FEMALE)
                .count();
        Long iloscMezczyzn = formularzList.stream()
                .filter(wypelnionyFormularz -> wypelnionyFormularz.getGender() == Gender.MALE)
                .count();

        System.out.println("Kobiet jest: " + iloscKobiet + " mezczyzn: " + iloscMezczyzn);
        for (Map.Entry<String, Map<String, Integer>> pytanieIOdpowiedzi : mapaPytanieNaOdpowiedzNaIlosc.entrySet()) {
            System.out.println();
            System.out.println("Pytanie: " + pytanieIOdpowiedzi.getKey());
            for (Map.Entry<String, Integer> odpowiedzNaIlosc : pytanieIOdpowiedzi.getValue().entrySet()) {
                System.out.println("Odp: " + odpowiedzNaIlosc.getKey() + " udzielona: " + odpowiedzNaIlosc.getValue());
            }
        }
    }

    private static void umiescWMapie(Map<String, Map<String, Integer>> mapaPytanieNaOdpowiedzNaIlosc, String pytanie, String odpowiedz) {
        pytanie = pytanie.toUpperCase();
        odpowiedz = odpowiedz.toUpperCase();

        if (!mapaPytanieNaOdpowiedzNaIlosc.containsKey(pytanie)) {
            mapaPytanieNaOdpowiedzNaIlosc.put(pytanie, new HashMap<>());
        }

        Map<String, Integer> mapaOdpowiedzNaIlosc = mapaPytanieNaOdpowiedzNaIlosc.get(pytanie);
        if (mapaOdpowiedzNaIlosc.containsKey(odpowiedz)) {
            mapaOdpowiedzNaIlosc.put(odpowiedz, mapaOdpowiedzNaIlosc.get(odpowiedz) + 1);
        } else {
            mapaOdpowiedzNaIlosc.put(odpowiedz, 1);
        }
    }
}
