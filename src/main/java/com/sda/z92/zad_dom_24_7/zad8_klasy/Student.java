package com.sda.z92.zad_dom_24_7.zad8_klasy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String imie;
    private String nazwisko;
    private String indeks;

    private List<Double> oceny = new ArrayList<>();

    public Double obliczSredniaOcen() throws BrakOcenStudentaException {
        if (oceny.isEmpty()) {
            throw new BrakOcenStudentaException();
        }
//            double sum = 0.0;
//            for (Double ocena : oceny) {
//                sum += ocena;
//            }
//            return sum / oceny.size(); // INFINITY

        OptionalDouble averageOptional = oceny.stream().mapToDouble(value -> value).average();
        return averageOptional.orElseThrow(BrakOcenStudentaException::new);
    }
}
