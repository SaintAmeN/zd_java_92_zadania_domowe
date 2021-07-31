package com.sda.z92.zad_31_7;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class OffLineMinimum {
    // Have the function OffLineMinimum(strArr) take the strArr parameter being passed which
    // will be an array of integers ranging from 1...n and the letter "E" and return the
    // correct subset based on the following rules:

    // The input will be in the following format: ["I","I","E","I",...,"E",...,"I"]
    //          where the I's stand for integers
    //          and
    //          the E means take out the smallest integer currently in the whole set.
    //
    // When finished, your program should return that new set with integers separated
    // by commas. For example: if strArr is []
    // then your program should return 4,1,5.
    public static String OffLineMinimum(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();

        TreeSet<Integer> set = new TreeSet<>();
        for (String element : strArr) {
            if (element.equals("E")) {
                // zakończenie fazy

                Integer el = set.first();
                stringBuilder.append(el).append(",");
                set.remove(el);
            } else {
                // integer
                int liczba = Integer.parseInt(element);
                set.add(liczba);
            }
        }

        if (stringBuilder.length() > 0) {
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        } else {
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(OffLineMinimum(new String[]{"5", "4", "6", "E", "1", "7", "E", "E", "3", "2"}));
    }
}
