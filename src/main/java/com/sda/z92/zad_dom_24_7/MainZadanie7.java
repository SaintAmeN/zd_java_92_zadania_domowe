package com.sda.z92.zad_dom_24_7;

import com.sda.z92.zad_dom_24_7.zad7_klasy.KoszykProduktów;
import com.sda.z92.zad_dom_24_7.zad7_klasy.PodatekProduktu;
import com.sda.z92.zad_dom_24_7.zad7_klasy.Produkt;

import java.util.Scanner;

public class MainZadanie7 {
    // main do testowania działania
    public static void main(String[] args) {
        KoszykProduktów koszykProduktów = new KoszykProduktów();

        Produkt p1 = new Produkt("Ser", 2.3, PodatekProduktu.VAT_23);
        Produkt p2 = new Produkt("Mleko", 3.5, PodatekProduktu.VAT_23);
        Produkt p3 = new Produkt("Jajko", 0.3, PodatekProduktu.NO_VAT);
        Produkt p4 = new Produkt("Maka", 4.2, PodatekProduktu.VAT_23);
        Produkt p5 = new Produkt("Pasta do zebow", 4.2, PodatekProduktu.VAT_8);

        koszykProduktów.dodajProdukt(p1);
        koszykProduktów.dodajProdukt(p2);
        koszykProduktów.dodajProdukt(p3);
        koszykProduktów.dodajProdukt(p4);
        koszykProduktów.dodajProdukt(p5);

        System.out.println(koszykProduktów.podsumujRachunekBrutto());
        System.out.println(koszykProduktów.podsumujRachunekNetto());
        System.out.println(koszykProduktów.zwrocWartoscPodatku());
    }
}
