package com.sda.z92.zad3_sety;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(10, 12, 10, 10, 3, 4, 12, 12, 300, 12, 40, 55));
        System.out.println("Set: " + set);
        System.out.println("Set size: " + set.size());

        for (Integer wartosc : set) {
            System.out.println("Wartosc: " + wartosc);
        }
        set.remove(10);
        set.remove(12);
        System.out.println("Set: " + set);
    }
}
