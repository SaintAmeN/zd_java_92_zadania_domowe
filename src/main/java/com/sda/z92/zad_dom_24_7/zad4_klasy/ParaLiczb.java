package com.sda.z92.zad_dom_24_7.zad4_klasy;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode()
@ToString()
@NoArgsConstructor
public class ParaLiczb {
    private int liczbaA;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private int liczbaB;

    public ParaLiczb(int liczbaA, int liczbaB) {
        this.liczbaA = liczbaA;
        this.liczbaB = liczbaB;
    }

//    @Override
//    public String toString() {
//        return "ParaLiczb{" +
//                "liczbaA=" + liczbaA +
//                ", liczbaB=" + liczbaB +
//                '}';
//    }
}
