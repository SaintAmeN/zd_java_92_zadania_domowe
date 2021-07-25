package com.sda.z92.zad_dom_24_7.zad8_klasy;

public class StudentNieIstniejeException extends RuntimeException{
    public StudentNieIstniejeException() {
        super("Nie znaleziono studenta o podanym indeksie!");
    }
}
