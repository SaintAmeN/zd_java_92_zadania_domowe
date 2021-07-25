package com.sda.z92.zad_dom_25_7;

import java.util.*;
import java.util.stream.Collectors;

public class MainZad1 {
    public static void main(String[] args) {
        Person person1 = new Person("Jacek","Kowalski",18,true);
        Person person2 = new Person("Jacek","Górski",15,true);
        Person person3 = new Person("Andżelika","Dżoli",25,false);
        Person person4 = new Person("Wanda","Ibanda",12,false);
        Person person5 = new Person("Marek","Marecki",17,true);
        Person person6 = new Person("Johny","Brawo",25,true);
        Person person7 = new Person("Stary","Pan",80,true);
        Person person8 = new Person("Newbie","Noob",12,true);
        Person person9 = new Person("Newbies","Sister",19,false);
        List<Person> people = new ArrayList<Person>(Arrays.asList(person1, person2, person3,
                person4, person5, person6, person7, person8, person9));

        //a. uzyskaj listę mężczyzn
        List<Person> listaMezczyzn = people.stream()
                .filter(person -> person.isMezczyzna())
                .collect(Collectors.toList());
        System.out.println("Lista mezczyzn: " + listaMezczyzn);

        //b. uzyskaj listę dorosłych kobiet (filter)
        List<Person> listaDoroslychKobiet = people.stream()
                .filter(person -> !person.isMezczyzna())
                .filter(person -> person.getWiek() >= 18)
                .collect(Collectors.toList());
        System.out.println("Dorosle kobiety: " + listaDoroslychKobiet);

        //c. uzyskaj Optional<Person> z dorosłym Jackiem findAny/findfirst
        Optional<Person> doroslyJacek = people.stream()
                .filter(person -> person.getImie().equals("Jacek"))
                .filter(person -> person.getWiek() >= 18)
                .findAny();
        System.out.println("Dorosly Jacek: " + doroslyJacek);

        //d. uzyskaj listę wszystkich nazwisk osób, które są w przedziale wiekowym: 15-19
        //(filter)
        List<String> listaNazwiskOsobWPrzedzialeWiekowym = people.stream()
                .filter(person -> person.getWiek() >= 15)
                .filter(person -> person.getWiek() <= 19)
                .map(person -> person.getNazwisko())
                .collect(Collectors.toList());
        System.out.println("Osoby z przedzialu wiekowego: " + listaNazwiskOsobWPrzedzialeWiekowym);

        //e. * uzyskaj sumę wieku wszystkich osób (sum)
        Integer suma = people.stream()
                .mapToInt(person -> person.getWiek())
                .sum();
        System.out.println("Suma wieku: " + suma);

        //f. * uzyskaj średnią wieku wszystkich mężczyzn (average)
        OptionalDouble srednia = people.stream()
                .filter(person -> person.isMezczyzna())
                .mapToDouble(person -> person.getWiek())
                .average();
        // TODO: wyciagnac z optionala
        System.out.println("Srednia wieku: " + srednia);

        //g. ** znajdź najstarszą osobę w liście (findFirst)
        Optional<Person> najstarsza1 = people.stream()
                .sorted(Comparator.comparing(Person::getWiek).reversed())
                .findFirst();
        System.out.println("Najstarsza: " + najstarsza1);

        Optional<Person> najstarsza2 = people.stream()
                .max(Comparator.comparing(Person::getWiek));
        System.out.println("Najstarsza: " + najstarsza2);

    }
}
