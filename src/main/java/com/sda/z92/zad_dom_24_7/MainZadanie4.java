package com.sda.z92.zad_dom_24_7;

import com.sda.z92.zad_dom_24_7.zad3_klasy.Student;
import com.sda.z92.zad_dom_24_7.zad4_klasy.ParaLiczb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainZadanie4 {
    public static void main(String[] args) {
        Set<ParaLiczb> zbior = new HashSet<>();

        zbior.add(new ParaLiczb(1, 2));
        zbior.add(new ParaLiczb(2, 1));
        zbior.add(new ParaLiczb(1, 1));
        zbior.add(new ParaLiczb(1, 2));

        for (ParaLiczb paraLiczb : zbior) {
            System.out.println(paraLiczb);
        }
    }
}
