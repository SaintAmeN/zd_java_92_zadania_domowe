package com.sda.z92.zad_31_7.abstrakcjaCzlonekRodziny;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //Utwórz interfejs ICzłonekRodziny i metodą
    //przedstawSie():void. Wykorzystaj interfejs i implementuj go w
    //klasach Matka, Ojciec, Syn, Córka.

    //1. dla klasy Matka niech instancja wypisuje wartość “i am mother”,
    //2. dla klasy Ojciec niech instancja wypisuje wartość “i am your father”,
    //3. dla klasy Córka niech instancja wypisuje wartość “i am daughter ;) ”,
    //4. dla klasy Syn niech instancja wypisuje wartość “who’s asking?”
    //5. Dopisz w interfejsie dodatkową metodę jestDorosły():boolean która zwraca dla rodziców true, dla dzieci false.
    //6. Stwórz w mainie kilka instancji powyższych klas.

    public static void main(String[] args) {
        List<ICzłonekRodziny> członekRodzinyList = new ArrayList<>();
        członekRodzinyList.add(new Ciocia("Betty"));
        członekRodzinyList.add(new Córka("Tosia"));
        członekRodzinyList.add(new Matka("Leia"));
        członekRodzinyList.add(new Syn("Marian"));
        członekRodzinyList.add(new Ojciec("Darth Vader"));
        członekRodzinyList.add(new Córka("Zosia"));
        członekRodzinyList.add(new Syn("Franek"));
        członekRodzinyList.add(new Ojciec("Luke"));

        for (ICzłonekRodziny czlonekRodziny : członekRodzinyList) {
            // mechanizm refleksji - mechanizm który pozwala dowiedzieć się informacji nt.budowy (pracującego) programu
            System.out.println("Obiekt klasy: " + czlonekRodziny.getClass().getName());
            //
            czlonekRodziny.przedstawSie();
            System.out.println(czlonekRodziny.jestDorosly());
            System.out.println();
        }

    }
    // Have the function OffLineMinimum(strArr) take the strArr parameter being passed which
    // will be an array of integers ranging from 1...n and the letter "E" and return the
    // correct subset based on the following rules. The input will be in the following
    // format: ["I","I","E","I",...,"E",...,"I"] where the I's stand for integers and
    // the E means take out the smallest integer currently in the whole set.
    // When finished, your program should return that new set with integers separated
    // by commas. For example: if strArr is ["5","4","6","E","1","7","E","E","3","2"]
    // then your program should return 4,1,5.

    //Przechowaj je w tablicy, a następnie iteruj i wypisuj w
    //kolejnych liniach ich metody ‘przedstawSie()’ oraz
    //“jestDorosły”
    //7. we wszystkich klasach dodaj pole imie.
    //8. Zmień metodę ‘przedstawSie()’ tak, aby poza treścią
    //wypisywała również imie członka rodziny. Imie przypisuj
    //w konstruktorze
    //9. *Zamień metodę przedstawSie():void na defaultową.
    //Domyślnie metoda ma wypisać “I am just a simple
    //family member”.


}
