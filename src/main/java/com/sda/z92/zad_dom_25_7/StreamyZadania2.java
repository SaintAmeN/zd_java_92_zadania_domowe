package com.sda.z92.zad_dom_25_7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StreamyZadania2 {
    public static void main(String[] args) {
        Person person1 = new Person("Jacek", "Kowalski", 18, true);
        Person person2 = new Person("Jacek", "Górski", 15, true);
        Person person3 = new Person("Andżelika", "Dżoli", 25, false);
        Person person4 = new Person("Wanda", "Ibanda", 12, false);
        Person person5 = new Person("Marek", "Marecki", 17, true);
        Person person6 = new Person("Johny", "Brawo", 25, true);
        Person person7 = new Person("Stary", "Pan", 80, true);
        Person person8 = new Person("Newbie", "Noob", 12, true);
        Person person9 = new Person("Newbies", "Sister", 19, false);
        List<String> languages1 = Arrays.asList("Java;Cobol;Cpp;Lisp".split(";"));
        List<String> languages2 = Arrays.asList("Java;Lisp".split(";"));
        List<String> languages3 = Arrays.asList("Java;Cobol;Cpp;Lisp;C#".split(";"));
        List<String> languages4 = Arrays.asList("C#;C;Cpp".split(";"));
        List<String> languages5 = Arrays.asList("Java;Assembler;Scala;Cobol".split(";"));
        List<String> languages6 = Arrays.asList("Java;Scala".split(";"));
        List<String> languages7 = Arrays.asList("C#;C".split(";"));
        List<String> languages8 = Collections.emptyList();
        List<String> languages9 = Arrays.asList("Java");
        Programmer programmer1 = new Programmer(person1, languages1);
        Programmer programmer2 = new Programmer(person2, languages2);
        Programmer programmer3 = new Programmer(person3, languages3);
        Programmer programmer4 = new Programmer(person4, languages4);
        Programmer programmer5 = new Programmer(person5, languages5);
        Programmer programmer6 = new Programmer(person6, languages6);
        Programmer programmer7 = new Programmer(person7, languages7);
        Programmer programmer8 = new Programmer(person8, languages8);
        Programmer programmer9 = new Programmer(person9, languages9);
        List<Programmer> programmers = Arrays.asList(programmer1, programmer2, programmer3, programmer4, programmer5, programmer6, programmer7, programmer8, programmer9);

        //Mając listę programistów i korzystając ze streamów:
        //a. uzyskaj listę programistów, którzy są mężczyznami
        List<Programmer> mezczyzniProgramisci = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMezczyzna())
                .collect(Collectors.toList());
        System.out.println("mezczyzniProgramisci: " + mezczyzniProgramisci);

        //b. uzyskaj listę niepełnoletnich programistów (obydwóch płci), którzy piszą w Cobolu
        List<Programmer> niepełnoletniCobolowcy = programmers.stream()
                .filter(programmer -> programmer.getPerson().getWiek() < 18)
                .filter(programmer -> programmer.getLanguages().contains("Cobol"))
                .collect(Collectors.toList());
        System.out.println("niepełnoletniCobolowcy: " + niepełnoletniCobolowcy);

        //c. uzyskaj listę programistów, którzy znają więcej, niż jeden język programowania
        List<Programmer> kumaciProgramisci = programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() > 1)
                .collect(Collectors.toList());
        System.out.println("kumaciProgramisci: " + kumaciProgramisci);

        //d. uzyskaj listę programistek, które piszą w Javie i Cpp
        List<Programmer> kumateProgramistki = programmers.stream()
                .filter(programmer -> !programmer.getPerson().isMezczyzna())
//                .filter(programmer -> programmer.getLanguages().contains("Java"))
//                .filter(programmer -> programmer.getLanguages().contains("Cpp"))
                .filter(programmer -> programmer.getLanguages().containsAll(Arrays.asList("Java", "Cpp")))
                .collect(Collectors.toList());
        System.out.println("kumateProgramistki: " + kumateProgramistki);

        //e. uzyskaj listę męskich imion
        List<String> meskieImiona = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMezczyzna())
                .map(programmer -> programmer.getPerson().getImie())
                .collect(Collectors.toList());
        System.out.println("meskieImiona: " + meskieImiona);

        //f. uzyskaj set wszystkich języków opanowanych przez programistów
        Set<String> ogarnieteJezyki = programmers.stream()
//                .map(programmer -> programmer.getLanguages())                 // List<List<String>> // zamiast tego:
                .flatMap(programmer -> programmer.getLanguages().stream())      // List<String>
                .collect(Collectors.toSet());
        System.out.println("ogarnieteJezyki: " + ogarnieteJezyki);

        //g. uzyskaj listę nazwisk programistów, którzy znają więcej, niż dwa języki
        List<String> kumaciProgramisciNazwiska = programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() > 2)
                .map(programmer -> programmer.getPerson().getNazwisko())
                .collect(Collectors.toList());
        System.out.println("kumaciProgramisciNazwiska: " + kumaciProgramisciNazwiska);

        //h. * sprawdź, czy istnieje chociaż jedna osoba, która nie zna żadnego języka
        boolean czyIstniejeNieogarnietaOsoba = programmers.stream()
//                .filter(programmer -> programmer.getLanguages().isEmpty())
//                .map(programmer -> programmer.getPerson())
//                .findFirst().isPresent();
                .anyMatch(programmer -> programmer.getLanguages().isEmpty());
        System.out.println("czyIstniejeNieogarnietaOsoba: " + czyIstniejeNieogarnietaOsoba);

        //i. * uzyskaj ilość wszystkich języków opanowanych przez programistki
        long jezykiProgramistek = programmers.stream()
                .filter(programmer -> !programmer.getPerson().isMezczyzna())
                .flatMap(programmer -> programmer.getLanguages().stream())
                .distinct()
//                .collect(Collectors.toList());
                .count();
        System.out.println("jezykiProgramistek: " + jezykiProgramistek);

        //j. **Używając streamów znajdź długość najdłuższej linii w wybranym przez ciebie pliku.
        // ja jako wybrany plik wybieram ten który aktualnie implementuje:
        String plik = "src/main/java/com/sda/z92/zad_dom_25_7/StreamyZadania2.java";

        try(BufferedReader reader = new BufferedReader(new FileReader(plik))){
            Optional<String> najdluzszaLinia = reader.lines()
                    .max(Comparator.comparing(String::length));
            if(najdluzszaLinia.isPresent()){
                System.out.println(najdluzszaLinia.get());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
