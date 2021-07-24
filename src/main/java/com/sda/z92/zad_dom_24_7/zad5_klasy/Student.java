package com.sda.z92.zad_dom_24_7.zad5_klasy;

import com.sda.z92.zad_dom_24_7.zad2_klasy.Plec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String nrIndeksu;
    private String imie;
    private String nazwisko;
    private Plec plec;

    @Override
    public String toString() {
        return "Student{" +
                "nrIndeksu='" + nrIndeksu + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
