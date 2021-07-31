package com.sda.z92.zad_dom_31_7.zad_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class Main_zad7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            boolean czyWypelniaszPonownie = true;
            do {
                LocalDate dataUrodzenia = pobierzDateUrodzenia(scanner);
                Gender gender = pobierzPlec(scanner);
                boolean pali = zadajPytanieYN(scanner, "Czy palisz papierosy?");
                boolean chodziZestresowany = pobierzCzyZyjeWStresie(scanner);

                LocalDate dataSmierci;
                if (gender == Gender.MALE) {
                    dataSmierci = dataUrodzenia.plusYears(71);
                } else {
                    dataSmierci = dataUrodzenia.plusYears(81);
                }

                if (gender == Gender.MALE) {
                    boolean czyPlanujeszMiecZone = zadajPytanieYN(scanner, "Czy planujesz miec zone?");
                    dataSmierci = dataSmierci.plusYears(2);
                }

                if (pali) {
                    dataSmierci = dataSmierci.minusYears(9);
                    dataSmierci = dataSmierci.minusMonths(3);
                }
                if (chodziZestresowany) {
                    if (new Random().nextInt(100) < 10) {
                        dataSmierci = dataUrodzenia.plusYears(60);
                    }
                }
                System.out.println("Umrzesz w wieku: " + dataSmierci);

                // ################################
                zapiszDoPliku(new WypelnionyFormularz(dataUrodzenia, gender, pali, chodziZestresowany));

                czyWypelniaszPonownie = zadajPytanieYN(scanner, "Czy chcesz wypełnić ten formularz ponownie?");
            } while (czyWypelniaszPonownie);
        } catch (IWantToGoHomeAndNotFinishThisException iwthganfte) {
            System.out.println("Spoko, nie chcesz to nie kończ formularza. :) ");
        }
    }

    private static void zapiszDoPliku(WypelnionyFormularz formularz) {
        String sciezkaRelatywna = "Zadanie5.txt";
        File sciezka = new File(sciezkaRelatywna);
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(sciezka, true))) {
            writer.println(formularz);
        } catch (FileNotFoundException exception) {
            System.err.println("Nie mogę zapisać do pliku");
        }
    }

    private static boolean zadajPytanieYN(Scanner scanner, String pytanie) throws IWantToGoHomeAndNotFinishThisException {
        System.out.println(pytanie);
        String wpisanawartosc = scanner.nextLine().toUpperCase();
        if ("QUIT".equalsIgnoreCase(wpisanawartosc.toUpperCase())) {
            throw new IWantToGoHomeAndNotFinishThisException();
        }

        return "YES".equalsIgnoreCase(wpisanawartosc) || "TAK".equalsIgnoreCase(wpisanawartosc) ||
                (wpisanawartosc.length() == 1 && (wpisanawartosc.charAt(0) == 'T' || wpisanawartosc.charAt(0) == 'Y'));
    }

    private static boolean pobierzCzyZyjeWStresie(Scanner scanner) throws IWantToGoHomeAndNotFinishThisException {
        return zadajPytanieYN(scanner, "Czy żyjesz w stresie?: ");
    }

    private static Gender pobierzPlec(Scanner scanner) throws IWantToGoHomeAndNotFinishThisException {
        Gender gender = null;
        do {
            try {
                System.out.println("Kobieta, czy mężczyzna?: ");
                for (Gender plec : Gender.values()) {
                    System.out.println(" - " + plec);
                }
                String wpisanawartosc = scanner.nextLine();
                if ("QUIT".equalsIgnoreCase(wpisanawartosc.toUpperCase())) {
                    throw new IWantToGoHomeAndNotFinishThisException();
                }
                gender = Gender.valueOf(wpisanawartosc.toUpperCase());

            } catch (IllegalArgumentException iae) {
                System.err.println("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (gender == null);
        return gender;
    }

    private static LocalDate pobierzDateUrodzenia(Scanner scanner) throws IWantToGoHomeAndNotFinishThisException {
        LocalDate date = null;
        do {
            try {
                System.out.println("Podaj datę urodzenia w formacie: yyyy.MM.dd:");
                String wpisanawartosc = scanner.nextLine();
                if ("QUIT".equalsIgnoreCase(wpisanawartosc.toUpperCase())) {
                    throw new IWantToGoHomeAndNotFinishThisException();
                }

                DateTimeFormatter formatczasu = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                date = LocalDate.parse(wpisanawartosc, formatczasu);
            } catch (DateTimeParseException iae) {
                System.err.println("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (date == null);
        System.out.println("Data urodzenia: " + date);
        return date;
    }
}
