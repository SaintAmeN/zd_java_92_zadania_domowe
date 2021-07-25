package com.sda.z92.zad_dom_24_7.zad7_klasy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KoszykProduktów {
    private List<Produkt> zbior = new ArrayList<>();

    public void dodajProdukt(Produkt p){
        zbior.add(p);
    }

    public void wypiszRachunek(){
        System.out.println("\nProdukty");
        for (Produkt produkt : zbior) {
            System.out.println(produkt);
        }
        System.out.println();
    }

    public double podsumujRachunekNetto(){
        double suma = 0;
        for (Produkt produkt : zbior) {
            suma += produkt.getCenaNetto();
        }
        return suma;
    }

    public double podsumujRachunekBrutto(){
        double suma = 0;
        for (Produkt produkt : zbior) {
            suma += produkt.obliczCeneBrutto();
        }
        return suma;
    }

    public double podsumujRachunekNettoStream(){
        return zbior.stream()
//                .mapToDouble(Produkt::getCenaNetto)
                .mapToDouble(produkt -> produkt.getCenaNetto())
                .sum();
    }

    public double podsumujRachunekBruttoStream(){
        return zbior.stream()
//                .mapToDouble(Produkt::obliczCeneBrutto)
                .mapToDouble(produkt -> produkt.obliczCeneBrutto())
                .sum();
    }

    public double zwrocWartoscPodatku(){
        return podsumujRachunekBrutto() - podsumujRachunekNetto();
    }
}
